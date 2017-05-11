package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXHandlerRecupMdp extends DefaultHandler
{
	boolean copier = false;
	String mdp;
	
	public MySAXHandlerRecupMdp()
	{
		mdp = "";
	}
	
	public void startDocument()
	{}
	
	public void endDocument()
	{}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName.compareTo("pass") == 0)
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
			copier = false;
			
			String contenu = "";
			
			for(int i=start; i<start+length; i++)
			{
				contenu = contenu.concat(ch[i]+"");
			}
			
			mdp = contenu;
		}
	}

	public String getPass()
	{
		return new String(mdp);
	}

}
