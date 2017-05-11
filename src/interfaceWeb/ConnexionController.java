package interfaceWeb;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.BDD;
import bdd.InteractionBDD;
import donnees.Evenement;
import donnees.Utilisateur;

/**
 * Servlet implementation class ConnexionController
 */
@WebServlet("/connexion")
public class ConnexionController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//On r�cup�re la session
		HttpSession session = request.getSession();
		
		if (session.getAttribute("utilisateur") != null)
		{
			//Si d�j� connect�, on envoie sur l'accueil connect�
			getServletContext().getRequestDispatcher("/AccueilConnecte").forward(request, response);
		}
		else
		{
			//On envoie sur le formulaire de connexion
			getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//On a r�cup�r� le formulaire de connexion
		String pseudo = (String) request.getParameter("pseudo");
		String motDePasse = (String) request.getParameter("pass");
		//Connexion � la base de donn�es
		BDD db = new BDD();

		String redirection;
		String message;
		
		//On r�cup�re l'utilisateur avec ce pseudo et ce mot de passe
		Utilisateur u = InteractionBDD.verificationConnexion(db, pseudo, motDePasse);
		if (u != null) //L'utilisateur existe et s'est correctement authentifi�
		{
			//On fixe la session et on envoie sur l'accueil connect�
			HttpSession session = request.getSession();
			message = "Bonjour"; 
			session.setAttribute("utilisateur", u);
			redirection = "/AccueilConnecte";
		}
		else 
		{
			//On evnvoie sur le formulaire de connexion avec un message d'erreur
			message = "Utilisateur inconnu ou mot de passe incorrect.";
			redirection = "/connexion.jsp";
		}
		db.disconnect();//deconnexion de la bdd
		
		//Redirection
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(redirection).forward(request, response);
		
	}

}
