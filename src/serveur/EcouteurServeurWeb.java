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
    	System.out.println(sce.getServletContext());
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)
    { 
    	System.out.println(sce.getServletContext());
    	
//		int port = 18458;
//		gestionServeur = new GestionServeur(port);
//		gestionServeur.start();
    }
	
}
