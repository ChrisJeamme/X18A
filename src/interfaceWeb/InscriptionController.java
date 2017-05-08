package interfaceWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.BDD;
import bdd.InteractionBDD;
import donnees.Utilisateur;

/**
 * Servlet implementation class InscriptionController
 */
@WebServlet("/inscription")
public class InscriptionController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionController()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String pseudo = (String) request.getParameter("pseudo");
		String motDePasse = (String) request.getParameter("pass");
		String email = (String) request.getParameter("email");
		String nom = (String) request.getParameter("nom");
		String prenom = (String) request.getParameter("prenom");
		
		BDD db = new BDD();

		String message;
		String redirection;
		
		if (InteractionBDD.emailExiste(db, email))
		{
			message = "Cet email est déjà utilisé.";
			redirection = "/inscription.jsp";
		}
		else if (InteractionBDD.pseudoExiste(db, pseudo))
		{
			message = "Ce pseudo est déja utilisé, veuillez en choisir un autre.";
			redirection = "/inscription.jsp";
		}
		else
		{
			Utilisateur u = new Utilisateur(nom, prenom, email, pseudo, motDePasse);
			InteractionBDD.ajoutUtilisateur(db, nom, prenom, email, pseudo, motDePasse);
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", u);
			message = "Bienvenue";
			redirection = "/accueilConnecte.jsp";
		}
		db.disconnect();	
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(redirection).forward(request, response);
	}

}
