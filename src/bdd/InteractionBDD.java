package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

import bdd.BDD.TypesRequete;
import donnees.Chat;
import donnees.Depense;
import donnees.Evenement;
import donnees.Message;
import donnees.Utilisateur;

public class InteractionBDD
{
	//V�rifications utilisateur
	
	public static boolean utilisateurExiste(BDD bdd, String pseudo)
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
	
	public static boolean verificationConnexion(BDD bdd, String pseudo, String mdp)
	{
		ArrayList<Utilisateur> users = recupUtilisateurs(bdd);
		
		for(Utilisateur utilisateur : users)
		{
			if(utilisateur.getPseudo().compareTo(pseudo)==0)
			{
				if(utilisateur.getMotDePasse().compareTo(mdp)==0)
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	//R�cup�ration de tous les objets
	
	/**
	 *  R�cup�re dans une liste toutes les d�penses de la bdd (aucun filtre)
	 * @param bdd
	 * @return
	 */
	public static ArrayList<Depense> recupDepenses(BDD bdd)
	{
		//Initialisation de la Liste � remplir
		ArrayList<Depense> listeDepense = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM depense",TypesRequete.LECTURE);
	
		//Traitement des r�sultats
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
					if(meta.getColumnLabel(i).compareTo("montant") == 0)
						depense.setMontant(r.getInt(meta.getColumnName(i)));
				}
				
				//System.out.println("Ajout d'une nouvelle d�pense: "+depense);
				listeDepense.add(depense);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Probl�me SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeDepense;
}
	
	/**
	 *  R�cup�re dans une liste tous les �venements de la bdd (aucun filtre)
	 * @param bdd
	 * @return
	 */
	public static ArrayList<Evenement> recupEvenements(BDD bdd)
	{
		//Initialisation de la Liste � remplir
		ArrayList<Evenement> listeEvenements = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM evenements",TypesRequete.LECTURE);
	
		//Traitement des r�sultats
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
			System.err.println("Probl�me SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeEvenements;
	}
	
	/**
	 *  R�cup�re dans une liste tous les utilisateurs contenu dans la bdd (aucun filtre)
	 * @param bdd
	 * @return
	 */
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
					if(meta.getColumnLabel(i).compareTo("motDePasse") == 0)
						user.setMotDePasse(r.getString(meta.getColumnName(i)));
				}
				
				//System.out.println("Ajout d'un nouvel utilisateur: "+user);
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
	
	/**
	 *  R�cup�re dans un objet Chat tous les messages de la bdd (aucun filtre)
	 * @param bdd
	 * @return
	 */
	public static Chat recupMessages(BDD bdd)
	{
		//Initialisation de la Liste � remplir
		Chat chat= new Chat();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM poste_message",TypesRequete.LECTURE);
	
		//Traitement des r�sultats
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
			System.err.println("Probl�me SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return chat;
	}

	//R�cup�ration d'objets li�s
	
	/**
	 *  R�cup�re toutes les d�penses d'un utilisateur
	 * @param bdd
	 * @param idUtilisateur
	 * @return Une liste de d�pense
	 */
	public static ArrayList<Depense> recupDepensesDeUtilisateur(BDD bdd, int idUtilisateur)
	{
		//Initialisation de la Liste � remplir
		ArrayList<Depense> listeDepense = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM depense "
							   + "WHERE idUtilisateur = "+idUtilisateur+";",TypesRequete.LECTURE);
	
		//Traitement des r�sultats
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
					if(meta.getColumnLabel(i).compareTo("montant") == 0)
						depense.setMontant(r.getInt(meta.getColumnName(i)));
				}
				
				listeDepense.add(depense);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Probl�me SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeDepense;
}
	
	/**
	 *  R�cup�re tous les �venements d'un utilisateur
	 * @param bdd
	 * @param idUtilisateur
	 * @return Une liste d'�venements
	 */
	public static ArrayList<Evenement> recupEvenementsDeUtilisateur(BDD bdd, int idUtilisateur)
	{
		//Initialisation de la Liste � remplir
		ArrayList<Evenement> listeEvenements = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT evenements.idEvenement,nomEvenement,budget"
							   + " FROM participe,evenements"
							   + " WHERE participe.idUtilisateur = "+idUtilisateur+""
							   + " AND evenements.idEvenement = participe.idEvenement;",TypesRequete.LECTURE);
		
		//Traitement des r�sultats
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
			System.err.println("Probl�me SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeEvenements;
	}
	
	/**
	 *  R�cup�re toutes les utilisateurs d'un �venement
	 * @param bdd
	 * @param idEvenement
	 * @return Une liste d'utilisateurs
	 */
	public static ArrayList<Utilisateur> recupUtilisateursDeEvenement(BDD bdd, int idEvenement)
	{
		//Initialisation de la Liste � remplir
		ArrayList<Utilisateur> listeUsers = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT utilisateurs.idUtilisateur,nom,prenom,email,pseudo"
							   + " FROM utilisateurs,participe"
							   + " WHERE utilisateurs.idUtilisateur = participe.idUtilisateur"
							   + " AND idEvenement = "+idEvenement+";",TypesRequete.LECTURE);
	
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
					if(meta.getColumnLabel(i).compareTo("motDePasse") == 0)
						user.setMotDePasse(r.getString(meta.getColumnName(i)));
				}
				
				//System.out.println("Ajout d'un nouvel utilisateur: "+user);
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

