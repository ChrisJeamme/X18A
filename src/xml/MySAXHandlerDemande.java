package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Chat;
import donnees.Message;

public class MySAXHandlerDemande extends DefaultHandler
{	
	String dernierARemplir;
	String type;
	Demande demande;
	
	public MySAXHandlerDemande()
	{}
	
	public void startDocument()
	{
		demande = new Demande();
	}
	
	public void endDocument()
	{}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="type")
		{
			System.out.println("Type");
			dernierARemplir = "type";
		}
		if(qName=="couple_id")
		{
			System.out.println("Couple ID");
			dernierARemplir = "couple_id";
		}
		if(qName=="id_couple")
		{
			System.out.println("id");
			dernierARemplir = "id_couple";
		}
		if(qName=="id")
		{
			System.out.println("id");
			dernierARemplir = "id";
		}
	}

	public void endElement(String uri, String localName, String qName)
	{
		
	}
	
	public void characters(char[] ch, int start, int length)
	{
		String contenu = "";
		for(int i=start; i<start+length; i++)
		{
			contenu = contenu.concat(ch[i]+"");
		}
		
		if(dernierARemplir == "type")
		{
			dernierARemplir = "";
			System.out.println("Remplissage de type: "+contenu);
			switch(contenu)
			{
			case "evenement":
				System.out.println("Demande d'évenement");
				demande.setType(ObjetDemande.EVENEMENT);
				break;
			case "utilisateur":
				System.out.println("Demande d'utilisateur");
				demande.setType(ObjetDemande.UTILISATEUR);
				break;
			case "depense":
				System.out.println("Demande de dépense");
				demande.setType(ObjetDemande.DEPENSE);
				break;
			case "chat":
				System.out.println("Demande de chat");
				demande.setType(ObjetDemande.CHAT);
				break;
			default:
				System.out.println("Impossible de déterminer le type de demande");
				demande.setType(ObjetDemande.INCONNU);
				break;
			}
		}
		if(dernierARemplir == "id_couple")
		{
			dernierARemplir = "";
			System.out.println("Remplissage de l'auteur: "+contenu);
			Message last = chat.getDernierMessage();
			last.setIdUtilisateur(contenu);
		}
		if(dernierARemplir == "id")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du texte: "+contenu);
			Message last = chat.getDernierMessage();
			last.setTexte(contenu);
		}
	}
}
