package xml;

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
}
