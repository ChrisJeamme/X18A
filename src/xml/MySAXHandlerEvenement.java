package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Evenement;

/**
 * Handler SAX de l'objet Evenement
 *
 */
public class MySAXHandlerEvenement extends DefaultHandler
{
	Evenement evenement;
	String dernierARemplir;

	/**
	 * Constructeur et initialisation de l'evenement
	 * @param evenement Evenement
	 */
	public MySAXHandlerEvenement(Evenement evenement)
	{
		this.evenement = evenement;
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	public void startDocument()
	{}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	public void endDocument()
	{}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="id")
		{
			dernierARemplir = "id";
		}
		if(qName=="nom")
		{
			dernierARemplir = "nom";
		}
		if(qName=="budget")
		{
			dernierARemplir = "budget";
		}
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void endElement(String uri, String localName, String qName)
	{}
	
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
		
		if(dernierARemplir == "id")
		{
			dernierARemplir = "";
			if(contenu.compareTo("-1")!=0)
				evenement.setId(Integer.valueOf(contenu));
		}
		if(dernierARemplir == "nom")
		{
			dernierARemplir = "";
			evenement.setNomEvenement(contenu);
		}
		if(dernierARemplir == "budget")
		{
			dernierARemplir = "";
			evenement.setBudget(Integer.valueOf(contenu));
		}
	}

}
