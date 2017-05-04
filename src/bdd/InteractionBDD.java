package bdd;

import java.sql.ResultSet;
import java.util.ArrayList;

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
		ArrayList<Utilisateur> listeUsers = new ArrayList<>();
		
		ResultSet r = bdd.reqSQL("SELECT * FROM utilisateurs",TypesRequete.LECTURE);
		
		//Parcourir les résultats en ajoutant à listeUsers à chaque fois:
		//listeUsers.add(new Utilisateur(id, nom, prenom, email, pseudo));
		//Pour voir comment parcourir, voir: BDD.afficherRes(ResultSet r)
		
		return listeUsers;
	}
	
	public static Message recupMessages(BDD bdd)
	{
		return null;
		
	}
}
