package bdd;

public class TestDB
{
	public static void main(String args[])
	{
		BDD c = new BDD();
		
		//System.out.println(InteractionBDD.recupUtilisateurs(c));
		//System.out.println(InteractionBDD.recupMessages(c));
		//System.out.println(InteractionBDD.recupDepenses(c));
		//System.out.println(InteractionBDD.recupEvenements(c));
		
		//System.out.println(InteractionBDD.recupDepensesDeUtilisateur(c,1));
		//System.out.println(InteractionBDD.recupEvenementsDeUtilisateur(c,1));
		//System.out.println(InteractionBDD.recupUtilisateursDeEvenement(c,1));
		//System.out.println(InteractionBDD.recupMessagesDeEvenement(c,1));
		
		//System.out.println(InteractionBDD.recupUtilisateurAvecID(c,1));
		//System.out.println(InteractionBDD.recupEvenementsAvecID(c,1));
		
		//ResultSet r = c.reqSQL("SELECT * FROM utilisateurs",BDD.TypesRequete.LECTURE);
		
		//c.afficherRes(r);	
		
		//On se déconnecte de la BDD
		c.disconnect();
	}
	
}
