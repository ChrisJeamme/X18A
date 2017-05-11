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
		//On récupère la session en cours
		HttpSession session = request.getSession();
		//On vérifie que l'utilisateur est bien connecté
		if (session.getAttribute("utilisateur") == null)
		{
			//il n'y a pas d'utilisateur connecté, on renvoit vers la page d'accueuil du site
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return; //on n'execute pas la suite du code
		}
		
		int id=0;
		try 
		{
			//On récupère l'identifiant de l'événement sur lequel on est
			String idEvent = request.getParameter("ev");
			id = Integer.parseInt(idEvent);
		}
		catch (Exception e)
		{
			//l'identifiant n'est pas un entier, on renvoie sur l'accueil
			getServletContext().getRequestDispatcher("/AccueilConnecte").forward(request, response);
			return;
		}
		//Connexion à la bdd
		BDD db = new BDD();
		
		//On récupère l'événement
		Evenement event = InteractionBDD.recupEvenementsAvecID(db, id);
		//On le met dans la session
		session.setAttribute("evenement", event);
		
		//On récupère l'utilisateur
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		
		if(! InteractionBDD.utilisateurParticpeAEvenement(db, u.getId(), event.getId()))
		{
			//L'utilisateur n'est pas autorisé à participer à cet événement ou il n'existe pas
			getServletContext().getRequestDispatcher("/AccueilConnecte").forward(request, response);
			return;
		}
		
		//On récupère les utilisateurs de l'événement
		ArrayList<Utilisateur> listeUtilisateursEv = InteractionBDD.recupUtilisateursDeEvenement(db, event.getId()); 
		//On crée une liste qui ne contiendra pas l'utilisateur pour ne pas l'afficher
		ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<>();
		for (int i=0; i<listeUtilisateursEv.size(); i++)
		{
			if (listeUtilisateursEv.get(i).getId() != u.getId())
			{
				listeUtilisateurs.add(listeUtilisateursEv.get(i));
			}
		}
		
		//On récupère toutes les dépenses de l'événement
		ArrayList<Depense> listeDepenses = InteractionBDD.recupDepensesDeEvenement(db, event.getId());
		
		//On associe chaque dépense à l'utilsateur qui l'a effectuée
		//On utilise une LinkedHashMap qui permet de garder l'ordre (car on récupère les dépense triées par date
		Map<Depense, Utilisateur> depenses = new LinkedHashMap<>();
		for (int i=0; i<listeDepenses.size(); i++)
		{
			depenses.put(listeDepenses.get(i), InteractionBDD.recupUtilisateurAvecID(db, listeDepenses.get(i).getIdUtilisateur()));
		}
		

		db.disconnect(); //Deconnexion
		//On transmet les données 
		request.setAttribute("evenement", event);
		request.setAttribute("utilisateurs", listeUtilisateurs);
		request.setAttribute("depenses", depenses);
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
