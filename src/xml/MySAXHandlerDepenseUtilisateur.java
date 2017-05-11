package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.DepenseUtilisateur;

public class MySAXHandlerDepenseUtilisateur extends DefaultHandler
{
	DepenseUtilisateur depenseUtilisateur;
	String dernierARemplir;

	public MySAXHandlerDepenseUtilisateur(DepenseUtilisateur depenseUtilisateur)
	{
		this.depenseUtilisateur = depenseUtilisateur;
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
		if(qName=="nombre")
		{
			System.out.println("Nombre de depenses");
			dernierARemplir = "nombre";
		}
		if(qName=="depense")
		{
			System.out.println("Nouvelle dépense");

			depenseUtilisateur.setIdUtilisateur(Integer.parseInt(attributes.getValue(0)));
			depenseUtilisateur.getDernierElementObj().setIdEvenement(Integer.parseInt(attributes.getValue(1)));
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
		
		if(dernierARemplir == "nombre")
		{
			dernierARemplir = "";
			System.out.println("Enregistrement du nombre d'evenements");
			depenseUtilisateur.setNombreDepense(Integer.parseInt(contenu));
		}		
		if(dernierARemplir == "date")
		{
			dernierARemplir = "";
			System.out.println("Remplissage de date: "+contenu);
			depenseUtilisateur.setDate(depenseUtilisateur.getDernierElementNum(), contenu);
		}
		if(dernierARemplir == "montant")
		{
			dernierARemplir = "";
			System.out.println("Remplissage du montant: "+contenu);
			depenseUtilisateur.setMontant(depenseUtilisateur.getDernierElementNum(), Integer.valueOf(contenu));
		}
		if(dernierARemplir == "description")
		{
			dernierARemplir = "";
			System.out.println("Remplissage de la description: "+contenu);
			depenseUtilisateur.setDescription(depenseUtilisateur.getDernierElementNum(), contenu);
		}
	}

}
