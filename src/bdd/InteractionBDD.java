package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import bdd.BDD.TypesRequete;
import donnees.Chat;
import donnees.Depense;
import donnees.Evenement;
import donnees.Message;
import donnees.Utilisateur;


public class InteractionBDD
{
	//Vérifications utilisateur
	
	public static boolean pseudoExiste(BDD bdd, String pseudo)
	{
		ArrayList<Utilisateur> users = recupUtilisateurs(bdd);
		
		for(Utilisateur utilisateur : users)
		{
			if(utilisateur.getPseudo().compareTo(pseudo)==0)
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean emailExiste(BDD bdd, String email)
	{
		ArrayList<Utilisateur> users = recupUtilisateurs(bdd);
		
		for(Utilisateur utilisateur : users)
		{
			if(utilisateur.getEmail().compareTo(email)==0)
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean utilisateurParticpeAEvenement(BDD bdd, int idUtilisateur, int idEvenement)
	{
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT *"
							   + " FROM participe"
							   + " WHERE idUtilisateur = "+idUtilisateur
							   + " AND idEvenement = "+idEvenement+";",BDD.TypesRequete.LECTURE);
		
		try
		{
			if (r.next())
				return true;
			return false;
		} 
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		return false;
	}
	
	/**
	 *  Pour effectuer une connexion
	 * @param bdd
	 * @param pseudo
	 * @param mdp
	 * @return l'objet Utilisateur si ok, null sinon
	 */
	public static Utilisateur verificationConnexion(BDD bdd, String pseudo, String mdp)
	{
		ArrayList<Utilisateur> users = recupUtilisateurs(bdd);
		
		for(Utilisateur utilisateur : users)
		{
			if(utilisateur.getPseudo().compareTo(pseudo)==0)
			{
				if(utilisateur.getMotDePasse().compareTo(mdp)==0)
				{
					return utilisateur;
				}
				else
				{
					return null;
				}
			}
		}
		return null;
	}
	
	//Récupération de tous les objets
	
	/**
	 *  Récupère dans une liste toutes les dépenses de la bdd (aucun filtre)
	 * @param bdd
	 * @return
	 */
	public static ArrayList<Depense> recupDepenses(BDD bdd)
	{
		//Initialisation de la Liste à remplir
		ArrayList<Depense> listeDepense = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM depense",BDD.TypesRequete.LECTURE);
	
		//Traitement des résultats
		ResultSetMetaData meta = null;
		
		try
		{
			meta = (ResultSetMetaData) r.getMetaData();
			
			while(r.next())
			{
				Depense depense = new Depense();
				
				for(int i=1; i<=(meta.getColumnCount()); i++)
				{
					if(meta.getColumnLabel(i).compareTo("idUtilisateur") == 0)
						depense.setIdUtilisateur(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("idEvenement") == 0)
						depense.setIdEvenement(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("date") == 0)
						depense.setDate(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("description") == 0)
						depense.setDescription(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("montant") == 0)
						depense.setMontant(r.getInt(meta.getColumnName(i)));
				}
				
				//System.out.println("Ajout d'une nouvelle dépense: "+depense);
				listeDepense.add(depense);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeDepense;
}
	
	/**
	 *  Récupère dans une liste tous les évenements de la bdd (aucun filtre)
	 * @param bdd
	 * @return
	 */
	public static ArrayList<Evenement> recupEvenements(BDD bdd)
	{
		//Initialisation de la Liste à remplir
		ArrayList<Evenement> listeEvenements = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM evenements",BDD.TypesRequete.LECTURE);
	
		//Traitement des résultats
		ResultSetMetaData meta = null;
		
		try
		{
			meta = (ResultSetMetaData) r.getMetaData();
			
			while(r.next())
			{
				Evenement evenement = new Evenement();
				
				for(int i=1; i<=(meta.getColumnCount()); i++)
				{
					if(meta.getColumnLabel(i).compareTo("idEvenement") == 0)
						evenement.setId(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("nomEvenement") == 0)
						evenement.setNomEvenement(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("budget") == 0)
						evenement.setBudget(r.getInt(meta.getColumnName(i)));
				}
				
				//System.out.println("Ajout d'un nouvel evenement: "+evenement);
				listeEvenements.add(evenement);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeEvenements;
	}
	
	/**
	 *  Récupère dans une liste tous les utilisateurs contenu dans la bdd (aucun filtre)
	 * @param bdd
	 * @return
	 */
	public static ArrayList<Utilisateur> recupUtilisateurs(BDD bdd)
	{
		//Initialisation de la Liste à remplir
		ArrayList<Utilisateur> listeUsers = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM utilisateurs",BDD.TypesRequete.LECTURE);
	
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
					if(meta.getColumnLabel(i).compareTo("motDePasse") == 0)
						user.setMotDePasse(r.getString(meta.getColumnName(i)));
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
	
	/**
	 *  Récupère dans un objet Chat tous les messages de la bdd (aucun filtre)
	 * @param bdd
	 * @return
	 */
	public static Chat recupMessages(BDD bdd)
	{
		//Initialisation de la Liste à remplir
		Chat chat= new Chat();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM poste_message",BDD.TypesRequete.LECTURE);
	
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
				
				//System.out.println("Ajout d'un nouveeau message: "+message);
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

	//Récupération d'objets liés
	
	/**
	 *  Récupère toutes les dépenses d'un utilisateur
	 * @param bdd
	 * @param idUtilisateur
	 * @return Une liste de dépense
	 */
	public static ArrayList<Depense> recupDepensesDeUtilisateur(BDD bdd, int idUtilisateur)
	{
		//Initialisation de la Liste à remplir
		ArrayList<Depense> listeDepense = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM depense "
							   + "WHERE idUtilisateur = "+idUtilisateur+";",BDD.TypesRequete.LECTURE);
	
		//Traitement des résultats
		ResultSetMetaData meta = null;
		
		try
		{
			meta = (ResultSetMetaData) r.getMetaData();
			
			while(r.next())
			{
				Depense depense = new Depense();
				
				for(int i=1; i<=(meta.getColumnCount()); i++)
				{
					if(meta.getColumnLabel(i).compareTo("idUtilisateur") == 0)
						depense.setIdUtilisateur(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("idEvenement") == 0)
						depense.setIdEvenement(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("description") == 0)
						depense.setDescription(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("date") == 0)
						depense.setDate(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("montant") == 0)
						depense.setMontant(r.getInt(meta.getColumnName(i)));
				}
				
				listeDepense.add(depense);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeDepense;
	}
	
	/**
	 *  Récupère toutes les dépenses d'un événement
	 * @param bdd
	 * @param idEvenement
	 * @return Une liste de dépenses
	 */
	public static ArrayList<Depense> recupDepensesDeEvenement(BDD bdd, int idEvenement)
	{
		//Initialisation de la Liste à remplir
		ArrayList<Depense> listeDepense = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM depense "
							   + "WHERE idEvenement = "+idEvenement+";",BDD.TypesRequete.LECTURE);
	
		//Traitement des résultats
		ResultSetMetaData meta = null;
		
		try
		{
			meta = (ResultSetMetaData) r.getMetaData();
			
			while(r.next())
			{
				Depense depense = new Depense();
				
				for(int i=1; i<=(meta.getColumnCount()); i++)
				{
					if(meta.getColumnLabel(i).compareTo("idUtilisateur") == 0)
						depense.setIdUtilisateur(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("idEvenement") == 0)
						depense.setIdEvenement(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("description") == 0)
						depense.setDescription(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("date") == 0)
						depense.setDate(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("montant") == 0)
						depense.setMontant(r.getInt(meta.getColumnName(i)));
				}
				
				listeDepense.add(depense);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeDepense;
	}	

	
	/**
	 *  Récupère tous les évenements d'un utilisateur
	 * @param bdd
	 * @param idUtilisateur
	 * @return Une liste d'évenements
	 */
	public static ArrayList<Evenement> recupEvenementsDeUtilisateur(BDD bdd, int idUtilisateur)
	{
		//Initialisation de la Liste à remplir
		ArrayList<Evenement> listeEvenements = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT evenements.idEvenement,nomEvenement,budget"
							   + " FROM participe,evenements"
							   + " WHERE participe.idUtilisateur = "+idUtilisateur+""
							   + " AND evenements.idEvenement = participe.idEvenement;",BDD.TypesRequete.LECTURE);
		
		//Traitement des résultats
		ResultSetMetaData meta = null;
		
		try
		{
			meta = (ResultSetMetaData) r.getMetaData();
			
			while(r.next())
			{
				Evenement evenement = new Evenement();
				
				for(int i=1; i<=(meta.getColumnCount()); i++)
				{
					if(meta.getColumnLabel(i).compareTo("idEvenement") == 0)
						evenement.setId(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("nomEvenement") == 0)
						evenement.setNomEvenement(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("budget") == 0)
						evenement.setBudget(r.getInt(meta.getColumnName(i)));
				}
				
				//System.out.println("Ajout d'un nouvel evenement: "+evenement);
				listeEvenements.add(evenement);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeEvenements;
	}
	
	/**
	 *  Récupère toutes les utilisateurs d'un évenement
	 * @param bdd
	 * @param idEvenement
	 * @return Une liste d'utilisateurs
	 */
	public static ArrayList<Utilisateur> recupUtilisateursDeEvenement(BDD bdd, int idEvenement)
	{
		//Initialisation de la Liste à remplir
		ArrayList<Utilisateur> listeUsers = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT utilisateurs.idUtilisateur,nom,prenom,email,pseudo"
							   + " FROM utilisateurs,participe"
							   + " WHERE utilisateurs.idUtilisateur = participe.idUtilisateur"
							   + " AND idEvenement = "+idEvenement+";",BDD.TypesRequete.LECTURE);
	
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
					if(meta.getColumnLabel(i).compareTo("motDePasse") == 0)
						user.setMotDePasse(r.getString(meta.getColumnName(i)));
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

	/**
	 *  Récupère tous les messages d'un evenement
	 * @param bdd
	 * @param idEvenement
	 * @return Objet Chat contenant tous les messages de cet evenement
	 */
	public static Chat recupMessagesDeEvenement(BDD bdd, int idEvenement)
	{
		//Initialisation de la Liste à remplir
		Chat chat= new Chat();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT poste_message.idUtilisateur,idEvenement,date,message"
							   + " FROM poste_message, utilisateurs"
							   + " WHERE utilisateurs.idUtilisateur=poste_message.idUtilisateur"
							   + " AND idEvenement="+idEvenement+";",BDD.TypesRequete.LECTURE);
	
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

	//Récupération d'un objet avec son ID
	
	public static Utilisateur recupUtilisateurAvecID(BDD bdd, int idUtilisateur)
	{
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM utilisateurs WHERE idUtilisateur="+idUtilisateur+";",BDD.TypesRequete.LECTURE);
	
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
					if(meta.getColumnLabel(i).compareTo("motDePasse") == 0)
						user.setMotDePasse(r.getString(meta.getColumnName(i)));
				}
				
				return user;
			}
		}
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}

		return null;
	}
	
	public static Utilisateur recupUtilisateurAvecPseudo(BDD bdd, String pseudo)
	{
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM utilisateurs WHERE pseudo=\""+pseudo+"\";",BDD.TypesRequete.LECTURE);
	
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
					if(meta.getColumnLabel(i).compareTo("motDePasse") == 0)
						user.setMotDePasse(r.getString(meta.getColumnName(i)));
				}
				
				return user;
			}
		}
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}

		return null;
	}

	public static Evenement recupEvenementsAvecID(BDD bdd, int idEvenement)
	{
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM evenements WHERE idEvenement="+idEvenement+";",BDD.TypesRequete.LECTURE);
	
		//Traitement des résultats
		ResultSetMetaData meta = null;
		
		try
		{
			meta = (ResultSetMetaData) r.getMetaData();
			
			while(r.next())
			{
				Evenement evenement = new Evenement();
				
				for(int i=1; i<=(meta.getColumnCount()); i++)
				{
					if(meta.getColumnLabel(i).compareTo("idEvenement") == 0)
						evenement.setId(r.getInt(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("nomEvenement") == 0)
						evenement.setNomEvenement(r.getString(meta.getColumnName(i)));
					if(meta.getColumnLabel(i).compareTo("budget") == 0)
						evenement.setBudget(r.getInt(meta.getColumnName(i)));
				}
				
				return evenement;
			}
		}
		catch (SQLException e)
		{
			System.err.println("Problème SQL");
			e.printStackTrace();
		}
		
		return null;
	}
	
	//Envoi d'objet
	
	/**
	 *  Ajout l'objet Depense en argument dans la base de donnée bdd
	 * @param bdd Base de donnée chargée
	 * @param depense
	 */
	public static void ajoutDepense(BDD bdd, Depense depense)
	{
		ajoutDepense(bdd, depense.getIdUtilisateur(), depense.getIdEvenement(), depense.getDate(), depense.getMontant(), depense.getDescription());
	}
	
	/**
	 *  Ajout l'objet Depense en argument dans la base de donnée bdd
	 * @param bdd Base de donnée chargée
	 * @param idUtilisateur
	 * @param idEvenement
	 * @param date
	 * @param montant
	 */
	public static void ajoutDepense(BDD bdd, int idUtilisateur, int idEvenement, String date, int montant, String description)
	{
		System.out.println("INSERT INTO depense VALUES('"+idUtilisateur+"','"+idEvenement+"','"+date+"','"+montant+"','"+description+"');");
		bdd.reqSQL("INSERT INTO depense (`idUtilisateur`, `idEvenement`, `date`, `montant`, `description`) VALUES('"+idUtilisateur+"','"+idEvenement+"','"+date+"','"+montant+"','"+description+"');",TypesRequete.MODIFICATION);
	}
	
	/**
	 *  Ajout l'objet Evenement en argument dans la base de donnée bdd si il n'a pas déjà un id, et fixe l'id après l'ajout
	 * @param bdd Base de donnée chargée
	 * @param evenement L'objet Evenement à ajouter
	 */
	public static void ajoutEvenement(BDD bdd, Evenement evenement)
	{
		if(evenement.getId() == -1)
		{
			System.out.println("Cet évenement possède déjà un id (donc surement déjà dans la BDD)");
		}
		int id = ajoutEvenement(bdd, evenement.getNomEvenement(), evenement.getBudget());
		evenement.setId(id);
	}
	
	/**
	 *  Ajout l'objet Evenement en argument dans la base de donnée bdd et renvoi l'id
	 * @param bdd
	 * @param nom
	 * @param budget
	 */
	public static int ajoutEvenement(BDD bdd, String nom, int budget)
	{
		return bdd.reqSQLid("INSERT INTO evenements (`nomEvenement`, `budget`) VALUES('"+nom+"','"+budget+"');");
	}
	
	/**  
	 *  Ajout l'objet Utilisateur en argument dans la base de donnée bdd si l'id n'est pas fixé dans l'objet et le place après l'ajout (-1 si non place => existe déjà)
	 * @param bdd  Base de donnée chargée
	 * @param utilisateur
	 * 
	 */
	public static void ajoutUtilisateur(BDD bdd, Utilisateur utilisateur)
	{
		if(utilisateur.getId() != -1)
		{
			int id = ajoutUtilisateur(bdd, utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getPseudo(), utilisateur.getMotDePasse());
			utilisateur.setId(id);
		}
	}
	
	/**
	 *  Ajout l'objet Utilisateur en argument dans la base de donnée bdd
	 * @param bdd Base de donnée chargée
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param pseudo
	 * @param motDePasse
	 * @return -1 si le pseudo est déjà pris
	 */
	public static int ajoutUtilisateur(BDD bdd, String nom, String prenom, String email, String pseudo, String motDePasse)
	{
		return bdd.reqSQLid("INSERT INTO `utilisateurs` (`nom`, `prenom`, `email`, `pseudo`, `motDePasse`) VALUES ('"+nom+"', '"+prenom+"', '"+email+"', '"+pseudo+"', '"+motDePasse+"');");
	}

	/**
	 *  Ajout l'objet Message en argument dans la base de donnée bdd
	 * @param bdd  Base de donnée chargée
	 * @param message
	 */
	public static void ajoutMessage(BDD bdd, Message message)
	{
		ajoutMessage(bdd, message.getIdUtilisateur(), message.getIdEvenement(), message.getDate(), message.getTexte());
	}
	
	/**
	 *  Ajout l'objet Message en argument dans la base de donnée bdd
	 * @param bdd  Base de donnée chargée
	 * @param idUtilisateur
	 * @param idEvenement
	 * @param date
	 * @param message
	 */
	public static void ajoutMessage(BDD bdd, int idUtilisateur, int idEvenement, String date, String message)
	{
		bdd.reqSQL("INSERT INTO `poste_message` (`idUtilisateur`, `idEvenement`, `date`, `message`) VALUES ('"+idUtilisateur+"','"+idEvenement+"','"+date+"','"+message+"');",BDD.TypesRequete.MODIFICATION);
	}
	
	/**
	 *  Ajoute un lien dans la bdd de participation de utilisateur à evenement
	 * @param bdd
	 * @param utilisateur
	 * @param evenement
	 */
	public static void ajoutParticipe(BDD bdd, Utilisateur utilisateur, Evenement evenement)
	{
		ajoutParticipe(bdd, utilisateur.getId(), evenement.getId());
	}

	/**
	 *  Ajoute la participation de l'utilisateur idUtilisateur à l'évenement idEvenement
	 * @param bdd
	 * @param idUtilisateur
	 * @param idEvenement
	 */
	public static void ajoutParticipe(BDD bdd, int idUtilisateur, int idEvenement)
	{
		bdd.reqSQL("INSERT INTO `participe` (`idUtilisateur`, `idEvenement`) VALUES ('"+idUtilisateur+"','"+idEvenement+"');",BDD.TypesRequete.MODIFICATION);
	}
	
	/**
	 *  Renvoie une date formaté de type String pour la BDD
	 */
	public static String date()
	{
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = format.format(d);
		System.out.println(date);
		return date;
	}

	
}