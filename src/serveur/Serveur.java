package serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur
{
	int port;
	ServerSocket server;
	Socket client;
	BufferedReader in;
	PrintWriter out;
	
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
	
	public void attente()
	{
		//Attente de connexion
		System.out.println("(Server) En attente d'une connexion");
		try
		{
			client = server.accept();
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream());
			System.out.println("(Server) Nouvelle connexion");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void envoyer(String message)
	{
		out.println(message);
		out.println("over");
		out.flush();
	}
	
	public String recevoir()
	{
		String ligne = "";

		try
		{
			String recu = "";
			while((ligne = in.readLine()) != null && !ligne.equals("over") && !ligne.equals("finServeur") && !ligne.equals("finConnexion")) //On lit toutes les lignes
			{
				recu = recu.concat(ligne);
			}
			System.out.println("(Server) Reçu: "+recu);
						
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
		
		return null;
	}
}