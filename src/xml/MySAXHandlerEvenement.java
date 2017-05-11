package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Evenement;

public class MySAXHandlerEvenement extends DefaultHandler
{
	Evenement evenement;
	String dernierARemplir;

	public MySAXHandlerEvenement(Evenement evenement)
	{
		this.evenement = evenement;
	}
	
	public void startDocument()
	{}
	
	public void endDocument()
	{}
	
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
	
	public void endElement(String uri, String localName, String qName)
	{}
	
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
