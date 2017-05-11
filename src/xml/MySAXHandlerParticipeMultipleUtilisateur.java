package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import donnees.ParticipeMultipleUtilisateur;

/**
 * Handler SAX de l'objet ParticipeMultipleUtilisateur
 *
 */
public class MySAXHandlerParticipeMultipleUtilisateur extends DefaultHandler
{	
	ParticipeMultipleUtilisateur participeMultipleUtilisateur;
	String dernierARemplir;
	
	/**
	 * Constructeur et initialisation de participeMultipleUtilisateur
	 * @param participeMultipleUtilisateur ParticipeMultipleUtilisateur
	 */
	public MySAXHandlerParticipeMultipleUtilisateur(ParticipeMultipleUtilisateur participeMultipleUtilisateur)
	{
		this.participeMultipleUtilisateur = participeMultipleUtilisateur;
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	public void startDocument()
	{
		System.out.println("Début fichier:\n\n");
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	public void endDocument()
	{
		System.out.println("Fichier terminé");
		System.out.println();
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName=="nombre")
		{
			System.out.println("Nombre d'evenements");
			dernierARemplir = "nombre";
		}
		if(qName=="participe")
		{
			System.out.println("Nouvel evenement");
			participeMultipleUtilisateur.nouvelEvenement();
			participeMultipleUtilisateur.getDernierElementObj().setId(Integer.parseInt(attributes.getValue(0)));
			dernierARemplir = "participe";
		}
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void endElement(String uri, String localName, String qName)
	{
		
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	public void characters(char[] ch, int start, int length)
	{
		String contenu = "";
		for(int i=start; i<start+length; i++)
		{
			contenu = contenu.concat(ch[i]+"");
		}
		
		if(dernierARemplir == "nombre")
		{
			dernierARemplir = "";
			System.out.println("Enregistrement du nombre d'evenements");
			participeMultipleUtilisateur.setNombreEvenements(Integer.parseInt(contenu));
		}
	}
}
