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
		//On r�cup�re le formulaire d'ajout d'un participant
		String pseudo = (String) request.getParameter("nom");
		
		//On r�cup�re la session courante
		HttpSession session = request.getSession();
		//On r�cup�re l'�v�nement
		Evenement event = (Evenement) session.getAttribute("evenement");
		BDD db = new BDD(); //On se connecte � la bdd
		
		//On r�cup�re l'utilisateur avec le pseudo (il y en a un seul)
		Utilisateur newU = InteractionBDD.recupUtilisateurAvecPseudo(db, pseudo);
		if (newU != null) 
		{
			//On a trouv� un utilisateur avec ce pseudo
			if (! InteractionBDD.utilisateurParticpeAEvenement(db, newU.getId(), event.getId()) )
			{
				//Cet utilisateur ne particpe pas d�j� � l'�v�nement, on l'ajoute
				InteractionBDD.ajoutParticipe(db, newU.getId(), event.getId()); //On ajoute l'utilisateur a l'�v�nement
			}
			else 
			{	
				//Il participe d�ja, on le signale avec un message
				request.setAttribute("utilisateurParticipe", "Cet utilisateur participe d�j� � cet �v�nement.");
			}
		}
		else 
		{
			//L'utilisateur n'existe pas, on le signale
			request.setAttribute("erreur", "Cet utilisateur n'existe pas.");
		}
		
		db.disconnect();//D�connexion de la base de donn�e 
		//On renvoie sur le controleur de l'evenement qui va se charger de fournir ce que la vue va afficher
		getServletContext().getRequestDispatcher("/evenement?ev="+event.getId()).forward(request, response);
	}

}
