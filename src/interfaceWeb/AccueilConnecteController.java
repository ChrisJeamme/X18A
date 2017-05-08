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
 * Servlet implementation class AccueilConnecte
 */
@WebServlet("/AccueilConnecte")
public class AccueilConnecteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilConnecteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		BDD db = new BDD();
		ArrayList<Depense> listeDepenses = InteractionBDD.recupDepensesDeUtilisateur(db, u.getId());
		Map<Depense, Evenement> depenses = new HashMap<>();
		for (int i=0; i<listeDepenses.size(); i++)
		{
			depenses.put(listeDepenses.get(i), InteractionBDD.recupEvenementsAvecID(db, listeDepenses.get(i).getIdEvenement()));
		}
		
		db.disconnect();
		request.setAttribute("utilisateur", u);
		request.setAttribute("depenses", depenses);
		getServletContext().getRequestDispatcher("/accueilConnecte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
