package xml;

import donnees.Depense;
import donnees.Evenement;
import donnees.Message;
import donnees.Participe;
import donnees.Utilisateur;

/**
 * Gestion du parserXML
 *
 */
public class ParserXML
{
	/**
	 * Renvoie le type de requete du XML
	 * @param reception String
	 * @return TypeRequete : Le type de la requête
	 */
	public static TypeRequete analyserType(String reception)
	{
		if(reception.contains("<!DOCTYPE demande SYSTEM"))
		{
			if(reception.contains("evenement") || reception.contains("évenement") || reception.contains("événement"))
			{
				return TypeRequete.DEMANDE_EVENEMENT;
			}
			if(reception.contains("chat"))
			{
				return TypeRequete.DEMANDE_CHAT;
			}
			if(reception.contains("depense") || reception.contains("dépense"))
			{
				return TypeRequete.DEMANDE_DEPENSE;
			}
			if(reception.contains("utilisateur"))
			{
				return TypeRequete.DEMANDE_UTILISATEUR;
			}
			if(reception.contains("participeUtilisateur"))
			{
				return TypeRequete.DEMANDE_PARTICIPEUTILISATEUR;
			}
		}
		if(reception.contains("<!DOCTYPE connexion SYSTEM"))
		{
//			System.out.println("Evenement");
			return TypeRequete.CONNEXION;
		}
		if(reception.contains("<!DOCTYPE evenement SYSTEM"))
		{
//			System.out.println("Evenement");
			return TypeRequete.ENVOI_EVENEMENT;
		}
		if(reception.contains("<!DOCTYPE utilisateur SYSTEM"))
		{
//			System.out.println("Utilisateur");
			return TypeRequete.ENVOI_UTILISATEUR;
		}
		if(reception.contains("<!DOCTYPE depense SYSTEM"))
		{
//			System.out.println("Dï¿½pense");
			return TypeRequete.ENVOI_DEPENSE;
		}
		if(reception.contains("<!DOCTYPE message SYSTEM"))
		{
//			System.out.println("Chat");
			return TypeRequete.ENVOI_MESSAGE;
		}
		if(reception.contains("<!DOCTYPE participe SYSTEM"))
		{
//			System.out.println("Participe");
			return TypeRequete.ENVOI_PARTICIPE;
		}
		
		
		return TypeRequete.INCONNU;
	}

	/**
	 * Lit l'objet du XML et le renvoiee
	 * @param reception String
	 * @return Depense : L'objet Depense décrit par le XML
	 */
	public static Depense lireDepense(String reception)
	{
		//Ne marche pas mais donne la gueule du truc
		Depense depense = new Depense();
		ParserSAX p = new ParserSAX();
		MySAXHandlerDepense handler = new MySAXHandlerDepense(depense);
		p.monParsing(handler, reception);
		return depense;
	}

	/**
	 * Lit l'objet du XML et le renvoie
	 * @param reception String
	 * @return Message : L'objet Message décrit par le XML
	 */
	public static Message lireMessage(String reception)
	{
		Message message = new Message();
		ParserSAX p = new ParserSAX();
		MySAXHandlerMessage handler = new MySAXHandlerMessage(message);
		p.monParsing(handler, reception);
		return message;
	}

	/**
	 * Lit l'objet du XML et le renvoie
	 * @param reception String
	 * @return Utilisateur : L'objet Utilisateur décrit par le XML
	 */
	public static Utilisateur lireUtilisateur(String reception)
	{
		Utilisateur utilisateur = new Utilisateur();
		ParserSAX p = new ParserSAX();
		MySAXHandlerUtilisateur handler = new MySAXHandlerUtilisateur(utilisateur);
		p.monParsing(handler, reception);
		return utilisateur;
	}

	/**
	 * Lit l'objet du XML et le renvoie
	 * @param reception String
	 * @return Evenement : L'objet Evenement décrit par le XML
	 */
	public static Evenement lireEvenement(String reception)
	{
		Evenement evenement = new Evenement();
		ParserSAX p = new ParserSAX();
		MySAXHandlerEvenement handler = new MySAXHandlerEvenement(evenement);
		p.monParsing(handler, reception);
		return evenement;
	}
	
	/**
	 * Lit l'objet du XML et le renvoie
	 * @param reception String
	 * @return Participe : L'objet Participe décrit par le XML
	 */
	public static Participe lireParticipe(String reception)
	{
		Participe participe = new Participe();
		ParserSAX p = new ParserSAX();
		MySAXHandlerParticipe handler = new MySAXHandlerParticipe(participe);
		p.monParsing(handler, reception);
		return participe;
	}

	/**
	 * Va servir à enlever ce qui ne passerait pas au parser XML
	 * @param reception String
	 * @return String : Le message nettoyé
	 */
	public static String clean(String reception)
	{
		//On supprime "over" à la fin
		return reception.substring(0, reception.length()-4);
	}

	/**
	 * On veut récupérer l'id demandé dans un XML de demande
	 * @param reception String
	 * @return int : L'id demandé
	 */
	public static int analyserDemande1Id(String reception)
	{
		Integer id = new Integer(0);
		ParserSAX p = new ParserSAX();
		MySAXHandlerAnalyseID1 handler = new MySAXHandlerAnalyseID1(id);
		p.monParsing(handler, reception);
		return id;
	}

	/**
	 * On veut récupérer les 2 id de l'objet demandé d'un XML de demande
	 * @param reception String
	 * @return int[] : Un tableau contenant les deux id demandées
	 */
	public static int[] analyserDemande2Id(String reception)
	{
		Integer id1 = new Integer(0);
		Integer id2 = new Integer(0);
		ParserSAX p = new ParserSAX();
		MySAXHandlerAnalyseID2 handler = new MySAXHandlerAnalyseID2(id1,id2);
		p.monParsing(handler, reception);
		int id[] = {-1,-1};
		id[0] = id1;
		id[1] = id2;
		return id;
	}

	/**
	 * On veut récupérer la date d'un objet (car clé primaire) depuis le XML
	 * @param reception String
	 * @return String : La date demandée
	 */
	public static String analyserDemandeDate(String reception)
	{
		String date = "";
		ParserSAX p = new ParserSAX();
		MySAXHandlerAnalyseDate handler = new MySAXHandlerAnalyseDate(date);
		p.monParsing(handler, reception);
		return date;
	}

	/**
	 * On veut récupérer le pseudo d'un utilisateur depuis le XML
	 * @param reception String
	 * @return String : Le pseudo demandé
	 */
	public static String analyserConnexionPseudo(String reception)
	{
		ParserSAX p = new ParserSAX();
		MySAXHandlerRecupPseudo handler = new MySAXHandlerRecupPseudo();
		p.monParsing(handler, reception);
		return handler.getPseudo();
	}

	/**
	 * On veut récupérer le mot de passe d'un utilisateur depuis le XML
	 * @param reception String
	 * @return String : Le mot de passe demandé
	 */
	public static String analyserConnexionMdp(String reception)
	{
		ParserSAX p = new ParserSAX();
		MySAXHandlerRecupMdp handler = new MySAXHandlerRecupMdp();
		p.monParsing(handler, reception);
		return handler.getPass();
	}
}
