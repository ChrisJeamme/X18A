package serveur;

import javax.swing.text.Utilities;

import bdd.BDD;
import bdd.InteractionBDD;
import donnees.Depense;
import donnees.Evenement;
import donnees.Message;
import donnees.Utilisateur;
import xml.ParserXML;
import xml.TypeRequete;

public class GestionServeur
{
	Serveur serveur;
	BDD bdd;
	
	public GestionServeur()
	{
		bdd = new BDD();
		
		serveur = new Serveur(18458);
		serveur.initialiser();
		
		for(;;)
		{
			//On attend une connexion du client lourd
			String reception = serveur.attente();
			reception = ParserXML.clean(reception);
			System.out.println(reception);
			
			//On analyse le type de requet (Envoi/Demande d'objet)
			TypeRequete type = ParserXML.analyserType(reception);
			
			//On traite
			switch(type)
			{
			case DEMANDE_OBJET:		//Le client lourd nous demande de lui envoyer un objet
				//ParserXML.analyserDemande(reception);
				break;
			case ENVOI_EVENEMENT:	//Le client lourd nous demande de créer cet evenement
				Evenement evenement = ParserXML.lireEvenement(reception);
				InteractionBDD.ajoutEvenement(bdd, evenement);
				break;
			case ENVOI_DEPENSE:		//Le client lourd nous demande de créer cette dépense
				Depense depense = ParserXML.lireDepense(reception);
				InteractionBDD.ajoutDepense(bdd, depense);
				break;
			case ENVOI_MESSAGE:		//Le client lourd nous demande de créer ce message
				Message message = ParserXML.lireMessage(reception);
				InteractionBDD.ajoutMessage(bdd, message);
				break;
			case ENVOI_UTILISATEUR:	//Le client lourd nous demande de créer cet utilisateur
				Utilisateur utilisateur = ParserXML.lireUtilisateur(reception);
				InteractionBDD.ajoutUtilisateur(bdd, utilisateur);
				break;
			case INCONNU:
				System.err.println("Requete recu non reconnue");
				break;
			}
		}
		
		
		
		//InteractionBDD.
				
	}
}
