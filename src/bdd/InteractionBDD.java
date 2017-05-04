package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

import bdd.BDD.TypesRequete;
import chat.Message;
import donnees.Depense;
import donnees.Evenement;
import donnees.Utilisateur;

public class InteractionBDD
{
	public static Depense recupDepenses(BDD bdd)
	{
		return null;
		
	}
	
	public static Evenement recupEvenements(BDD bdd)
	{
		return null;
	}
	
	public static ArrayList<Utilisateur> recupUtilisateurs(BDD bdd)
	{
		//Initialisation de la Liste � remplir
		ArrayList<Utilisateur> listeUsers = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM utilisateurs",TypesRequete.LECTURE);
	
		//Traitement des r�sultats
		ResultSetMetaData meta = null;
		
		try
		{
			meta = (ResultSetMetaData) r.getMetaData();
			
			while(r.next())
			{
				Utilisateur user = new Utilisateur();
				
				for(int i=1; i<=(meta.getColumnCount()); i++)
				{
					if(meta.getColumnLabel(i).compareTo("idUtilisateur") == 0)
						user.setId(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("nom") == 0)
						user.setNom(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("prenom") == 0)
						user.setPrenom(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("email") == 0)
						user.setEmail(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("pseudo") == 0)
						user.setPseudo(r.getString(meta.getColumnName(i)));
				}
				
				System.out.println("Ajout d'un nouvel utilisateur: "+user);
				listeUsers.add(user);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Probl�me SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeUsers;
	}
	
	public static Message recupMessages(BDD bdd)
	{
		return null;
		
	}
}
