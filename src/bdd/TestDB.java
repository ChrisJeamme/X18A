package bdd;

import java.sql.ResultSet;

public class TestDB
{
	public static void main(String args[])
	{
		//Exemple de test:
		//reqLibre SELECT Count(userID) FROM utilisateur;
		
		//Connexion � la BDD
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

			System.out.println("Lancement de la requ�te: "+requete);
			
			ResultSet r = c.reqSQL(requete,type);
			
			//On affiche le r�sultat en cas de requ�te d'int�rrogation
			if(type!='m')
				c.afficherRes(r);	
		}
		else
		{
			System.err.println("Erreur: Pas d'argument / Arguments incorrects");
		}
		
		//On se d�connecte de la BDD
		c.disconnect();
	}
	
}
