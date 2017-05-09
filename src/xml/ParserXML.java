package xml;

import donnees.Depense;
import donnees.Evenement;
import donnees.Message;
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
//			System.out.println("Dépense");
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
		// TODO Auto-generated method stub
		return null;
	}

	public static Utilisateur lireUtilisateur(String reception)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public static Evenement lireEvenement(String reception)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *  Va servir à enlever ce qui ne passerait pas au parser XML
	 * @param reception
	 * @return 
	 */
	public static String clean(String reception)
	{
		//On supprime "over" à la fin
		return reception.substring(0, reception.length()-4);
	}
}
