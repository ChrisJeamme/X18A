package clientExterne;

import donnees.Utilisateur;

public class TestClient
{

	public static void main(String[] args)
	{
		InteractionServeur iserv = new InteractionServeur();
		
		System.out.println(iserv.ajoutUtilisateur(new Utilisateur("nom","prenom","maill","pseudoo","mdp")));
	}

}
