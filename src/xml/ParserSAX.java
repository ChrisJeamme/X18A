package xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserSAX
{
	public ParserSAX()
	{

	}
	
	public void monParsing(DefaultHandler handler, String xml)
	{
		SAXParserFactory factory= SAXParserFactory.newInstance();
		factory.setValidating(true);
		SAXParser parser;
		
		try
		{
			parser = factory.newSAXParser();
			parser.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))), handler);
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

	public void monParsing(MySAXHandlerDepense handler, String reception)
	{
		// TODO Auto-generated method stub
		
	}	
	
}