	/**
	 *  R�cup�re tous les messages d'un evenement
	 * @param bdd
	 * @param idEvenement
	 * @return Objet Chat contenant tous les messages de cet evenement
	 */
	public static Chat recupMessagesDeEvenement(BDD bdd, int idEvenement)
	{
		//Initialisation de la Liste � remplir
		Chat chat= new Chat();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT poste_message.idUtilisateur,idEvenement,date,message"
							   + " FROM poste_message, utilisateurs"
							   + " WHERE utilisateurs.idUtilisateur=poste_message.idUtilisateur"
							   + " AND idEvenement="+idEvenement+";",TypesRequete.LECTURE);
	
		//Traitement des r�sultats
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
			System.err.println("Probl�me SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return chat;
	}

	//R�cup�ration d'un objet avec son ID
	
	public static ArrayList<Utilisateur> recupUtilisateurAvecID(BDD bdd, int idUtilisateur)
	{
		//Initialisation de la Liste � remplir
		ArrayList<Utilisateur> listeUsers = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM utilisateurs WHERE idUtilisateur="+idUtilisateur+";",TypesRequete.LECTURE);
	
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
					if(meta.getColumnLabel(i).compareTo("motDePasse") == 0)
						user.setMotDePasse(r.getString(meta.getColumnName(i)));
				}
				
				//System.out.println("Ajout d'un nouvel utilisateur: "+user);
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

	public static ArrayList<Evenement> recupEvenementsAvecID(BDD bdd, int idEvenement)
	{
		//Initialisation de la Liste � remplir
		ArrayList<Evenement> listeEvenements = new ArrayList<>();
		
		//Lancement de la requete
		ResultSet r = bdd.reqSQL("SELECT * FROM evenements WHERE idEvenement="+idEvenement+";",TypesRequete.LECTURE);
	
		//Traitement des r�sultats
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
				
				listeEvenements.add(evenement);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Probl�me SQL");
			e.printStackTrace();
			bdd.disconnect();
			System.exit(-1);
		}
		
		return listeEvenements;
	}
	
	//Envoi d'objet
	
	/**
	 *  Ajout l'objet Depense en argument dans la base de donn�e bdd
	 * @param bdd Base de donn�e charg�e
	 * @param depense
	 */
	public static void ajoutDepense(BDD bdd, Depense depense)
	{
		ajoutDepense(bdd, depense.getIdUtilisateur(), depense.getIdEvenement(), depense.getDate(), depense.getMontant());
	}
	
	/**
	 *  Ajout l'objet Depense en argument dans la base de donn�e bdd
	 * @param bdd Base de donn�e charg�e
	 * @param idUtilisateur
	 * @param idEvenement
	 * @param date
	 * @param montant
	 */
	public static void ajoutDepense(BDD bdd, int idUtilisateur, int idEvenement, java.sql.Date date, int montant)
	{
		bdd.reqSQL("INSERT INTO depense VALUES('"+idUtilisateur+"','"+idEvenement+"','"+date+"','"+montant+"');",TypesRequete.MODIFICATION);
	}
	
	/**
	 *  Ajout l'objet Evenement en argument dans la base de donn�e bdd
	 * @param bdd Base de donn�e charg�e
	 * @param evenement L'objet Evenement � ajouter
	 */
	public static void ajoutEvenement(BDD bdd, Evenement evenement)
	{
		ajoutEvenement(bdd, evenement.getNomEvenement(), evenement.getBudget());
	}
	
	/**
	 *  Ajout l'objet Evenement en argument dans la base de donn�e bdd
	 * @param bdd
	 * @param nom
	 * @param budget
	 */
	public static void ajoutEvenement(BDD bdd, String nom, int budget)
	{
		bdd.reqSQL("INSERT INTO evenements VALUES('"+nom+"','"+budget+"');",TypesRequete.MODIFICATION);
	}
	
	/**  
	 *  Ajout l'objet Utilisateur en argument dans la base de donn�e bdd
	 * @param bdd  Base de donn�e charg�e
	 * @param utilisateur
	 */
	public static void ajoutUtilisateur(BDD bdd, Utilisateur utilisateur)
	{
		ajoutUtilisateur(bdd, utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getPseudo(), utilisateur.getMotDePasse());
	}
	
	/**
	 *  Ajout l'objet Utilisateur en argument dans la base de donn�e bdd
	 * @param bdd Base de donn�e charg�e
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param pseudo
	 * @param motDePasse
	 */
	public static void ajoutUtilisateur(BDD bdd, String nom, String prenom, String email, String pseudo, String motDePasse)
	{
		bdd.reqSQL("INSERT INTO `utilisateurs` (`nom`, `prenom`, `email`, `pseudo`, `motDePasse`) VALUES ('"+nom+"', '"+prenom+"', '"+email+"', '"+pseudo+"', '"+motDePasse+"');",TypesRequete.MODIFICATION);
	}

	/**
	 *  Ajout l'objet Message en argument dans la base de donn�e bdd
	 * @param bdd  Base de donn�e charg�e
	 * @param message
	 */
	public static void ajoutMessage(BDD bdd, Message message)
	{
		ajoutMessage(bdd, message.getIdUtilisateur(), message.getIdEvenement(), message.getDate(), message.getTexte());
	}
	
	/**
	 *  Ajout l'objet Message en argument dans la base de donn�e bdd
	 * @param bdd  Base de donn�e charg�e
	 * @param idUtilisateur
	 * @param idEvenement
	 * @param date
	 * @param message
	 */
	public static void ajoutMessage(BDD bdd, int idUtilisateur, int idEvenement, java.sql.Date date, String message)
	{
		bdd.reqSQL("INSERT INTO `poste_message` (`idUtilisateur`, `idEvenement`, `date`, `message`) VALUES ('"+idUtilisateur+"','"+idEvenement+"','"+date+"','"+message+"');",TypesRequete.MODIFICATION);
	}
	
}