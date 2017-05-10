package interfaceExterne;

import clientExterne.InteractionServeur;
import donnees.Utilisateur;

public class DialogConnexionInfo {
	  private String pseudo, mdp;

	  public DialogConnexionInfo(){}
	  public DialogConnexionInfo(String pseudo, String mdp){
		Utilisateur u = new Utilisateur();
	    u= InteractionServeur.currentInteractionServeur.connexion(pseudo, mdp);
	  }

	  public String toString(){
	    String str;
	    if(this.pseudo != null && this.mdp != null){
	      str = "Bonjour ";
	      str += this.pseudo + " ! \n";
	    }
	    else{
	      str = "Aucune information !";
	    }
	    return str;
	  }
	}