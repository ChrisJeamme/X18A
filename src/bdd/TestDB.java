package bdd;

import java.sql.ResultSet;

public class TestDB
{
	public static void main(String args[])
	{
		//Exemple de test:
		//reqLibre SELECT Count(userID) FROM utilisateur;
		
		//Connexion à la BDD
		BDD c = new BDD();
		
		//Analyse des arguments
		if(args.length > 1)
		{
			char type;
			String requete;
			
			System.out.println();
			
			if(args[0].charAt(0)=='m' || args[0].charAt(4)=='M')	//Modification
			{
				type = 'm';
			}
			else	//Interrogation
			{
				type = 's';
			}
			
			requete = "";
			for(int i=1; i<args.length; i++)
			{
				requete += " "+args[i];
			}

			System.out.println("Lancement de la requête: "+requete);
			
			ResultSet r = c.reqSQL(requete,type);
			
			//On affiche le résultat en cas de requête d'intérrogation
			if(type!='m')
				c.afficherRes(r);	
		}
		else
		{
			System.err.println("Erreur: Pas d'argument / Arguments incorrects");
		}
		
		//On se déconnecte de la BDD
		c.disconnect();
	}
	
}
