package bdd;

import java.sql.ResultSet;

public class Test
{
	private static String[] requetesInterrogation = new String[7];
	private static String[] requetesModification = new String[4];
	

	public static void remplirRequetes()
	{
		int idDonne = 1;
		
		requetesInterrogation[0] = "SELECT * FROM utilisateur;";
		requetesInterrogation[1] = "SELECT* FROM utilisateur,amis WHERE utilisateur.userID=amis.userID AND userID = "+idDonne; //
//		requetesInterrogation[2] = "SELECT email FROM utilisateur WHERE userID IN (SELECT userID FROM amis WHERE userID IN (SELECT amisID FROM amis WHERE amisID IN (SELECT amisID FROM amis WHERE userID='"+idDonne+"'));";
//		requetesInterrogation[3] = "";
//		requetesInterrogation[4] = "";
//		requetesInterrogation[5] = "";
//		requetesInterrogation[6] = "";
		
		requetesModification[0] = "INSERT INTO utilisateur VALUES(21,'Jean-Jacques','LaRoche','jean@jacques.fr','mdp');";
		requetesModification[1] = "INSERT INTO amis VALUES(1,3,2017);";
//		requetesModification[2] = "";
//		requetesModification[3] = "";
	}
	
	public static void main(String args[])
	{
		//On remplit la liste des requêtes du TD (non terminé)
		remplirRequetes();
		
		//Connexion à la BDD
		BDD c = new BDD();
		
		//Analyse des arguments

		char type=' ';
		String requete="";
		if(args.length > 1)
		{
			int numero = Integer.valueOf(args[1]);
			
			if(args[0].charAt(0)=='m')	//Requete TD Modification
			{
				if(numero >=0 && numero <= 1)
				{
					type = 'm';
					requete = requetesModification[numero];
				}
				else
				{
					System.out.println("Erreur, il n'y a que 2 requête de modification (0 et 1)");
					c.disconnect();
					System.exit(-1);
				}
			}
			else	//Requete TD Interrogation
			{
				if(numero >=0 && numero <= 1)
				{
					type = 's';
					requete = requetesInterrogation[numero];
				}
				else
				{
					System.out.println("Erreur, il n'y a que 2 requête d'interrogation (0 et 1)");
					c.disconnect();
					System.exit(-1);
				}
			}

			System.out.println("Lancement de la requête: "+requete);
			
			ResultSet r = c.reqSQL(requete,type);
			if(type!='m')
				c.afficherRes(r);	
			
			System.out.println("OK");
		}
		else
		{
			System.err.println("Erreur: Pas d'argument / Arguments incorrects");
		}
		
		//Exemple de requeête d'interrogation

		//c.reqSQL("ALTER TABLE ", 'm');	//A tester
		//c.afficherRes(r);
		
		//On se déconnecte de la BDD
		c.disconnect();
	}
	
}
