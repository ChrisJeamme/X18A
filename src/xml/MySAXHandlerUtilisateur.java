package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Utilisateur;

public class MySAXHandlerUtilisateur extends DefaultHandler {
	Utilisateur utilisateur;
	String dernierARemplir;
	
	public MySAXHandlerUtilisateur(Utilisateur utilisateur)
	{
		this.utilisateur = utilisateur;
	}
	
	public void startDocument()
	{}
	
	public void endDocument()
	{}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="id")
		{}
		if(qName=="nom")
		{
			dernierARemplir = "nom";
		}
		if(qName=="prenom")
		{
			dernierARemplir = "prenom";
		}
		if(qName=="email")
		{
			dernierARemplir = "email";
		}
		if(qName=="pseudo")
		{
			dernierARemplir = "pseudo";
		}
		if(qName=="motDePasse")
		{
			dernierARemplir = "motDePasse";
		}
	}

	public void endElement(String uri, String localName, String qName)
	{}
	
	public void characters(char[] ch, int start, int length)
	{
		String contenu = "";
		for(int i=start; i<start+length; i++)
		{
			contenu = contenu.concat(ch[i]+"");
		}
		
		if(dernierARemplir == "id")
		{
			dernierARemplir = "";
			utilisateur.setId(Integer.parseInt(contenu));
		}
		if(dernierARemplir == "nom")
		{
			dernierARemplir = "";
			utilisateur.setNom(contenu);
		}
		if(dernierARemplir == "prenom")
		{
			dernierARemplir = "";
			utilisateur.setPrenom(contenu);
		}
		if(dernierARemplir == "email")
		{
			dernierARemplir = "";
			utilisateur.setEmail(contenu);
		}
		if(dernierARemplir == "pseudo")
		{
			dernierARemplir = "";
			utilisateur.setPseudo(contenu);
		}
		if(dernierARemplir == "motDePasse")
		{
			dernierARemplir = "";
			utilisateur.setMotDePasse(contenu);
		}
	}
}
