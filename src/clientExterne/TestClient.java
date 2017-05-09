package clientExterne;

public class TestClient
{

	public static void main(String[] args)
	{
		Client client = new Client();
    	client.etablirConnexion();
    	client.envoyerMessage("<a><b></b></a>");
    	client.fermetureConnexion();
    	//client.fermetureServeur();
	}

}
