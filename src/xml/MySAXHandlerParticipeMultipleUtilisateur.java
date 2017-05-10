package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.ParticipeMultipleUtilisateur;

public class MySAXHandlerParticipeMultipleUtilisateur extends DefaultHandler
{	
	ParticipeMultipleUtilisateur participeMultipleUtilisateur;
	String dernierARemplir;
	
	public MySAXHandlerParticipeMultipleUtilisateur(ParticipeMultipleUtilisateur participeMultipleUtilisateur)
	{
		this.participeMultipleUtilisateur = participeMultipleUtilisateur;
	}
	
	public void startDocument()
	{
		System.out.println("D�but fichier:\n\n");
	}
	
	public void endDocument()
	{
		System.out.println("Fichier termin�");
		System.out.println();
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="participe")
		{
			System.out.println("Nouvel evenement");
			participeMultipleUtilisateur.nouvelEvenement();
			participeMultipleUtilisateur.getDernierElementObj().setId(Integer.parseInt(attributes.getValue(0)));
			dernierARemplir = "participe";
		}
		if(qName=="end")
		{
			System.out.println("Fin des evenements");
			dernierARemplir = "end";
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
		
		if(dernierARemplir == "end")
		{
			dernierARemplir = "";
			System.out.println("Fin de la lecture");
		}
	}
}
