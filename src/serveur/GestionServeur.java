package serveur;

import bdd.BDD;

public class GestionServeur
{
	Serveur serveur;
	BDD bdd;
	
	public GestionServeur()
	{
		bdd = new BDD();
		
		serveur = new Serveur(18458);
		serveur.initialiser();
		String reception = serveur.attente();
		System.out.println(reception);
		
		//InteractionBDD.
				
	}
}
