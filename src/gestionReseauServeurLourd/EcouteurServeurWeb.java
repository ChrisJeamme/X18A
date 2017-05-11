package gestionReseauServeurLourd;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Ecouteur de cycle de vie des servelet
 * Sert � lancer/fermer le serveur des clients lourds en m�me temps que celui pour le web
 */
@WebListener
public class EcouteurServeurWeb implements ServletContextListener
{
	/**
	 *  Thread GestionServeur qu'on va lancer ou arr�ter
	 */
	GestionServeur gestionServeur;

    public EcouteurServeurWeb()
    {}

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)
    { 
    	if(sce.getServletContext().getServletContextName().compareTo("X18A")==0)
    	{
    		System.out.println("Arr�t du serveur client lourd");
    		gestionServeur.arret();
    	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)
    { 
    	if(sce.getServletContext().getServletContextName().compareTo("X18A")==0)
    	{
    		System.out.println("Lancement du serveur client lourd");
    		int port = 18458;
    		gestionServeur = new GestionServeur(port);
    		gestionServeur.start();
    	}
    }
	
}
