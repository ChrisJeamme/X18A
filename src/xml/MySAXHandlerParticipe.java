package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Participe;

public class MySAXHandlerParticipe extends DefaultHandler
{
	Participe participe;
	String dernierARemplir;

	public MySAXHandlerParticipe(Participe participe)
	{
		this.participe = participe;
	}
	
	public void startDocument()
	{}
	
	public void endDocument()
	{}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		participe.setIdUtilisateur(Integer.parseInt(attributes.getValue("idUtilisateur")));
		participe.setIdEvenement(Integer.parseInt(attributes.getValue("idEvenement")));
	}
	
	public void endElement(String uri, String localName, String qName)
	{}
	
	public void characters(char[] ch, int start, int length)
	{}

}
