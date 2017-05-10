package clientExterne;

import donnees.Evenement;
import donnees.Utilisateur;

public class TestClient
{

	public static void main(String[] args)
	{
		InteractionServeur iserv = new InteractionServeur();
//		
//		Utilisateur u = new Utilisateur("nom","prenom","maill","pseudoo","mdp");
//		System.out.println("Id de l'user avant: "+u.getId());
//		System.out.println("Ajout");
//		System.out.println(iserv.ajoutUtilisateur(u));
//		System.out.println("Id de l'user après: "+u.getId());
//		
		Evenement e = new Evenement("eventFromClientLourd",1000);
		System.out.println("Id de l'évenement avant: "+e.getId());
		System.out.println("Ajout");
		System.out.println(iserv.ajoutEvenement(e));
		System.out.println("Id de l'évenement après: "+e.getId());
	}

}
