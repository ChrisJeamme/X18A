package xml;

import java.io.IOException;
import java.util.logging.Handler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserSAX
{
	public ParserSAX()
	{

	}
	
	public void monParsing(DefaultHandler handler, String XMLDoc)
	{
		SAXParserFactory factory= SAXParserFactory.newInstance();
		factory.setValidating(true);
		SAXParser parser;
		
		try
		{
			parser = factory.newSAXParser();
			parser.parse(XMLDoc, handler);
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
