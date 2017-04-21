package dealWithIt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur
{
	public static void main (String[] args) throws IOException
	{
		final int PORT = 18458;
		ServerSocket server = new ServerSocket(PORT, 1);
		System.out.println("(Server) Serveur lancé");
		
		String ligne = "";
		String retourne;
		boolean fermeture = false;
		
		while(!fermeture)	//Boucles des connexions
		{
			//Attente de connexion
			System.out.println("(Server) En attente d'une connexion");
			Socket s = server.accept();
			System.out.println("(Server) Nouvelle connexion");
			
			while(!s.isClosed()) //Boucle sur cette connexion
			{
				try
				{
					BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					PrintWriter out = new PrintWriter(s.getOutputStream());
					ligne = in.readLine();
					
					if(ligne == null)
						out.flush();
					
					while(ligne != null && !ligne.equals("finServeur") && !ligne.equals("finConnexion")) //On lit toutes les lignes
					{
						retourne = "Bien reçu";
						System.out.print("(Server) Reçu: "+ligne);
						
						out.println(retourne);
						out.flush();
						ligne = in.readLine();
					}
					
					if(ligne != null)
					{
						if(ligne.equals("finConnexion")) //Si la connexion a été fermé
						{
							System.out.println("(Server) Fermeture de la connexion");
							in.close();
							out.close();
							s.close();
						}
						if(ligne.equals("finServeur")) //Si on a reçu la commande pour fermer le serveur
						{
							out.println("Fermeture du serveur");
							out.flush();
							in.close();
							out.close();
							s.close();
							fermeture = true;
						}
					}
				}
				catch (IOException e)
				{
					System.err.println("Erreur d'entrée sortie");
					e.printStackTrace();
				}
			}
		}
		System.out.println("(Server) Fermeture du serveur");
		server.close();
		
	}
}