package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;

public class BDD
{
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
	
	public ResultSet reqSQL(String query, char type)
	{
		switch(type)
		{
			case 's':
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
			case 'm':
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
	 * 	
	 * @return Le nombre d'utilisateur dans la BDD
	 */
	public int nombreUtilisateur()
	{
		ResultSet r = reqSQL("SELECT COUNT(userID) FROM utilisateur;",'s');
		try
		{
			r.next();
			return r.getInt(1);
		}
		catch (SQLException e)
		{
			System.err.println("Erreur lors de la récupération du nombre d'utilisateurs");
			e.printStackTrace();
		}
		disconnect();
		System.exit(-1);
		return 0;
	}
	
	public void inscriptionRandom(int nombre)
	{
		int nombreUtilisateur = nombreUtilisateur();
		for(int i=(1+nombreUtilisateur); i<=(1+nombreUtilisateur+nombre); i++)
		{
			genererMembre(i);
		}
	}
	
	public void genererMembre(int nombre)
	{	
		String nom = genererNom();
		System.out.println("Nouveau membre: "+nom);
		
		reqSQL("INSERT INTO utilisateur VALUES("+nombre+",'"+nom+"','"+genererNom()+"','"+nom+"@mail.com',1234);", 'm');
	}

	private String genererNom()
	{
		int longueur = (int) (((Math.random()*10)%7)+3);
		char[] nom = new char[longueur];
		
		for(int i=0; i<longueur; i++)
		{
			nom[i] = (char)( ((Math.random()*150)%26)+97);
		}
		
		return String.copyValueOf(nom);
	}
}
