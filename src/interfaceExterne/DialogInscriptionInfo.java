package interfaceExterne;

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

	  public String toString(){
	    String str;
	    if(this.nom != null && this.prenom != null && this.mdp != null && this.email != null && this.pseudo != null){
	      Utilisateur newUtil = new Utilisateur(this.nom, this.prenom, this.email, this.pseudo, this.mdp);
	      
	      InteractionServeur.currentInteractionServeur.ajoutUtilisateur(newUtil);

	      str = "Bienvenue " + this.pseudo + " !";
	    }
	    else{
	      str = "Aucune information !";
	    }
	    return str;
	  }
	}