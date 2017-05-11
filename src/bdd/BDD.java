package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import donnees.Utilisateur;

/**
 * Gère la connexion à la base de données
 *
 */
public class BDD
{
	/**
	 * Liste des interactions possible avec la base de données
	 *
	 */
	public enum TypesRequete
	{
		MODIFICATION, LECTURE, RETOURID
	}
	
	Connection c;
	Statement st;
	
	/**
	 * Constructeur et connexion à la base de données
	 */
	public BDD()
	{
		String serveur = "127.0.0.1";
		String identifiant = "chris";
		String mdp = "jKFe5FA4ef6";
		String url = "jdbc:mysql://"+serveur/*+":"+port*/+"/dealwithit";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			try
			{
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				c = DriverManager.getConnection(url, identifiant, mdp);
				System.out.println("Connexion chargé");
				st = c.createStatement();
			}
			catch (SQLException e)
			{
				System.out.println("Erreur de connexion ...");
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Déconnexion de la base de données
	 */
	public void disconnect()
	{
		try
		{
			c.close();
			st.close();
		}
		catch (SQLException e)
		{
			System.err.println("Impossible de fermer la connexion");
			e.printStackTrace();
		}
		System.out.println("Connexion fermé");
	}
	
	/**
	 * Affiche le résultat de la requête à la base de données
	 * @param r ResultSet
	 */
	public void afficherRes(ResultSet r)
	{
		int i;
		ResultSetMetaData meta = null;
		
		try
		{
			meta = (ResultSetMetaData) r.getMetaData();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
			disconnect();
			System.exit(-1);
		}
		
		try
		{
			System.out.println("Résultat de la rêquete:");
			while(r.next())
			{
				i=1;
				try
				{
					System.out.println("===================");
					while(i <= (meta.getColumnCount()))
					{
						System.out.println(meta.getColumnLabel(i)+": "+r.getString(meta.getColumnName(i)));
						i++;
					}
				}
				catch (SQLException e)
				{
					System.out.println("Problème accès i="+i);
					e.printStackTrace();
					disconnect();
					System.exit(-1);
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			disconnect();
			System.exit(-1);
		}
	}
	
	/**
	 * Effectue une mise à jour dans la base de données
	 * @param query String
	 * @return int : L'id du résultat
	 */
	public int reqSQLid(String query)
	{
		try
		{
			st.executeUpdate (query, Statement.RETURN_GENERATED_KEYS);          
	        ResultSet ids = st.getGeneratedKeys();
	        ids.next();
			return ids.getInt(1);
		}
		catch (MySQLIntegrityConstraintViolationException e)
		{
			return -1;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Effectue une requête dans la base de données
	 * @param query String
	 * @param type TypesRequete
	 * @return ResultSet : Le résultat de la requête
	 */
	public ResultSet reqSQL(String query, TypesRequete type)
	{
		switch(type)
		{
			case LECTURE:
				try
				{
					return st.executeQuery(query);
				}
				catch (SQLException e1)
				{
					System.err.println("Erreur dans l'execution de la rêquete d'interrogation");
					e1.printStackTrace();
					disconnect();
					System.exit(-1);
				}
			case MODIFICATION:
				try
				{
					st.executeUpdate(query);
				}
				catch (SQLException e)
				{
					System.err.println("Erreur dans l'execution de la rêquete de modification");
					e.printStackTrace();
					disconnect();
					System.exit(-1);
				}
				return null;
			default:
				System.out.println("Erreur type");
				return null;
		}
	}
	
	/**
	 * Vérifie si un utilisateur est connecté à la base de données
	 * @return Utilisateur : L'utilisateur connecté ou null
	 * @throws SQLException
	 */
	public Utilisateur verificationConnexion() throws SQLException
	{
		if (c.isClosed())
			return null;
		else
		return null;	//retourner utilisateur
	}

}
