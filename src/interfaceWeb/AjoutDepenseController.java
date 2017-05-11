package interfaceWeb;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		//On r�cup�re la session en cours
		HttpSession session = request.getSession();
		//On v�rifie que l'utilisateur est bien connect�
		if (session.getAttribute("utilisateur") == null)
		{
			//il n'y a pas d'utilisateur connect�, on renvoit vers la page d'accueuil du site
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
		//On r�cup�re le formulaire d'ajout de d�pense 
		String description = (String) request.getParameter("description");
		
		//On r�cup�re la session
		HttpSession session = request.getSession();
		//On r�cup�re l'evenement qui se trouve dans une variable de session
		Evenement event = (Evenement) session.getAttribute("evenement");
		//On se connecte � la bdd
		BDD db = new BDD();
		//On r�cup�re l'utilisateur de la session en cours
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		//On r�cup�re la date
		String date = InteractionBDD.date(); 
		
		try
		{
			//On r�cup�re le montant de la d�pense ajout�e par l'utilisateur
			int montant = Integer.parseInt((String) request.getParameter("montant"));
			//On met � jour la base de donn�e
			InteractionBDD.ajoutDepense(db, u.getId(), event.getId(), date, montant, description);
		}
		catch (Exception e)
		{
			//Le montant n'est pas valide, on renvoie sur la m�me page avec un message d'erreur
			request.setAttribute("erreurMontant", "Veuillez rentrer un montant valide");
		}

		//On renvoie sur la m�me page
		getServletContext().getRequestDispatcher("/evenement?ev="+event.getId()).forward(request, response);
	}

}
