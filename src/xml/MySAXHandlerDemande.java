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
			dernierARemplir = "id1";
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
		if(dernierARemplir == "id1")
		{
			dernierARemplir = "id2";
			System.out.println("Remplissage du 1er id du couple "+contenu);
			demande.setId(Integer.valueOf(contenu));
		}
		if(dernierARemplir == "id2")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du 2eme id du couple "+contenu);
			demande.setId2(Integer.valueOf(contenu));
		}
	}
}
