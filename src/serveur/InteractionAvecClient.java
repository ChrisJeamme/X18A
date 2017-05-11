package serveur;

import java.util.ArrayList;

import donnees.Chat;
import donnees.Depense;
import donnees.Evenement;
import donnees.Message;
import donnees.Utilisateur;

/**
 * Gère les interactions entre le client et le serveur
 *
 */
public class InteractionAvecClient
{
	/**
	 * Envoie l'utilisateur u au client (Crée le XML)
	 * @param serveur Serveur
	 * @param u Utilisateur
	 */
	public static void envoyerUtilisateur(Serveur serveur, Utilisateur u)
	{
		String xml =   	"<?xml version='1.0' encoding='UTF-8'?>"
					+   "<!DOCTYPE utilisateur SYSTEM 'xml\\utilisateur.dtd'>"
					+	"<utilisateur>"
					+		"<id>"+u.getId()+"</id>"
					+		"<nom>"+u.getNom()+"</nom>"
					+		"<prenom>"+u.getPrenom()+"</prenom>"
					+		"<email>"+u.getEmail()+"</email>"
					+		"<pseudo>"+u.getPseudo()+"</pseudo>"
					+		"<motDePasse>"+u.getMotDePasse()+"</motDePasse>"
					+	"</utilisateur>";
		
		serveur.envoyer(xml);
	}

	/**
	 * Envoie la dépense d au client (Crée le XML)
	 * @param serveur Serveur
	 * @param d Depense
	 */
	public static void envoyerDepense(Serveur serveur, Depense d)
	{
		String xml =   	"<?xml version=\"1.0\" encoding=\"UTF-8_\"?>"
					+	"<!DOCTYPE chat SYSTEM \"depense.dtd\">"
					+	"<depense idUtilisateur=\""+d.getIdUtilisateur()+"\" idEvenement=\""+d.getIdEvenement()+"\">"
					+	"	<date>'"+d.getDate()+"'</date>"
					+	"	<montant>'"+d.getMontant()+"'</montant>"
					+	"	<description>'"+d.getDescription()+"'</description>"
					+	"</depense>";
		
		xml = xml.concat("\nover");
		
		serveur.envoyer(xml);
	}

	/**
	 * Envoie l'évenement e au client (Crée le XML)
	 * @param serveur Serveur
	 * @param e Evenement
	 */
	public static void envoyerEvenement(Serveur serveur, Evenement e)
	{
		String xml =   	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE evenement SYSTEM \"evenement.dtd\">"
					+	"<evenement>"
					+		"<id>'"+e.getId()+"'</id>"
					+	    "<nom>'"+e.getNomEvenement()+"'</nom>"
					+		"<budget>'"+e.getBudget()+"'</budget>"
					+	"</evenement>";
		
		xml = xml.concat("\nover");
		
		serveur.envoyer(xml);
	}

	/**
	 * Envoie le chat c au client (Crée le XML)
	 * @param serveur Serveur
	 * @param c Chat
	 */
	public static void envoyerChat(Serveur serveur, Chat c)
	{
		String xml = 	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE chat SYSTEM \"chat.dtd\">"
					+	"<chat evenementId=\"1\">";
		
		ArrayList<Message> messages = c.getMessages();
		
		for(int i=0; i<messages.size(); i++)
		{
			xml.concat( "    <message idUtilisateur=\""+messages.get(i).getIdUtilisateur()+"\" idEvenement=\""+messages.get(i).getIdEvenement()+"\">"
					+	"    <date>"+messages.get(i).getDate()+"</date>"
					+	"    <auteur></auteur>"
					+	"    <auteurId>"+messages.get(i).getIdUtilisateur()+"</auteurId>"
					+	"    <texte>"+messages.get(i).getTexte()+"</texte>"
					+	"    </message>");
				
		}
		
		xml.concat("</chat>");
		
		serveur.envoyer(xml);
	}
}
