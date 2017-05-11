package interfaceClientLourd;

import donnees.Utilisateur;
import gestionReseauClientLourd.InteractionServeurStatic;

/**
 * Cree un DialogInscriptionInfo
 *
 */
public class DialogInscriptionInfo
{
	/**
	 * Constructeur vide
	 */
	public DialogInscriptionInfo(){}
	
	/**
	 * Constructeur avec les paramètres prédéfinis
	 * @param nom String
	 * @param prenom String
	 * @param email String
	 * @param pseudo String
	 * @param mdp String
	 */
	public DialogInscriptionInfo(String nom, String prenom, String email, String pseudo, String mdp)
	{
		Utilisateur nouveau = new Utilisateur(nom, prenom, email, pseudo, mdp);
		
	    if(InteractionServeurStatic.currentInteractionServeur.ajoutUtilisateur(nouveau))
	    {
	    	AccueilNonConnecte.user.setNom(nom);
	 	    AccueilNonConnecte.user.setPrenom(prenom);
	 	    AccueilNonConnecte.user.setEmail(email);
	 	    AccueilNonConnecte.user.setPseudo(pseudo);
	 	    AccueilNonConnecte.user.setMotDePasse(mdp);
	 	    
	 	    System.out.println("Inscrit et connecté");
	 	    AccueilConnecte.lancerInterface();
	    }
	    else
	    {
	    	System.out.println("Erreur d'inscription");
	    }
	   
	  
	}
	
}
