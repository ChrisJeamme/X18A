package clientExterne;

import java.io.*;
import java.net.*;

public class Client
{
	private int port;
	private Socket socket = null;

	public Client()
	{
		this.port = 18458;
	}
    
    public void etablirConnexion()
    {
        try
        {
        	socket = new Socket("127.0.0.1", port);
            System.out.println("(Client) Connexion établie");
        }
        catch(ConnectException e)
        {
        	System.err.println("Erreur de connexion au serveur");
        }
        catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
        catch (IOException e)
		{
			e.printStackTrace();
		}
    }
    
    public void fermetureConnexion()
    {
    	try
    	{
	    	System.out.println("(Client) Envoi demande fin connexion");
	    	envoyerMessageSansAffichage("finConnexion");
			socket.close();
			System.out.println("(Client) Connexion fermée");
    	}
    	catch (IOException e)
		{
			System.err.println("Erreur: Impossible de fermet la socket");
			e.printStackTrace();
		}
    }
    
    public String envoyerMessage(String message)
    {
    	String recu = "";
    	if(socket != null)
    	{
    		if(!socket.isClosed())
    		{
    			try
    			{
    	            InputStream in = socket.getInputStream();
    	            OutputStream out = socket.getOutputStream();
    	            BufferedReader reader = new BufferedReader (new InputStreamReader(in));
    	            PrintWriter writer = new PrintWriter(out);
    				
    				System.out.println("(Client) Envoi : " + message);
                    writer.print(message+"\nover\n");
                    writer.flush();
                    String reponse;
                    
                    while(!(reponse = reader.readLine()).equals("over") && reponse != null)
                    {
                    	recu.concat(reponse);
                    }
                    
               		//System.out.println("(Client) Recu : " + recu);
                }
                catch(ConnectException e)
                {
                	System.err.println("Erreur de connexion au serveur");
                }
                catch (UnknownHostException e)
        		{
        			e.printStackTrace();
        		}
                catch (IOException e)
        		{
        			e.printStackTrace();
        		}
    			
    		}
       	}
    	envoyerMessageSansAffichage("over");
    	return recu;
    }

    public void envoyerMessageSansAffichage(String message)
    {
    	if(socket != null)
    	{
    		if(!socket.isClosed())
    		{
    			try
    			{
    	            InputStream in = socket.getInputStream();
    	            OutputStream out = socket.getOutputStream();
    	            BufferedReader reader = new BufferedReader (new InputStreamReader(in));
    	            PrintWriter writer = new PrintWriter(out);
    				
                    writer.print(message+"\nover\n");
                    writer.flush();
                    String reponse;
                    
                    while(!(reponse = reader.readLine()).equals("over") && reponse != null){}
                }
                catch(ConnectException e)
                {
                	System.err.println("Erreur de connexion au serveur");
                }
                catch (UnknownHostException e)
        		{
        			e.printStackTrace();
        		}
                catch (IOException e)
        		{
        			e.printStackTrace();
        		}
     
    		}
       	}
    }
    
    public void fermetureServeur()
    {
    	System.out.println("(Client) Envoi demande fin serveur");
    	envoyerMessageSansAffichage("finServer");
    }
}