package serveur;

public class GestionServeur
{
	Serveur serveur;
	
	public GestionServeur()
	{
		serveur = new Serveur(18458);
		serveur.initialiser();
		String reception = serveur.attente();
		System.out.println(reception);
	}
}
