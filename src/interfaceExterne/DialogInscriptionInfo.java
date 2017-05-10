package interfaceExterne;

import bdd.BDD;
import bdd.InteractionBDD;
import clientExterne.InteractionServeur;
import donnees.Utilisateur;

public class DialogInscriptionInfo {

	  private String nom, prenom, email, pseudo, mdp;
	
	public DialogInscriptionInfo(){}
	  public DialogInscriptionInfo(String nom, String prenom, String email, String pseudo, String mdp){
	    this.nom = nom;
	    this.prenom = prenom;
	    this.email = email;
	    this.pseudo = pseudo;
	    this.mdp = mdp;
	  }
	}