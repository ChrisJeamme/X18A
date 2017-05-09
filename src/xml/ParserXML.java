package xml;

import donnees.Depense;
import donnees.Evenement;
import donnees.Message;
import donnees.Participe;
import donnees.Utilisateur;

public class ParserXML
{
	public static TypeRequete analyserType(String reception)
	{
		if(reception.contains("<!DOCTYPE demande SYSTEM"))
		{
//			System.out.println("Demande");
			return TypeRequete.DEMANDE_OBJET;
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
//			System.out.println("D�pense");
			return TypeRequete.ENVOI_DEPENSE;
		}
		if(reception.contains("<!DOCTYPE chat SYSTEM"))
		{
//			System.out.println("Chat");
			return TypeRequete.ENVOI_CHAT;
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

	public static Depense lireDepense(String reception)
	{
		//Ne marche pas mais donne la gueule du truc
		Depense depense = new Depense();
		ParserSAX p = new ParserSAX();
		MySAXHandlerDepense handler = new MySAXHandlerDepense(depense);
		p.monParsing(handler, reception);
		return depense;
	}

	public static Message lireMessage(String reception)
	{
		Message message = new Message();
		ParserSAX p = new ParserSAX();
		MySAXHandlerMessage handler = new MySAXHandlerMessage(message);
		p.monParsing(handler, reception);
		return message;
	}

	public static Utilisateur lireUtilisateur(String reception)
	{
		Utilisateur utilisateur = new Utilisateur();
		ParserSAX p = new ParserSAX();
		MySAXHandlerUtilisateur handler = new MySAXHandlerUtilisateur(utilisateur);
		p.monParsing(handler, reception);
		return utilisateur;
	}

	public static Evenement lireEvenement(String reception)
	{
		Evenement evenement = new Evenement();
		ParserSAX p = new ParserSAX();
		MySAXHandlerEvenement handler = new MySAXHandlerEvenement(evenement);
		p.monParsing(handler, reception);
		return evenement;
	}
	
	public static Participe lireParticipe(String reception)
	{
		Participe participe = new Participe();
		ParserSAX p = new ParserSAX();
		MySAXHandlerParticipe handler = new MySAXHandlerParticipe(participe);
		p.monParsing(handler, reception);
		return participe;
	}

	/**
	 *  Va servir � enlever ce qui ne passerait pas au parser XML
	 * @param reception
	 * @return 
	 */
	public static String clean(String reception)
	{
		//On supprime "over" � la fin
		return reception.substring(0, reception.length()-4);
	}
}
