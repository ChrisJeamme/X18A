package gestionReseauServeurLourd;

import bdd.BDD;
import bdd.InteractionBDD;
import donnees.Chat;
import donnees.Depense;
import donnees.Evenement;
import donnees.Message;
import donnees.Participe;
import donnees.Utilisateur;
import xml.ParserXML;
import xml.TypeRequete;

/**
 * Thread de gestion du serveur (client lourd)
 *
 */
public class GestionServeur extends Thread
{
	/**
	 *  Gère les connexions TCP avec les clients
	 */
	ServeurTCP serveur;
	/**
	 *  Gère la base de donnée MySQL
	 */
	BDD bdd;
	/**
	 *  Sert à stopper le thread proprement
	 */
	boolean continuer = true;
	
	/**
	 *  Le constructeur initialise la BDD et la socket serveur
	 * @param port
	 */
	public GestionServeur(int port)
	{
		//Connexion à la base de donnée
		bdd = new BDD();
		
		//Lancement du serveur
		serveur = new ServeurTCP(port);
		serveur.initialiser();
	}
	
	/**
	 *  Lance la boucle d'attente des nouvelles connexions
	 */
	public void run()
	{
		boucleServeur();
	}

	/**
	 *  Attend les requetes et demande leur traitement
	 */
	private void boucleServeur()
	{

		while(continuer)
		{
			//On attend une connexion d'un client lourd
			serveur.attente();
			String requete = serveur.recevoir();

			//On lance un Thread qui va traiter la requete
			TraitementRequete traitement = new TraitementRequete(serveur, bdd, requete);
			traitement.start();
		}		
	}
	
	/**
	 *  Sert à stopper le thread proprement
	 */
	public void arret()
	{
		continuer = false;
	}
}
