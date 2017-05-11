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
	 * Constructeur avec les param�tres pr�d�finis
	 * @param pseudo String
	 * @param mdp String
	 */
	public DialogConnexionInfo(String pseudo, String mdp)
	{
		Utilisateur userRecu = InteractionServeurStatic.currentInteractionServeur.connexion(pseudo, mdp);
		
		//On v�rifie que la connexion a r�ussi
		
		if(userRecu.getId() != -1)
		{
			System.out.println("Connexion r�ussi");
			AccueilNonConnecte.user = userRecu;
	 	    AccueilConnecte.lancerInterface();
		}
		else
		{
			System.out.println("Connexion �chou�");
		}
	}
}