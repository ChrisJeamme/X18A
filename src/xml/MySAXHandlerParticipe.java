package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Participe;

/**
 * Handler SAX de l'objet Participe
 *
 */
public class MySAXHandlerParticipe extends DefaultHandler
{
	Participe participe;
	String dernierARemplir;

	/**
	 * Constructeur et initialisation de participe
	 * @param participe Participe
	 */
	public MySAXHandlerParticipe(Participe participe)
	{
		this.participe = participe;
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
		participe.setIdUtilisateur(Integer.parseInt(attributes.getValue("idUtilisateur")));
		participe.setIdEvenement(Integer.parseInt(attributes.getValue("idEvenement")));
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
	{}

}
