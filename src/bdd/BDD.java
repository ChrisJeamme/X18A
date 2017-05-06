package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;

import donnees.Utilisateur;

public class BDD
{
	public enum TypesRequete
	{
		MODIFICATION, LECTURE
	}
	
	Connection c;
	Statement st;
	
	public BDD()
	{
		String serveur = "127.0.0.1";
		String identifiant = "chris";
		String mdp = "jKFe5FA4ef6";
		String port = "3306";
		String url = "jdbc:mysql://"+serveur/*+":"+port*/+"/x18a";
		
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
	public Utilisateur verificationConnexion() throws SQLException
	{
		if (c.isClosed())
			return null;
		else
		return null;	//retourner utilisateur
	}

}
