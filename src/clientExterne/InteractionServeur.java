package clientExterne;

public class InteractionServeur
{
	Client client;
	
	public InteractionServeur()
	{
		client = new Client();
	}
	
	public void envoiServeur(String texte)
	{
		client.etablirConnexion();
    	client.envoyerMessage("<a><b></b></a>");
    	client.fermetureConnexion();
	}
}
