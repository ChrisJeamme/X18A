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
 * Servlet implementation class AjoutParticipanController
 */
@WebServlet("/ajoutParticipant")
public class AjoutParticipanController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutParticipanController()
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
		String pseudo = (String) request.getParameter("nom");
		
		HttpSession session = request.getSession();
		Evenement event = (Evenement) session.getAttribute("evenement");
		BDD db = new BDD();
		
		Utilisateur newU = InteractionBDD.recupUtilisateurAvecPseudo(db, pseudo);
		if (newU != null)
		{
			if (! InteractionBDD.utilisateurParticpeAEvenement(db, newU.getId(), event.getId()) ) //S'il n'y participe pas
			{
				InteractionBDD.ajoutParticipe(db, newU.getId(), event.getId()); //On ajoute l'utilisateur a l'événement
			}
			else 
			{	
				request.setAttribute("utilisateurParticipe", "Cet utilisateur participe déjà à cet événement.");
			}
		}
		else 
		{
			request.setAttribute("erreur", "Cet utilisateur n'existe pas.");
		}
		
		
		
//		ArrayList<Utilisateur> listeUtilisateurs = InteractionBDD.recupUtilisateursDeEvenement(db, event.getId()); 
//		ArrayList<Depense> listeDepenses = InteractionBDD.recupDepensesDeEvenement(db, event.getId());
//		Map<Depense, Utilisateur> depenses = new HashMap<>();
//		for (int i=0; i<listeDepenses.size(); i++)
//		{
//			depenses.put(listeDepenses.get(i), InteractionBDD.recupUtilisateurAvecID(db, listeDepenses.get(i).getIdUtilisateur()));
//		}
//		request.setAttribute("utilisateurs", listeUtilisateurs);
//		request.setAttribute("depenses", depenses);
		db.disconnect();
		getServletContext().getRequestDispatcher("/evenement?ev="+event.getId()).forward(request, response);
	}

}
