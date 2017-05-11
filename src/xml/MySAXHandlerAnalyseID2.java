package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Handler SAX de l'objet AnalyseID2
 *
 */
public class MySAXHandlerAnalyseID2 extends DefaultHandler
{
	boolean copier1 = false;
	boolean copier2 = false;
	Integer id1;
	Integer id2;
	
	/**
	 * Constructeur qui initialise les deux id
	 * @param aCompleter1 Integer
	 * @param aCompleter2 Integer
	 */
	public MySAXHandlerAnalyseID2(Integer aCompleter1, Integer aCompleter2)
	{
		id1 = aCompleter1;
		id2 = aCompleter2;
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
		if(qName.compareTo("id")==0 && id1 == 0) //Il faut compléter le premier
		{
			copier1 = true;
			
		}
		if(qName.compareTo("id")==0 && id1 !=0)
		{
			copier2 = true;
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
