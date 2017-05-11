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
import donnees.Evenement;
import donnees.Utilisateur;


/**
 * Servlet implementation class CreationEvenementController
 */
@WebServlet("/creerEvenement")
public class CreationEvenementController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationEvenementController()
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
		//On récupère la session en cours
		HttpSession session = request.getSession();
		//On vérifie que l'utilisateur est bien connecté
		if (session.getAttribute("utilisateur") == null)
		{
			//il n'y a pas d'utilisateur connecté, on renvoit vers la page d'accueuil du site
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return; //on n'execute pas la suite du code
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//On a récupéré le formulaire de création d'un événement
		String nomEvenement = (String) request.getParameter("nom");
		BDD db = new BDD(); //Connexion à la base de données 
		
		//Récupération de la session
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		
		//On ajoute l'événement dans la base de donnée et on récupère son identifiant
		int idEvent = InteractionBDD.ajoutEvenement(db, nomEvenement, 0);
		Evenement e = InteractionBDD.recupEvenementsAvecID(db, idEvent);
		//On ajoute le créateur de l'événement comme participant
		InteractionBDD.ajoutParticipe(db, u.getId(), idEvent);
		//On met l'événement en variable de session
		session.setAttribute("evenement", e);
		db.disconnect();//Deconnexion de la bdd
		
		//On envoit sur l'événement qu'on vient de créer
		request.setAttribute("evenement", e);
		getServletContext().getRequestDispatcher("/evenement.jsp").forward(request, response);
	}

}
