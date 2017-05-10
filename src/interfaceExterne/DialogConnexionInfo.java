package interfaceExterne;

import clientExterne.InteractionServeurStatic;
import donnees.Utilisateur;

public class DialogConnexionInfo {

	  public DialogConnexionInfo()
	  {}
	  public DialogConnexionInfo(String pseudo, String mdp){
		Utilisateur u = new Utilisateur();
	    u = InteractionServeurStatic.currentInteractionServeur.connexion(pseudo, mdp);
	  }
	}