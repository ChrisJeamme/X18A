package clientExterne;

/**
 * Contient l'objet statique currentInteractionServeur
 *
 */
public class InteractionServeurStatic
{
	/**
	 * Sert au client externe pour envoyer des demandes
	 */
	public static InteractionServeur currentInteractionServeur = new InteractionServeur(); // Objet statique qui se partage entre toutes les pages

}