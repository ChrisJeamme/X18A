package serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Gère le serveur
 *
 */
public class Serveur
{
	int port;
	ServerSocket server;
	Socket client;
	BufferedReader in;
	PrintWriter out;
	
	/**
	 * Constructeur et initialisation du port
	 * @param port int
	 */
	public Serveur(int port)
	{
		this.port = port;
	}
	
	/**
	 * Initialisation du serveur
	 */
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
	
	/**
	 * Ferme le serveur
	 */
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
	
	/**
	 * Le serveur passe en attente de connection
	 */
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
	
	/**
	 * Envoie un message
	 * @param message String
	 */
	public void envoyer(String message)
	{
		out.println(message+"\nover");
		out.flush();
	}
	
	/**
	 * Reçoit un message
	 * @return String : Le message reçu
	 */
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