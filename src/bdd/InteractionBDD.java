package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

import bdd.BDD.TypesRequete;
import chat.Chat;
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
		//Initialisation de la Liste à remplir
		ArrayList<Utilisateur> listeUsers = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM utilisateurs",TypesRequete.LECTURE);
	
		//Traitement des résultats
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
				
				//System.out.println("Ajout d'un nouvel utilisateur: "+user);
				listeUsers.add(user);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeUsers;
	}
	
	public static Chat recupMessages(BDD bdd)
	{
		//Initialisation de la Liste à remplir
		Chat chat= new Chat();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT poste_message.idUtilisateur,idEvenement,date,message FROM poste_message, utilisateurs WHERE utilisateurs.idUtilisateur=poste_message.idUtilisateur",TypesRequete.LECTURE);
	
		//Traitement des résultats
		ResultSetMetaData meta = null;
		
		try
		{
			meta = (ResultSetMetaData) r.getMetaData();
			
			while(r.next())
			{
				Message message = new Message();
				
				for(int i=1; i<=(meta.getColumnCount()); i++)
				{
					if(meta.getColumnLabel(i).compareTo("idUtilisateur") == 0)
						message.setIdUtilisateur(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("idEvenement") == 0)
						message.setIdEvenement(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("date") == 0)
						message.setDate(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("message") == 0)
						message.setTexte(r.getString(meta.getColumnName(i)));
				}
				
				System.out.println("Ajout d'un nouveeau message: "+message);
				chat.ajouterMessage(message);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return chat;
	}
}
