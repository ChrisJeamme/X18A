package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Depense;

public class MySAXHandlerDepense extends DefaultHandler
{
	Depense depense;
	String dernierARemplir;

	public MySAXHandlerDepense(Depense depense)
	{
		this.depense = depense;
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
		if(qName=="depense")
		{
			System.out.println("Nouvelle dépense");
			depense.setIdUtilisateur(Integer.valueOf(attributes.getValue(0)));
			depense.setIdEvenement(Integer.valueOf(attributes.getValue(1)));
			dernierARemplir = "depense";
		}
		if(qName=="date")
		{
			System.out.println("Date");
			dernierARemplir = "date";
		}
		if(qName=="montant")
		{
			System.out.println("Montant");
			dernierARemplir = "montant";
		}
		if(qName=="description")
		{
			System.out.println("Description");
			dernierARemplir = "description";
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
			depense.setDate(contenu);
		}
		if(dernierARemplir == "montant")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du montant: "+contenu);
			depense.setMontant(Integer.valueOf(contenu));
		}
		if(dernierARemplir == "description")
		{
			dernierARemplir = "";
			System.out.println("Remplissage de la description: "+contenu);
			depense.setDescription(contenu);
		}
	}

}
