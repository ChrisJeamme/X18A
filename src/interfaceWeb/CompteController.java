package interfaceWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import donnees.Utilisateur;

/**
 * Servlet implementation class CompteController
 */
@WebServlet("/compte")
public class CompteController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteController() 
    {
        super();
        // TODO Auto-generated constructor stub
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
		
		//On envoit les donn�es � la vue compte
		request.setAttribute("utilisateur", u);
		getServletContext().getRequestDispatcher("/compte.jsp").forward(request, response);
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
