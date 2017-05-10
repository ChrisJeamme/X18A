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
		HttpSession session = request.getSession();
		if (session.getAttribute("utilisateur") == null)
		{
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String pseudo = (String) request.getParameter("pseudo");
		String motDePasse = (String) request.getParameter("pass");
		BDD db = new BDD();

		String redirection;
		String message;
		Utilisateur u = InteractionBDD.verificationConnexion(db, pseudo, motDePasse);
		if (u != null) //L'utilisateur existe et s'est correctement authentifié
		{
			HttpSession session = request.getSession();
			message = "Bonjour"; 
			session.setAttribute("utilisateur", u);
			redirection = "/AccueilConnecte";
		}
		else 
		{
			message = "Utilisateur inconnu ou mot de passe incorrect.";
			redirection = "/connexion.jsp";
		}
		db.disconnect();
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(redirection).forward(request, response);
		
	}

}
