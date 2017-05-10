package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXHandlerRecupMdp extends DefaultHandler
{
	boolean copier = false;
	String mdp;
	
	public MySAXHandlerRecupMdp(String aCompleter)
	{
		mdp = aCompleter;
	}
	
	public void startDocument()
	{}
	
	public void endDocument()
	{}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="pass")
		{
			copier = true;
		}
	}
	
	public void endElement(String uri, String localName, String qName)
	{}
	
	public void characters(char[] ch, int start, int length)
	{
		if(copier)
		{
			String contenu = "";
			
			for(int i=start; i<start+length; i++)
			{
				contenu = contenu.concat(ch[i]+"");
			}
			
			mdp = contenu;
		}
	}

}
