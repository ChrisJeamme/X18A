package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXHandlerRecupPseudo extends DefaultHandler
{
	boolean copier = false;
	String pseudo;
	
	public MySAXHandlerRecupPseudo()
	{
		pseudo = "";
	}
	
	public void startDocument()
	{}
	
	public void endDocument()
	{}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName.compareTo("pseudo") == 0)
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
			System.out.println("Pseudo= "+pseudo);
			pseudo = contenu;
		}
	}
	
	public String getPseudo()
	{
		System.out.println("On a get le pseudo = "+pseudo);
		return new String(pseudo);
	}

}
