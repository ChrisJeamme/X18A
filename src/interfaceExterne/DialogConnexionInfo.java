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
		
		//On v�rifie que la connexion a r�ussi
		
		if(userRecu.getId() != -1)
		{
			System.out.println("Connexion r�ussi");
			AccueilNonConnecte.user = userRecu;
			// C'est bon aller sur la page connectee avec le user en session
		}
		else
		{
			System.out.println("Connexion �chou�");
			// Erreur Retourner sur la page non connectee
		}
	}
}