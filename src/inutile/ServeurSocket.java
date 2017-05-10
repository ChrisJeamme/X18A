package inutile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSocket
{
	public static void main (String[] args) throws IOException
	{
		final int PORT = 18458;
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("(Server) Serveur lancé");
		
		String ligne = "";
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
					String recu = "";
					while((ligne = in.readLine()) != null && !ligne.equals("over") && !ligne.equals("finServeur") && !ligne.equals("finConnexion")) //On lit toutes les lignes
					{
						recu = recu.concat(ligne);
					}
					System.out.println("(Server) Reçu: "+recu);
					
					out.println("Bien reçu");
					out.println("over");
					out.flush();
					
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
					System.exit(-1);
				}
			}
		}
		System.out.println("(Server) Fermeture du serveur");
		server.close();
		
	}
}