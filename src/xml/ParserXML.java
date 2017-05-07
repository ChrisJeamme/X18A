package xml;

public class ParserXML
{
	public static TypeRequete analyserType(String reception)
	{
		//Il faudra peut-être ajouter un tag avant la requete qu'on lira ici
		return TypeRequete.INCONNU;
	}

	public static void analyserEnvoi(String reception)
	{
		// Ici il faudrait analyse le type d'objet dans lequel on va recevoir (Evenement,Depense, etc.)
		// On devrait utiliser des trucs de généricité?
	}

	public static void analyserDemande(String reception)
	{
		// Pareil qu'au dessus?
	}
}
