package clientExterne;

import donnees.Depense;
import donnees.Evenement;
import donnees.Participe;
import donnees.Utilisateur;

public class InteractionServeur
{
	Client client;
	
	public InteractionServeur()
	{
		client = new Client();
	}
	
	public String envoiServeur(String texte)
	{
		client.etablirConnexion();
    	String recu = client.envoyerMessage(texte);
    	client.fermetureConnexion();
    	
    	return recu;
	}
	
	public boolean ajoutUtilisateur(Utilisateur u)
	{
		//non testé mais montre la gueule des fonctions de ce type
		String xml =   	"<?xml version='1.0' encoding='UTF-8'?>"
					+   "<!DOCTYPE utilisateur SYSTEM 'utilisateur.dtd'>"
					+	"<utilisateur>"
					+		"<id></id>"
					+		"<nom>"+u.getNom()+"</nom>"
					+		"<prenom>"+u.getPrenom()+"</prenom>"
					+		"<email>"+u.getEmail()+"</email>"
					+		"<pseudo>"+u.getPseudo()+"</pseudo>"
					+		"<motDePasse>"+u.getMotDePasse()+"</motDePasse>"
					+	"</utilisateur>;";
		
		String reponse = envoiServeur(xml);
		
		//On enlève over à la fin de la réponse
		reponse = clean(reponse);
		//On récupère l'id de la réponse
		int id = Integer.parseInt(reponse);
		
		if(id != -1 && u.getId() == -1) //Si il a bien été ajouté et l'utilisateur n'a pas déjà un id
		{
			u.setId(id);
			return true;
		}
		else
			return false;
	}

	public boolean ajoutDepense(Depense d)
	{
		//non testé mais montre la gueule des fonctions de ce type
		String xml =   	"<?xml version='1.0' encoding='UTF-8'?>"
					+   "<!DOCTYPE depense SYSTEM 'depense.dtd'>"
					+	"<depense>"
					+		"<idUtilisateur>"+d.getIdUtilisateur()+"</idUtilisateur>"
					+		"<idEvenement>"+d.getIdEvenement()+"</idEvenement>"
					+		"<montant>"+d.getMontant()+"</montant>"
					+		"<description>"+d.getDescription()+"</description>"
					+		"<date>"+d.getDate()+"</date>"
					+	"</depense>;";
		
		String reponse = envoiServeur(xml);
		
		//On enlève over à la fin de la réponse
		reponse = clean(reponse);
		
		if(reponse.compareTo("ok") == 0) //Si il a bien été ajouté et l'utilisateur n'a pas déjà un id
		{
			return true;
		}
		else
			return false;
	}
	
	
	public boolean ajoutEvenement(Evenement e)
	{
		//non testé mais montre la gueule des fonctions de ce type
		String xml =   	"<?xml version='1.0' encoding='UTF-8'?>"
					+   "<!DOCTYPE evenement SYSTEM 'evenement.dtd'>"
					+	"<evenement>"
					+		"<id></id>"
					+		"<nomEvenement>"+e.getNomEvenement()+"</nomEvenement>"
					+		"<prenom>"+e.getBudget()+"</prenom>"
					+	"</evenement>;";
		
		String reponse = envoiServeur(xml);
		
		//On enlève over à la fin de la réponse
		reponse = clean(reponse);
		//On récupère l'id de la réponse
		int id = Integer.parseInt(reponse);
		
		if(id != -1 && e.getId() == -1) //Si il a bien été ajouté
		{
			e.setId(id);
			return true;
		}
		else
			return false;
	}
	
	public boolean ajoutParticipe(Participe p)
	{
		//non testé mais montre la gueule des fonctions de ce type
		String xml =   	"<?xml version='1.0' encoding='UTF-8'?>"
					+   "<!DOCTYPE participe SYSTEM 'participe.dtd'>"
					+	"<participe>"
					+		"<idUtilisateur>"+p.getIdUtilisateur()+"</idUtilisateur>"
					+		"<idEvenement>"+p.getIdEvenement()+"</idEvenement>"
					+	"</participe>;";
		
		String reponse = envoiServeur(xml);
		
		//On enlève over à la fin de la réponse
		reponse = clean(reponse);
		
		if(reponse.compareTo("ok") == 0) //Si il a bien été ajouté et l'utilisateur n'a pas déjà un id
		{
			return true;
		}
		else
			return false;
	}
	
	
	public static String clean(String reception)
	{
		//On supprime "over" à la fin
		return reception.substring(0, reception.length()-4);
	}
}
