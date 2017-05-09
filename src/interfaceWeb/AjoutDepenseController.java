package interfaceWeb;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class AjoutParticipanController
 */
@WebServlet("/ajoutDepense")
public class AjoutDepenseController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutDepenseController()
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String description = (String) request.getParameter("description");
		
		HttpSession session = request.getSession();
		Evenement event = (Evenement) session.getAttribute("evenement");
		BDD db = new BDD();
		
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		String date = InteractionBDD.date(); 
		
		try
		{
			int montant = Integer.parseInt((String) request.getParameter("montant"));
			InteractionBDD.ajoutDepense(db, u.getId(), event.getId(), date, montant, description);
		}
		catch (Exception e)
		{
			request.setAttribute("erreurMontant", "Veuillez rentrer un montant valide");
		}
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

}
