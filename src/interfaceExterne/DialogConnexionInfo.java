package interfaceExterne;

import clientExterne.InteractionServeurStatic;
import donnees.Utilisateur;

public class DialogConnexionInfo
{
	public DialogConnexionInfo()
	{}

	public DialogConnexionInfo(String pseudo, String mdp)
	{
		Utilisateur userRecu = InteractionServeurStatic.currentInteractionServeur.connexion(pseudo, mdp);
		
		//On vérifie que la connexion a réussi
		
		if(userRecu.getId() != -1)
		{
			System.out.println("Connexion réussi");
			AccueilNonConnecte.user = userRecu;
			// C'est bon aller sur la page connectee avec le user en session
		}
		else
		{
			System.out.println("Connexion échoué");
			// Erreur Retourner sur la page non connectee
		}
	}
}