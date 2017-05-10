package clientExterne;

import donnees.Depense;
import donnees.Utilisateur;
import xml.ParserXML;

public class InteractionServeur
{
	Client client;
	public static InteractionServeur currentInteractionServeur = new InteractionServeur(); // Objet statique qui se partage entre toutes les pages
	
	public InteractionServeur()
	{
		client = new Client();
		client.etablirConnexion();
	}
	
	public String envoiServeur(String texte)
	{
		
    	String recu = client.envoyerMessage(texte);
    	
    	
    	return recu;
	}
	
	/**
	 *  G�n�re un XML d'ajout d'utilisateur et l'envoi au serveur
	 * @param u
	 * @return
	 */
	public boolean ajoutUtilisateur(Utilisateur u)
	{
		//non test� mais montre la gueule des fonctions de ce type
		String xml =   	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+   "<!DOCTYPE utilisateur SYSTEM \"xml\\utilisateur.dtd\">"
					+	"<utilisateur>"
					+		"<id></id>"
					+		"<nom>"+u.getNom()+"</nom>"
					+		"<prenom>"+u.getPrenom()+"</prenom>"
					+		"<email>"+u.getEmail()+"</email>"
					+		"<pseudo>"+u.getPseudo()+"</pseudo>"
					+		"<motDePasse>"+u.getMotDePasse()+"</motDePasse>"
					+	"</utilisateur>\nover";
		
		String reponse = envoiServeur(xml);
		
		//On enl�ve over � la fin de la r�ponse
		//reponse = clean(reponse);
		
		//On r�cup�re l'id de la r�ponse
		int id = Integer.parseInt(reponse);
		
		if(id != -1 && u.getId() == -1) //Si il a bien �t� ajout� et l'utilisateur n'a pas d�j� un id
		{
			u.setId(id);	//On entre l'id dans l'objet
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  Demande un objet Depense avec ses ids primaires
	 * @param idEvenement
	 * @param idUtilisateur
	 * @param date
	 * @return
	 */
	public Depense recevoirDepense(int idUtilisateur, int idEvenement, String date)
	{
		//Cr�e un XML de demande bas� sur un des 3 demande_objet.xml et le remplit avec les 3 arguments
		String xml = 	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE demande SYSTEM \"xml\\demande_objet.dtd\">"
					+	"<demande>"
					+	"	 <type>evenement</type>"
					+	"	 <couple_id_date>"
					+	"		 <id_couple>"+idUtilisateur+"</id_couple>" //J'esp�re que c'est le bon ordre !
					+	"		 <id_couple>"+idEvenement+"</id_couple>"
					+	"		 <date>"+date+"</date>"
					+	"	 </couple_id_date>"
					+	"</demande>";
		
		//Receptionne l'objet re�u en r�ponse
		
		String reponse = envoiServeur(xml);
		
		Depense depense = ParserXML.lireDepense(reponse);
		
		return depense;
	}

	public static String clean(String reception)
	{
		//On supprime "over" � la fin
		if(reception.length()>4)
			return reception.substring(0, reception.length()-4);
		else
			return reception;
	}
}
