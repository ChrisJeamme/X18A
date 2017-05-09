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
	{
		System.out.println("D�but fichier:\n\n");
	}
	
	public void endDocument()
	{
		System.out.println("Fichier termin�");
		System.out.println();
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="id")
		{
			System.out.println("Nouvel utilisateur");
		}
		if(qName=="nom")
		{
			System.out.println("Nom");
			dernierARemplir = "nom";
		}
		if(qName=="prenom")
		{
			System.out.println("Prenom");
			dernierARemplir = "prenom";
		}
		if(qName=="email")
		{
			System.out.println("Email");
			dernierARemplir = "email";
		}
		if(qName=="pseudo")
		{
			System.out.println("Pseudo");
			dernierARemplir = "pseudo";
		}
		if(qName=="motDePasse")
		{
			System.out.println("Mot de passe");
			dernierARemplir = "motDePasse";
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
		
		if(dernierARemplir == "id")
		{
			dernierARemplir = "";
			System.out.println("Remplissage de l'id: "+contenu);
			utilisateur.setId(Integer.parseInt(contenu));
		}
		if(dernierARemplir == "nom")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du nom: "+contenu);
			utilisateur.setNom(contenu);
		}
		if(dernierARemplir == "prenom")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du prenom: "+contenu);
			utilisateur.setPrenom(contenu);
		}
		if(dernierARemplir == "email")
		{
			dernierARemplir = "";
			System.out.println("Remplissage de l'email: "+contenu);
			utilisateur.setEmail(contenu);
		}
		if(dernierARemplir == "pseudo")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du pseudo: "+contenu);
			utilisateur.setPseudo(contenu);
		}
		if(dernierARemplir == "motDePasse")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du mot de passe: "+contenu);
			utilisateur.setMotDePasse(contenu);
		}
	}
}
