package serveur;

import donnees.Chat;
import donnees.Depense;
import donnees.Evenement;
import donnees.Message;
import donnees.Utilisateur;

public class InteractionAvecClient
{
	public static void envoyerUtilisateur(Serveur serveur, Utilisateur u)
	{
		//non testé mais montre la gueule des fonctions de ce type
		String xml =   	"<?xml version='1.0' encoding='UTF-8'?>"
					+   "<!DOCTYPE utilisateur SYSTEM 'utilisateur.dtd'>"
					+	"<utilisateur>"
					+		"<id>"+u.getId()+"</id>"
					+		"<nom>"+u.getNom()+"</nom>"
					+		"<prenom>"+u.getPrenom()+"</prenom>"
					+		"<email>"+u.getEmail()+"</email>"
					+		"<pseudo>"+u.getPseudo()+"</pseudo>"
					+		"<motDePasse>"+u.getMotDePasse()+"</motDePasse>"
					+	"</utilisateur>;";
		
		xml = xml.concat("\nover");
		
		serveur.envoyer(xml);
	}

	public static void envoyerDepense(Serveur serveur, Depense d)
	{
		String xml =   	"<?xml version=\"1.0\" encoding=\"UTF-8_\"?>"
					+	"<!DOCTYPE chat SYSTEM \"depense.dtd\">"
					+	"<depense idUtilisateur=\""+d.getIdUtilisateur()+"\" idEvenement=\""+d.getIdEvenement()+"\">"
					+	"	<date>"+d.getDate()+"</date>"
					+	"	<montant>"+d.getMontant()+"</montant>"
					+	"	<description>"+d.getDescription()+"</description>"
					+	"</depense>";
		
		xml = xml.concat("\nover");
		
		serveur.envoyer(xml);
	}

	public static void envoyerEvenement(Serveur serveur, Evenement e)
	{
		String xml =   	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE evenement SYSTEM \"evenement.dtd\">"
					+	"<evenement>"
					+		"<id>"+e.getId()+"</id>"
					+	    "<nom>"+e.getNomEvenement()+"</nom>"
					+		"<budget>"+e.getBudget()+"</budget>"
					+	"</evenement>";
		
		xml = xml.concat("\nover");
		
		serveur.envoyer(xml);
	}

	public static void envoyerChat(Serveur serveur, Chat c)
	{
		ser
	}
}
