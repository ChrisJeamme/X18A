package interfaceWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
		HttpSession session = request.getSession();
		if (session.getAttribute("utilisateur") == null)
		{
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		int id=0;
		try 
		{
			String idEvent = request.getParameter("ev");
			id = Integer.parseInt(idEvent);
		}
		catch (Exception e)
		{
			getServletContext().getRequestDispatcher("/AccueilConnecte").forward(request, response);
			return;
		}
		BDD db = new BDD();
		Evenement event = InteractionBDD.recupEvenementsAvecID(db, id);
		session.setAttribute("evenement", event);
		
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		
		if(! InteractionBDD.utilisateurParticpeAEvenement(db, u.getId(), event.getId()))
		{
			getServletContext().getRequestDispatcher("/AccueilConnecte").forward(request, response);
			return;
		}
		
		ArrayList<Utilisateur> listeUtilisateursEv = InteractionBDD.recupUtilisateursDeEvenement(db, event.getId()); 
		ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<>();
		for (int i=0; i<listeUtilisateursEv.size(); i++)
		{
			if (listeUtilisateursEv.get(i).getId() != u.getId())
			{
				listeUtilisateurs.add(listeUtilisateursEv.get(i));
			}
		}
		
		
		ArrayList<Depense> listeDepenses = InteractionBDD.recupDepensesDeEvenement(db, event.getId());
		Map<Depense, Utilisateur> depenses = new LinkedHashMap<>();
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
