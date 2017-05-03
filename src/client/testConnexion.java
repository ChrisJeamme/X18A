package client;

import java.io.IOException;

public class testConnexion
{
	public static void main(String[] args) throws IOException
    {
    	Client client = new Client(18458);
    	client.etablirConnexion();
    	client.envoyerMessage("<a><b></b></a>");
    	client.fermetureConnexion();
    	//client.fermetureServeur();
    }
}
