package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Depense;

public class MySAXHandlerAnalyseID1 extends DefaultHandler
{
	boolean copier = false;
	Integer id;
	
	public MySAXHandlerAnalyseID1(Integer aCompleter)
	{
		id = aCompleter;
	}
	
	public void startDocument()
	{}
	
	public void endDocument()
	{}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="id")
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
			
			id = Integer.parseInt(contenu);
		}
	}

}
