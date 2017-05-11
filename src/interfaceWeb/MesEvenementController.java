package interfaceWeb;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class EvenementController
 */
@WebServlet("/mesEvenements")
public class MesEvenementController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MesEvenementController() 
    {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//On r�cup�re la session en cours
		HttpSession session = request.getSession();
		//On v�rifie que l'utilisateur est bien connect�
		if (session.getAttribute("utilisateur") == null)
		{
			//il n'y a pas d'utilisateur connect�, on renvoit vers la page d'accueuil du site
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return; //on n'execute pas la suite du code
		}
		
		//On r�cup�re l'utilisateur
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		
		//On instancie la base de donn�es
		BDD db = new BDD();
		//On r�cup�re les �v�nements auxuqels participe l'utilisateur dans une liste d'Evenement
		ArrayList<Evenement> listeEvenement = InteractionBDD.recupEvenementsDeUtilisateur(db, u.getId());
		//On ferme la base de donn�es
		db.disconnect();
		
		//Envoie des donn�es � la vue mesEvenement
		request.setAttribute("utilisateur", u);
		request.setAttribute("evenements", listeEvenement);
		getServletContext().getRequestDispatcher("/mesEvenements.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
