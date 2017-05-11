package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Handler SAX de l'objet RecuptPseudo
 *
 */
public class MySAXHandlerRecupPseudo extends DefaultHandler
{
	boolean copier = false;
	String pseudo;
	
	/**
	 * Constructeur et initialisation de pseudo
	 */
	public MySAXHandlerRecupPseudo()
	{
		pseudo = "";
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
		if(qName.compareTo("pseudo") == 0)
		{
			copier = true;
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
		if(copier)
		{
			copier = false;
			
			String contenu = "";
			
			for(int i=start; i<start+length; i++)
			{
				contenu = contenu.concat(ch[i]+"");
			}
			pseudo = contenu;
		}
	}
	
	public String getPseudo()
	{
		return new String(pseudo);
	}

}
