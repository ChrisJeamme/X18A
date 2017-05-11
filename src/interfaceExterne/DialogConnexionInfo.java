package interfaceExterne;

import clientExterne.InteractionServeurStatic;

public class DialogConnexionInfo {

	  public DialogConnexionInfo()
	  {}
	  public DialogConnexionInfo(String pseudo, String mdp){
	    AccueilNonConnecte.user = InteractionServeurStatic.currentInteractionServeur.connexion(pseudo, mdp);
	    if(AccueilNonConnecte.user.getId()==-1) // La connection a-t-elle marchee ?
	    {
	    	// Erreur mettre un messsage et retourner sur la page non connectee
	    }
	    else 
	    {
	    	// C'est bon aller sur la page connectee avec le user en session
	    }
	  }
	}