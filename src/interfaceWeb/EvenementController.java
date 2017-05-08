package interfaceWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.BDD;
import bdd.InteractionBDD;
import donnees.Depense;
import donnees.Evenement;
import donnees.Utilisateur;

/**
 * Servlet implementation class EvenementController
 */
@WebServlet("/evenement")
public class EvenementController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EvenementController()
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
		String idEvent = request.getParameter("ev");
		int id = Integer.parseInt(idEvent);
		
		BDD db = new BDD();
		Evenement event = InteractionBDD.recupEvenementsAvecID(db, id);
		HttpSession session = request.getSession();
		session.setAttribute("evenement", event);
		
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");

		ArrayList<Utilisateur> listeUtilisateurs = InteractionBDD.recupUtilisateursDeEvenement(db, event.getId()); 
		ArrayList<Depense> listeDepenses = InteractionBDD.recupDepensesDeEvenement(db, event.getId());
		Map<Depense, Utilisateur> depenses = new HashMap<>();
		for (int i=0; i<listeDepenses.size(); i++)
		{
			depenses.put(listeDepenses.get(i), InteractionBDD.recupUtilisateurAvecID(db, listeDepenses.get(i).getIdUtilisateur()));
		}
		request.setAttribute("utilisateurs", listeUtilisateurs);
		request.setAttribute("depenses", depenses);
		db.disconnect();
		getServletContext().getRequestDispatcher("/evenement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
