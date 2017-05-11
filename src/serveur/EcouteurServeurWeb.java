package serveur;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EcouteurServeurWeb
 *
 */
@WebListener
public class EcouteurServeurWeb implements ServletContextListener
{
	GestionServeur gestionServeur;

    /**
     * Default constructor. 
     */
    public EcouteurServeurWeb()
    {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)
    { 
    	if(sce.getServletContext().getServletContextName().compareTo("X18A")==0)
    	{
    		System.out.println("Arrêt du serveur client lourd");
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
