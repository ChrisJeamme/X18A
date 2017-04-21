package dealWithIt;

import java.io.*;
import java.net.*;

public class Client
{
	private int port;
	private Socket socket = null;

	public Client(int port)
	{
		this.port = port;
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
    		envoyerMessage("finConnexion");
			socket.close();
			System.out.println("(Client) Connexion fermée");
		}
    	catch (IOException e)
		{
			System.err.println("Erreur: Impossible de fermet la socket");
			e.printStackTrace();
		}
    }
    
    public void envoyerMessage(String message)
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
    				
    				System.out.println("(Client) Envoi : " + message);
                    writer.print(message+"\n");
                    writer.flush();
                    String reponse;
                    
                    while((reponse = reader.readLine()) != null)
                    {
                   		System.out.println("(Client) Recu : " + reponse);
                    }
                    
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
    	envoyerMessage("finServeur");
    }
}