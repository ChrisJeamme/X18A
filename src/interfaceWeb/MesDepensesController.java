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
 * Servlet implementation class mesDepensesController
 */
@WebServlet("/mesDepenses")
public class MesDepensesController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MesDepensesController()
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
		
		//On récupère l'utilisateur
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		
		//On instancie la base de données
		BDD db = new BDD();
		//On récupère les dépenses de l'utilisateur dans une liste de Depense
		ArrayList<Depense> listeDepenses = InteractionBDD.recupDepensesDeUtilisateur(db, u.getId());
		
		/*On va associé chaque dépense à l'événement auquel il se rapporte. On utilise une table de hachage (depense => evenement)
		 *On utilise une LinkedHashMap qui permet de garder l'ordre (car on récupère les dépense triées par date*/
		Map<Depense, Evenement> depenses = new LinkedHashMap<>();
		for (int i=0; i<listeDepenses.size(); i++)
		{
			depenses.put(listeDepenses.get(i), InteractionBDD.recupEvenementsAvecID(db, listeDepenses.get(i).getIdEvenement()));
		}
		
		//Deconnexion de la base de données
		db.disconnect();
		
		//On transmet les données à la vue mesDepense
		request.setAttribute("utilisateur", u);
		request.setAttribute("depenses", depenses);
		getServletContext().getRequestDispatcher("/mesDepenses.jsp").forward(request, response);
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
