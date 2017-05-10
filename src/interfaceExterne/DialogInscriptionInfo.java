package interfaceExterne;

import clientExterne.InteractionServeur;
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
	    InteractionServeur.currentInteractionServeur.ajoutUtilisateur(u);
	  
	}
	
}
