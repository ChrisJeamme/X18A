package interfaceExterne;

import clientExterne.InteractionServeur;
import donnees.Utilisateur;

public class DialogConnexionInfo {

	  public DialogConnexionInfo()
	  {}
	  public DialogConnexionInfo(String pseudo, String mdp){
		Utilisateur u = new Utilisateur();
	    u = InteractionServeur.currentInteractionServeur.connexion(pseudo, mdp);
	  }
	}