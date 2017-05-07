package bdd;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;

import com.mysql.jdbc.ResultSetMetaData;

import bdd.BDD.TypesRequete;
import donnees.Depense;
import donnees.Message;
import donnees.Utilisateur;

public class TestDB
{
	public static void main(String args[])
	{
		//Connexion � la BDD
		BDD c = new BDD();
		
		
		
	
		//InteractionBDD.ajoutUtilisateur(c, new Utilisateur("Gourdin", "Jean-Jacques", "Jean-Jacques.Gourdin@rmc.bfmtv.com", "Jo Gros Gourdin", "FCf(RH�Efz-F(afAD*"));
		System.out.println(InteractionBDD.recupUtilisateurs(c));
		//InteractionBDD.ajoutMessage(c, new Message("Wesh", new java.sql.Date(new Date().getTime()), 2, 2));
		System.out.println(InteractionBDD.recupMessages(c));

		//InteractionBDD.ajoutDepense(c, new Depense(1,1,50,"2017-05-05 18:50:01"));
		System.out.println(InteractionBDD.recupDepenses(c));
		
		System.out.println(InteractionBDD.recupEvenements(c));
		
		System.out.println(InteractionBDD.recupDepensesDeUtilisateur(c,1));
		System.out.println(InteractionBDD.recupEvenementsDeUtilisateur(c,1));
		System.out.println(InteractionBDD.recupUtilisateursDeEvenement(c,1));
		System.out.println(InteractionBDD.recupMessagesDeEvenement(c,1));
		
		System.out.println(InteractionBDD.recupUtilisateurAvecID(c,1));
		System.out.println(InteractionBDD.recupEvenementsAvecID(c,1));
		
		System.out.println("Pseudo cjeamme existe? "+InteractionBDD.utilisateurExiste(c, "cjeamme"));
		System.out.println("Pseudo zizi existe? "+InteractionBDD.utilisateurExiste(c, "zizi"));
		System.out.println("Connexion avec cjeamme et pass ok? "+InteractionBDD.verificationConnexion(c, "cjeamme", "pass"));
		System.out.println("Connexion avec cjeamme et bfazkhbfazf ok? "+InteractionBDD.verificationConnexion(c, "cjeamme", "bfazkhbfazf"));

		System.out.println("Ajout d'un utilisateur, id dans la bdd = "+InteractionBDD.ajoutUtilisateur(c, "A", "B", "C", "D", "E"));
		InteractionBDD.ajoutParticipe(c, 2, 2);
		//System.out.println(InteractionBDD.ajoutDepense(c, 1, 1, new java.sql.Date(), 1); //PB DE DATE
		//InteractionBDD.ajoutMessage(c, 1, 1, date, "test"); //PB DE DATE
		InteractionBDD.ajoutEvenement(c, "L�venement", 10);
		
		//try{System.in.read();}catch (IOException e){e.printStackTrace();} //GETCHAR
		
		//On se d�connecte de la BDD
		c.disconnect();
	}
	
}
