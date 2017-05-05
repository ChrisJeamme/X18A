package xml;

import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Chat;
import donnees.Message;

public class MySAXHandlerChat extends DefaultHandler
{	
	Chat chat;
	String dernierARemplir;
	
	public MySAXHandlerChat(Chat chat)
	{
		this.chat = chat;
	}
	
	public void startDocument()
	{
		System.out.println("Début fichier:\n\n");
	}
	
	public void endDocument()
	{
		System.out.println("Fichier terminé");
		System.out.println();
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="message")
		{
			System.out.println("Nouveau message");
			chat.ajouterMessage(new Message());
			chat.getDernierMessage().setIdUtilisateur(attributes.getValue(0));
			chat.getDernierMessage().setIdEvenement(attributes.getValue(1));
			dernierARemplir = "message";
		}
		if(qName=="date")
		{
			System.out.println("Date");
			dernierARemplir = "date";
		}
		if(qName=="auteur")
		{
			System.out.println("Auteur");
			dernierARemplir = "auteur";
		}
		if(qName=="texte")
		{
			System.out.println("Texte");
			dernierARemplir = "texte";
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
		
		if(dernierARemplir == "date")
		{
			dernierARemplir = "";
			System.out.println("Remplissage de date: "+contenu);
			Message last = chat.getDernierMessage();
			last.setDate(contenu);
		}
		if(dernierARemplir == "auteur")
		{
			dernierARemplir = "";
			System.out.println("Remplissage de l'auteur: "+contenu);
			Message last = chat.getDernierMessage();
			last.setAuteur(contenu);
		}
		if(dernierARemplir == "texte")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du texte: "+contenu);
			Message last = chat.getDernierMessage();
			last.setTexte(contenu);
		}
	}
}
