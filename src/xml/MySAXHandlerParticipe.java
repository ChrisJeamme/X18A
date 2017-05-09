package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.Participe;

public class MySAXHandlerParticipe extends DefaultHandler
{
	Participe participe;
	String dernierARemplir;

	public MySAXHandlerParticipe(Participe participe)
	{
		this.participe = participe;
	}
	
	public void startDocument()
	{
		System.out.println("Début fichier:\n\n");
	}
	
	public void endDocument()
	{
		System.out.println("Fichier terminé");
		System.out.println();
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="participant")
		{
			System.out.println("Nouveau participant");
			participe.setIdUtilisateur(Integer.valueOf(attributes.getValue(0)));
			participe.setIdEvenement(Integer.valueOf(attributes.getValue(1)));
			dernierARemplir = "participant";
		}
		if(qName=="utilisateur")
		{
			System.out.println("Utilisateur");
			dernierARemplir = "utilisateur";
		}
	}
	
	public void endElement(String uri, String localName, String qName)
	{
		
	}
	
	public void characters(char[] ch, int start, int length)
	{
		String contenu = "";
		for(int i=start; i<start+length; i++)
		{
			contenu = contenu.concat(ch[i]+"");
		}
		
		if(dernierARemplir == "utilisateur")
		{
			dernierARemplir = "";
			System.out.println("Remplissage de l'utilisateur: "+contenu);
		}
	}

}
