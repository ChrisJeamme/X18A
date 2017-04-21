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
			Socket s = server.accept();
			System.out.println("(Server) Nouvelle connexion");
			
			while(true) //Boucle sur cette connexion
			{
				try
				{
					BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					PrintWriter out = new PrintWriter(s.getOutputStream());
					ligne = in.readLine();
				
					while(ligne != null && !ligne.equals("fin")) //On lit toutes les lignes
					{
						retourne = "Bien reçu";
						System.out.print("(Server) Reçu: "+ligne);
						
						out.println(retourne);
						out.flush();
						ligne = in.readLine();
					}
					
					if(ligne != null)
					{
						if(ligne.equals("fin")) //Si on a reçu la commande pour fermer la connexion
						{
							System.out.println("(Server) Fermeture de la connexion");
							out.println("Fermeture de la connexion");
							out.flush();
							s.close();
							fermeture = true;
						}
					}
				}
				catch (IOException e)
				{
					System.err.println("Erreur d'entrée sortie");
				}
			}
		}
		server.close();
	}
}