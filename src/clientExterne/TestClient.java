package clientExterne;

import donnees.Evenement;
import donnees.Utilisateur;

/**
 * Sert aux tests d'interaction entre le client externe et le serveur
 *
 */
public class TestClient
{

	public static void main(String[] args)
	{
		InteractionServeur iserv = new InteractionServeur();
		
		//Inscription
//		Utilisateur u = new Utilisateur("nom","prenom","maill","pseudoo","mdp");
//		System.out.println("Id de l'user avant: "+u.getId());
//		System.out.println("Ajout");
//		System.out.println(iserv.ajoutUtilisateur(u));
//		System.out.println("Id de l'user apr�s: "+u.getId());
		
		//Cr�ation d'un �venement
//		Evenement e = new Evenement("eventFromClientLourd",1000);
//		System.out.println("Id de l'�venement avant: "+e.getId());
//		System.out.println("Ajout");
//		System.out.println(iserv.ajoutEvenement(e));
//		System.out.println("Id de l'�venement apr�s: "+e.getId());
		
		//Connexion
		Utilisateur u2;
		System.out.println("Connexion");
		u2 = iserv.connexion("cjeamme","zpass");
		System.out.println("Id de l'user: "+u2.getId());
	}

}
