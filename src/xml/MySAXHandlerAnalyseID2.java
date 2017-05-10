package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXHandlerAnalyseID2 extends DefaultHandler
{
	boolean copier1 = false;
	boolean copier2 = false;
	Integer id1;
	Integer id2;
	
	public MySAXHandlerAnalyseID2(Integer aCompleter1, Integer aCompleter2)
	{
		id1 = aCompleter1;
		id2 = aCompleter2;
 	}
	
	public void startDocument()
	{}
	
	public void endDocument()
	{}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName.compareTo("id")==0 && id1 == 0) //Il faut compléter le premier
		{
			copier1 = true;
			
		}
		if(qName.compareTo("id")==0 && id1 !=0)
		{
			copier2 = true;
		}
	}
	
	public void endElement(String uri, String localName, String qName)
	{}
	
	public void characters(char[] ch, int start, int length)
	{
		if(copier1)
		{
			String contenu = "";
			
			for(int i=start; i<start+length; i++)
			{
				contenu = contenu.concat(ch[i]+"");
			}
			
			id1 = Integer.parseInt(contenu);
		}
		
		if(copier2)
		{
			String contenu = "";
			
			for(int i=start; i<start+length; i++)
			{
				contenu = contenu.concat(ch[i]+"");
			}
			
			id2 = Integer.parseInt(contenu);
		}
	}

}
