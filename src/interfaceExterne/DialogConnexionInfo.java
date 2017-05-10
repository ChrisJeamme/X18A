package interfaceExterne;

import clientExterne.InteractionServeurStatic;

public class DialogConnexionInfo {

	  public DialogConnexionInfo()
	  {}
	  public DialogConnexionInfo(String pseudo, String mdp){
	    AccueilNonConnecte.user = InteractionServeurStatic.currentInteractionServeur.connexion(pseudo, mdp);
	  }
	}