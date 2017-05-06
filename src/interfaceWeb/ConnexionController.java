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
		// TODO Auto-generated method stu
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String pseudo = (String) request.getParameter("pseudo");
		String motDePasse = (String) request.getParameter("pass");
		System.out.println(pseudo + "   " + motDePasse);
		BDD db = new BDD();
		ArrayList<Evenement> evenement = InteractionBDD.recupEvenementsDeUtilisateur(db, 1);
		String redirection;
		Utilisateur u = InteractionBDD.verificationConnexion(db, pseudo, motDePasse);
		if (u != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("pseudo", pseudo);
			redirection = "/accueilConnecte.jsp";
		}
		else 
		{
			request.setAttribute("erreur", "Utilisateur inconnu ou mot de passe incorrect.");
			redirection = "/connexion.jsp";
		}
		db.disconnect();
		getServletContext().getRequestDispatcher(redirection).forward(request, response);
		
	}

}
