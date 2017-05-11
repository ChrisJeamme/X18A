package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Depense;

/**
 * Handler SAX de l'objet Depense
 *
 */
public class MySAXHandlerDepense extends DefaultHandler
{
	Depense depense;
	String dernierARemplir;

	/**
	 * Constructeur et initialisation de la depense
	 * @param depense Depense
	 */
	public MySAXHandlerDepense(Depense depense)
	{
		this.depense = depense;
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	public void startDocument()
	{
		System.out.println("Début fichier:\n\n");
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	public void endDocument()
	{
		System.out.println("Fichier terminé");
		System.out.println();
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="depense")
		{
			System.out.println("Nouvelle dépense");

			depense.setIdUtilisateur(Integer.parseInt(attributes.getValue(0)));
			depense.setIdEvenement(Integer.parseInt(attributes.getValue(1)));
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
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void endElement(String uri, String localName, String qName)
	{
		
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
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
