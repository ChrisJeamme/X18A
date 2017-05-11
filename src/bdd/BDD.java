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
 * G�re la connexion � la base de donn�es
 *
 */
public class BDD
{
	/**
	 * Liste des interactions possible avec la base de donn�es
	 *
	 */
	public enum TypesRequete
	{
		MODIFICATION, LECTURE, RETOURID
	}
	
	Connection c;
	Statement st;
	
	/**
	 * Constructeur et connexion � la base de donn�es
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
				System.out.println("Connexion charg�");
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
	 * D�connexion de la base de donn�es
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
		System.out.println("Connexion ferm�");
	}
	
	/**
	 * Affiche le r�sultat de la requ�te � la base de donn�es
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
			System.out.println("R�sultat de la r�quete:");
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
					System.out.println("Probl�me acc�s i="+i);
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
	 * Effectue une mise � jour dans la base de donn�es
	 * @param query String
	 * @return int : L'id du r�sultat
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
	 * Effectue une requ�te dans la base de donn�es
	 * @param query String
	 * @param type TypesRequete
	 * @return ResultSet : Le r�sultat de la requ�te
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
					System.err.println("Erreur dans l'execution de la r�quete d'interrogation");
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
					System.err.println("Erreur dans l'execution de la r�quete de modification");
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
	 * V�rifie si un utilisateur est connect� � la base de donn�es
	 * @return Utilisateur : L'utilisateur connect� ou null
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
