package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXHandlerExemple extends DefaultHandler
{
	private int nombreElements;
	private int nombreAttributs;
	private int nombreCaracteres;
	
	public MySAXHandlerExemple()
	{
		nombreElements=0;
		nombreAttributs=0;
		nombreCaracteres=0;
	}
	
	public void startDocument()
	{
		System.out.println("Début fichier:\n\n");
	}
	
	public void endDocument()
	{
		System.out.println("Fichier terminé\n\tElements: "+nombreElements+"\n\tAttributs: "+nombreAttributs+"\n\tCaractères: "+nombreCaracteres);
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		nombreElements++;
		
		if(attributes.getLength()>0)
		{
			System.out.print("<"+qName);
			for(int i=0; i<attributes.getLength(); i++)
			{
				nombreAttributs++;
				
				System.out.print(" "+attributes.getQName(i)+"="+attributes.getValue(i));
			}
			System.out.println(">");
		}
		else
		{
			System.out.println("<"+qName+">");
		}
	}
	
	public void endElement(String uri, String localName, String qName)
	{
		System.out.println("</"+qName+">");
//		System.out.println("endElement:\n\turi="+uri+/*" localName="+localName+*/" qName="+qName);
	}
	
	public void characters(char[] ch, int start, int length)
	{
		System.out.print("\t");
		for(int i=start; i<start+length; i++)
		{
			nombreCaracteres++;
			
			System.out.print(ch[i]);
		}
		System.out.println("");
	}
}
