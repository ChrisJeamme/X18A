package serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur
{
	int port;
	ServerSocket server;
	
	public Serveur(int port)
	{
		this.port = port;
	}
	
	public void initialiser()
	{
		try
		{
			server = new ServerSocket(port);
			System.out.println("(Server) Serveur lancé");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
	}
	
	public void fermeture()
	{
		System.out.println("(Server) Fermeture du serveur");
		try
		{
			server.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
	}
	
	public String attente()
	{
		//Attente de connexion
		System.out.println("(Server) En attente d'une connexion");
		Socket s;
		try
		{
			s = server.accept();
			System.out.println("(Server) Nouvelle connexion");
			return echanges(s);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String echanges(Socket s)
	{
		String ligne = "";
		
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
				
				return recu;
				
//				if(ligne != null)
//				{
//					if(ligne.equals("finConnexion")) //Si la connexion a été fermé
//					{
//						System.out.println("(Server) Fermeture de la connexion");
//						in.close();
//						out.close();
//						s.close();
//					}
//				}
			}
			catch (IOException e)
			{
				System.err.println("Erreur d'entrée sortie");
				e.printStackTrace();
				System.exit(-1);
			}
		}
		return null;
	}
}