package interfaceClientLourd;

import donnees.Utilisateur;
import gestionReseauClientLourd.InteractionServeurStatic;

/**
 * Cree un DialogConnexionInfo
 *
 */
public class DialogConnexionInfo
{
	/**
	 * Constructeur vide
	 */
	public DialogConnexionInfo()
	{}

	/**
	 * Constructeur avec les paramètres prédéfinis
	 * @param pseudo String
	 * @param mdp String
	 */
	public DialogConnexionInfo(String pseudo, String mdp)
	{
		Utilisateur userRecu = InteractionServeurStatic.currentInteractionServeur.connexion(pseudo, mdp);
		
		//On vérifie que la connexion a réussi
		
		if(userRecu.getId() != -1)
		{
			System.out.println("Connexion réussi");
			AccueilNonConnecte.user = userRecu;
	 	    AccueilConnecte.lancerInterface();
		}
		else
		{
			System.out.println("Connexion échoué");
		}
	}
}