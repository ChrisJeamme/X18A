package clientExterne;

import donnees.Evenement;
import donnees.Utilisateur;

public class TestClient
{

	public static void main(String[] args)
	{
		InteractionServeur iserv = new InteractionServeur();
		
		System.out.println(iserv.ajoutUtilisateur(new Utilisateur("nom","prenom","maill","pseudoo","mdp")));
		
		
//		Evenement e = new Evenement("eventFromClientLourd",1000);
//		System.out.println("Id de l'évenement avant: "+e.getId());
//		System.out.println("Ajout");
//		System.out.println(iserv.ajoutEvenement(e));
//		System.out.println("Id de l'évenement après: "+e.getId());
	}

}
