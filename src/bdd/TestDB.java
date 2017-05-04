package bdd;

public class TestDB
{
	public static void main(String args[])
	{
		BDD c = new BDD();	
		
		System.out.println(InteractionBDD.recupUtilisateurs(c));
		
		//ResultSet r = c.reqSQL("SELECT * FROM utilisateurs",BDD.TypesRequete.LECTURE);
		
		//c.afficherRes(r);	
		
		//On se déconnecte de la BDD
		c.disconnect();
	}
	
}
