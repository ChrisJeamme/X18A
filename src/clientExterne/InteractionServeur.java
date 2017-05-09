package clientExterne;

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
    	String recu = client.envoyerMessage("<a><b></b></a>");
    	client.fermetureConnexion();
    	
    	return recu;
	}
	
	public boolean ajoutUtilisateur(Utilisateur u)
	{
		//non test� mais montre la gueule des fonctions de ce type
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
		
		//On enl�ve over � la fin de la r�ponse
		reponse = clean(reponse);
		//On r�cup�re l'id de la r�ponse
		int id = Integer.valueOf(reponse);
		
		if(id != -1 && u.getId() == -1) //Si il a bien �t� ajout� et l'utilisateur n'a pas d�j� un id
		{
			u.setId(id);
			return true;
		}
		else
			return false;
	}

	public static String clean(String reception)
	{
		//On supprime "over" � la fin
		return reception.substring(0, reception.length()-4);
	}
}
