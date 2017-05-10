package interfaceExterne;

import clientExterne.InteractionServeurStatic;

public class DialogInscriptionInfo {

	public DialogInscriptionInfo(){}
	
	public DialogInscriptionInfo(String nom, String prenom, String email, String pseudo, String mdp){
	    AccueilNonConnecte.user.setNom(nom);
	    AccueilNonConnecte.user.setPrenom(prenom);
	    AccueilNonConnecte.user.setEmail(email);
	    AccueilNonConnecte.user.setPseudo(pseudo);
	    AccueilNonConnecte.user.setMotDePasse(mdp);
	    InteractionServeurStatic.currentInteractionServeur.ajoutUtilisateur(AccueilNonConnecte.user);
	  
	}
	
}
