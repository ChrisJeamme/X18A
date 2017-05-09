package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Evenement;

public class MySAXHandlerEvenement extends DefaultHandler
{
	Evenement evenement;
	String dernierARemplir;

	public MySAXHandlerEvenement(Evenement evenement)
	{
		this.evenement = evenement;
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
		if(qName=="evenement")
		{
			System.out.println("Nouveau evenement");
			dernierARemplir = "evenement";
		}
		if(qName=="id")
		{
			System.out.println("ID");
			dernierARemplir = "id";
		}
		if(qName=="nom")
		{
			System.out.println("Nom");
			dernierARemplir = "nom";
		}
		if(qName=="budget")
		{
			System.out.println("Budget");
			dernierARemplir = "budget";
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
			System.out.println("Remplissage de l'ID: "+contenu);
			evenement.setId(Integer.valueOf(contenu));
		}
		if(dernierARemplir == "nom")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du nom: "+contenu);
			evenement.setNomEvenement(contenu);
		}
		if(dernierARemplir == "budget")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du budget: "+contenu);
			evenement.setBudget(Integer.valueOf(contenu));
		}
	}

}
