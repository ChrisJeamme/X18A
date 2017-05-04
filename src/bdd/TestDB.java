package bdd;

import java.sql.ResultSet;

public class TestDB
{
	public static void main(String args[])
	{
		BDD c = new BDD();		
		
		ResultSet r = c.reqSQL("SELECT * FROM utilisateurs",BDD.TypesRequete.LECTURE);
		
		c.afficherRes(r);	
		
		//On se déconnecte de la BDD
		c.disconnect();
	}
	
}
