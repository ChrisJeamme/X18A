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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String nomEvenement = (String) request.getParameter("nom");
		BDD db = new BDD();
		
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		
		int idEvent = InteractionBDD.ajoutEvenement(db, nomEvenement, 0);
		Evenement e = InteractionBDD.recupEvenementsAvecID(db, idEvent);
		InteractionBDD.ajoutParticipe(db, u.getId(), idEvent);
		session.setAttribute("evenement", e);
		
		request.setAttribute("evenement", e);
		db.disconnect();
		getServletContext().getRequestDispatcher("/evenement.jsp").forward(request, response);
	}

}
