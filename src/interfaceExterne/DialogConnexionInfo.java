package interfaceExterne;

import bdd.BDD;
import bdd.InteractionBDD;
import clientExterne.InteractionServeur;
import donnees.Utilisateur;

public class DialogConnexionInfo {
	  private String pseudo, mdp;

	  public DialogConnexionInfo(){}
	  public DialogConnexionInfo(String pseudo, String mdp){
		Utilisateur u = new Utilisateur();
	    u.setPseudo(pseudo);
	    u.setMotDePasse(mdp);
	    
	    /*BDD db = new BDD();

		String redirection;
		String message;
		Utilisateur u = InteractionBDD.verificationConnexion(db, pseudo, mdp);
		if (u != null) //L'utilisateur existe et s'est correctement authentifié
		{
			message = "Bonjour";
		}
		else 
		{
			message = "Utilisateur inconnu ou mot de passe incorrect.";
		}
		db.disconnect();*/
	    
	    //InteractionServeur.currentInteractionServeur.ajoutUtilisateur(u);
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