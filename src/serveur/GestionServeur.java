package serveur;

import bdd.BDD;
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
			System.out.println(reception);
			
			//On analyse le type de requet (Envoi/Demande d'objet)
			TypeRequete type = ParserXML.analyserType(reception);
			
			//On traite
			switch(type)
			{
			case DEMANDE_OBJET:
				ParserXML.analyserDemande(reception);
				break;
			case ENVOI_OBJET:
				ParserXML.analyserEnvoi(reception);
				break;
			case INCONNU:
				System.err.println("Requete recu non reconnue");
				break;
			}
		}
		
		
		
		//InteractionBDD.
				
	}
}
