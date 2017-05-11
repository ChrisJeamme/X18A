package gestionReseauServeurLourd;

import java.io.IOException;

/**
 * Sert aux tests sur le serveur
 *
 */
public class TestServeur
{
	public static void main(String[] args) throws IOException
    {
		int port = 18458;
		GestionServeur g = new GestionServeur(port);
		g.start();
    }
}