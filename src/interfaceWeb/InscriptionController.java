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
		//Si on cherche à acceder à la page via l'URL on renvoie vers inscription.jsp
		HttpSession session = request.getSession();
		if (session.getAttribute("utilisateur") == null)
		{
			getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//On récupère les données du formulaire. Elles sont non vides car vérifiées par javascript
		String pseudo = (String) request.getParameter("pseudo");
		String motDePasse = (String) request.getParameter("pass");
		String email = (String) request.getParameter("email");
		String nom = (String) request.getParameter("nom");
		String prenom = (String) request.getParameter("prenom");
		
		BDD db = new BDD(); //Connexion à la bdd

		String message;
		String redirection;
		
		//Si le mail est déjà dans la bdd, on retourne à l'insciption avec un message d'erreur
		if (InteractionBDD.emailExiste(db, email))
		{
			message = "Cet email est déjà utilisé.";
			redirection = "/inscription.jsp";
		} //Pareil si le pseudo est déja utilisé
		else if (InteractionBDD.pseudoExiste(db, pseudo))
		{
			message = "Ce pseudo est déja utilisé, veuillez en choisir un autre.";
			redirection = "/inscription.jsp";
		}
		else //Création d'un nouvel utilisateur
		{
			Utilisateur u = new Utilisateur(nom, prenom, email, pseudo, motDePasse);
			InteractionBDD.ajoutUtilisateur(db, nom, prenom, email, pseudo, motDePasse);
			HttpSession session = request.getSession(); 
			session.setAttribute("utilisateur", u); //On met l'utilisateur dans la session
			message = "Bienvenue"; //Message de bienvenue
			redirection = "/AccueilConnecte"; //On envoie sur l'accueil connecté
		}
		db.disconnect();
		//On transmet les données où on veut aller
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(redirection).forward(request, response);
	}

}
