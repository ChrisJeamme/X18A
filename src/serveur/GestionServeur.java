package serveur;

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
			serveur.attente();
			String reception = serveur.recevoir();
			//reception = ParserXML.clean(reception);
			System.out.println(reception);
			
			//On analyse le type de requet (Envoi/Demande d'objet)
			TypeRequete type = ParserXML.analyserType(reception);
			
			//On traite
			switch(type)
			{
			
			//Demande d'objets
			
			case DEMANDE_CHAT:		//Le client lourd nous demande de lui envoyer un objet
				int idC = ParserXML.analyserDemande1Id(reception);
				Chat c = InteractionBDD.recupMessagesDeEvenement(bdd, idC);
				InteractionAvecClient.envoyerChat(serveur, c);
				break;
			case DEMANDE_EVENEMENT:		//Le client lourd nous demande de lui envoyer un objet
				int idE = ParserXML.analyserDemande1Id(reception);
				Evenement e = InteractionBDD.recupEvenementsAvecID(bdd, idE);
				InteractionAvecClient.envoyerEvenement(serveur, e);
				break;
			case DEMANDE_DEPENSE:		//Le client lourd nous demande de lui envoyer un objet
				//int id[2] = ParserXML.analyserDemande2Id(reception);
				//String date = ParserXML.analyserDemandeDate(reception);
				//Depense d = InteractionBDD.recupDepenses(bdd, id[0], id[1], date);
				//InteractionAvecClient.envoyerDepense(serveur, d);
				break;
			case DEMANDE_UTILISATEUR:		//Le client lourd nous demande de lui envoyer un objet
				int idU = ParserXML.analyserDemande1Id(reception);
				Utilisateur u = InteractionBDD.recupUtilisateurAvecID(bdd, idU);
				InteractionAvecClient.envoyerUtilisateur(serveur, u);
				break;
				
			case CONNEXION:
				String pseudo = ParserXML.analyserConnexionPseudo(reception);
				String mdp = ParserXML.analyserConnexionMdp(reception);
				Utilisateur u2 = InteractionBDD.verificationConnexion(bdd, pseudo, mdp);
				//System.out.println("Reception de l'user de la BDD pour connexion: "+u2);
				if(u2==null) //Si la connexion a échoué
					u2 = new Utilisateur("", "", "", "", ""); //id sera à -1 
				InteractionAvecClient.envoyerUtilisateur(serveur, u2);
				break;
				
			// Envoi d'objets
				
			case ENVOI_EVENEMENT:	//Le client lourd nous demande de créer cet evenement
				System.out.println("(Server) Recu: Evenement à ajouter");
				Evenement evenement = ParserXML.lireEvenement(reception);
				InteractionBDD.ajoutEvenement(bdd, evenement);
				InteractionAvecClient.envoyerEvenement(serveur, evenement);
				break;
			case ENVOI_DEPENSE:		//Le client lourd nous demande de créer cette dépense
				System.out.println("(Server) Recu: Dépense à ajouter");
				Depense depense = ParserXML.lireDepense(reception);
				InteractionBDD.ajoutDepense(bdd, depense);
				InteractionAvecClient.envoyerDepense(serveur, depense);
				break;
			case ENVOI_MESSAGE:		//Le client lourd nous demande de créer ce message
				System.out.println("(Server) Recu: Message à ajouter");
				Message message = ParserXML.lireMessage(reception);
				InteractionBDD.ajoutMessage(bdd, message);
				serveur.envoyer("ok\nover"); //On a pas à renvoyer d'id pour celui ci
				break;
			case ENVOI_UTILISATEUR:	//Le client lourd nous demande de créer cet utilisateur
				System.out.println("(Server) Recu: Utilisateur à ajouter");
				Utilisateur utilisateur = ParserXML.lireUtilisateur(reception);
				InteractionBDD.ajoutUtilisateur(bdd, utilisateur);
				System.out.println("OUais ouais?");
				InteractionAvecClient.envoyerUtilisateur(serveur, utilisateur);
				System.out.println("envoyé");
				break;
			case ENVOI_PARTICIPE:
				System.out.println("(Server) Recu: Participe à ajouter");
				Participe participe = new Participe();
				InteractionBDD.ajoutParticipe(bdd, participe.getIdUtilisateur(), participe.getIdEvenement());
				serveur.envoyer("ok\nover"); //On a pas à renvoyer d'id pour celui ci
				break;
				
			case INCONNU:
				System.err.println("Requete recu non reconnue");
				break;
			default:
				break;
			}
		}		
	}
}
