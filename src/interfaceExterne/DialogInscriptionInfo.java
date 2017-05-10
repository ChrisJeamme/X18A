package interfaceExterne;

import clientExterne.InteractionServeurStatic;
import donnees.Utilisateur;

public class DialogInscriptionInfo {

	public DialogInscriptionInfo(){}


	  public static Utilisateur u = new Utilisateur();
	
	public DialogInscriptionInfo(String nom, String prenom, String email, String pseudo, String mdp){
	    u.setNom(nom);
	    u.setPrenom(prenom);
	    u.setEmail(email);
	    u.setPseudo(pseudo);
	    u.setMotDePasse(mdp);
	    InteractionServeurStatic.currentInteractionServeur.ajoutUtilisateur(u);
	  
	}
	
}
