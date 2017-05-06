package serveur;

import java.io.IOException;
import java.util.Date;

public class Test
{
	public static void main(String[] args) throws IOException
    {
		//GestionServeur g = new GestionServeur();
		
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		
		System.out.println(date);
    }
}
