package clientExterne;

import donnees.Depense;
import donnees.Evenement;
import donnees.Participe;
import donnees.Utilisateur;
import xml.ParserXML;

/**
 * Contient toutes les interactions entre le client externe et le serveur
 *
 */
public class InteractionServeur
{
	Client client;
		
	/**
	 * Constructeur qui initialise la connexion
	 */
	public InteractionServeur()
	{
		client = new Client();
		client.etablirConnexion();
	}
	
	/**
	 * Envoie un texte au serveur
	 * @param texte String
	 * @return String : La réponse
	 */
	public String envoiServeur(String texte)
	{
    	String recu = client.envoyerMessage(texte);
    	
    	return recu;
	}
	
	/**
	 *  Génère un XML d'ajout d'utilisateur et l'envoi au serveur
	 * @param u Utilisateur
	 * @return boolean : Ajout avec succès ou non
	 */
	public boolean ajoutUtilisateur(Utilisateur u)
	{
		//non testé mais montre la gueule des fonctions de ce type
		String xml =   	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+   "<!DOCTYPE utilisateur SYSTEM \"xml\\utilisateur.dtd\">"
					+	"<utilisateur>"
					+		"<id></id>"
					+		"<nom>"+u.getNom()+"</nom>"
					+		"<prenom>"+u.getPrenom()+"</prenom>"
					+		"<email>"+u.getEmail()+"</email>"
					+		"<pseudo>"+u.getPseudo()+"</pseudo>"
					+		"<motDePasse>"+u.getMotDePasse()+"</motDePasse>"
					+	"</utilisateur>";
		
		String reponse = envoiServeur(xml);
		
		//On enlève over à la fin de la réponse
		//reponse = clean(reponse);
		
		//On récupère l'id de la réponse
		int id = Integer.parseInt(reponse);
		
		if(id != -1 && u.getId() == -1) //Si il a bien été ajouté et l'utilisateur n'a pas déjà un id
		{
			u.setId(id);	//On entre l'id dans l'objet
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Envoie un XML de demande d'utilisateur
	 * @param idUtilisateur int
	 * @return Utilisateur : L'utilisateur demandé
	 */
	public Utilisateur recevoirUtilisateur(int idUtilisateur)
	{
		String xml =	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE demande SYSTEM \"xml\\demande_objet.dtd\">"
					+	"<demande>"
					+	"	<type>utilisateur</type>"
					+	"	<id>idUtilisateur</id>"
					+	"</demande>";
		
		String reponse = envoiServeur(xml);
		
		Utilisateur utilisateur = ParserXML.lireUtilisateur(reponse);
		
		
		
		return utilisateur;
	}
	
	/**
	 * Envoie un XML de connexion
	 * @param pseudo String
	 * @param mdp String
	 * @return Utilisateur : L'utilisateur correspondant
	 */
	public Utilisateur connexion(String pseudo, String mdp)
	{
		String xml =	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE connexion SYSTEM \"xml\\connexion.dtd\">"
					+	"<connexion>"
					+	"	<pseudo>"+pseudo+"</pseudo>"
					+	"	<pass>"+mdp+"</pass>"
					+	"</connexion>";
		
		String reponse = envoiServeur(xml);
		
		Utilisateur utilisateur = ParserXML.lireUtilisateur(reponse);
		
		return utilisateur;
	}	

	
	/**
	 *  Demande un objet Depense avec ses ids primaires
	 * @param idEvenement int
	 * @param idUtilisateur int
	 * @param date String
	 * @return Depense : La depense demandée
	 */
	public Depense recevoirDepense(int idUtilisateur, int idEvenement, String date)
	{
		//Crée un XML de demande basé sur un des 3 demande_objet.xml et le remplit avec les 3 arguments
		String xml = 	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE demande SYSTEM \"xml\\demande_objet.dtd\">"
					+	"<demande>"
					+	"	 <type>evenement</type>"
					+	"	 <couple_id_date>"
					+	"		 <id_couple>"+idUtilisateur+"</id_couple>" //J'espère que c'est le bon ordre !
					+	"		 <id_couple>"+idEvenement+"</id_couple>"
					+	"		 <date>"+date+"</date>"
					+	"	 </couple_id_date>"
					+	"</demande>";
		
		//Receptionne l'objet reçu en réponse
		
		String reponse = envoiServeur(xml);
		
		Depense depense = ParserXML.lireDepense(reponse);
		
		return depense;
	}
	
	/**
	 * Envoie un XML de demande d'evenement
	 * @param idEvenement int
	 * @return Evenement : L'evenement demandé
	 */
	public Evenement recevoirEvenement(int idEvenement)
	{
		String xml =	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE demande SYSTEM \"xml\\demande_objet.dtd\">"
					+	"<demande>"
					+	"	<type>evenement</type>"
					+	"	<id>idEvenement</id>"
					+	"</demande>";
		
		String reponse = envoiServeur(xml);
		
		Evenement evenement = ParserXML.lireEvenement(reponse);
		
		return evenement;
	}
	
	/**
	 * Envoie un XML de demande de participe
	 * @param idUtilisateur int
	 * @param idEvenement int
	 * @return Participe : Le participe demandé
	 */
	public Participe recevoirParticipe(int idUtilisateur, int idEvenement)
	{
		String xml =	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE demande SYSTEM \"xml\\demande_objet.dtd\">"
					+	"<demande>"
					+	"	<type>participe</type>"
					+	"	<couple_id>"
					+	"		<id_couple>"+idUtilisateur+"</id_couple>" // Sur le meme modèle que recevoir depense
					+	"		<id_couple>"+idEvenement+"</id_couple>"
					+	"	</couple_id>"
					+	"</demande>";
		
		String reponse = envoiServeur(xml);
		
		Participe participe = ParserXML.lireParticipe(reponse);
		
		return participe;
	}

	/**
	 * Envoie un XML d'ajout de depense
	 * @param d Depense
	 * @return boolean : Ajout avec succès ou non
	 */
	public boolean ajoutDepense(Depense d)
	{
		//non testé mais montre la gueule des fonctions de ce type
		String xml =   	"<?xml version='1.0' encoding='UTF-8'?>"
					+   "<!DOCTYPE depense SYSTEM 'xml\\depense.dtd'>"
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
	
	/**
	 * Envoie un XML d'ajout d'evenement
	 * @param e Evenement
	 * @return boolean : Ajout avec succès ou non
	 */
	public boolean ajoutEvenement(Evenement e)
	{
		//non testé mais montre la gueule des fonctions de ce type
		String xml =   	"<?xml version='1.0' encoding='UTF-8'?>"
					+   "<!DOCTYPE evenement SYSTEM 'xml\\evenement.dtd'>"
					+	"<evenement>"
					+		"<id>-1</id>"
					+		"<nom>"+e.getNomEvenement()+"</nom>"
					+		"<budget>"+e.getBudget()+"</budget>"
					+	"</evenement>";
		
		String reponse = envoiServeur(xml);
		
		//On enlève over à la fin de la réponse
		reponse = clean(reponse);
		
		//On récupère l'évenement avec l'ID remplit
		int id = ParserXML.lireEvenement(reponse).getId();
		
		if(id != -1 && e.getId() == -1) //Si il a bien été ajouté
		{
			e.setId(id);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Envoie un XML d'ajout de participe
	 * @param p Participe
	 * @return boolean : Ajout avec succès ou non
	 */
	public boolean ajoutParticipe(Participe p)
	{
		//non testé mais montre la gueule des fonctions de ce type
		String xml =   	"<?xml version='1.0' encoding='UTF-8'?>"
					+   "<!DOCTYPE participe SYSTEM 'xml\\participe.dtd'>"
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
	
	
	/**
	 * Supprime le "over" à la fin du message
	 * @param reception String
	 * @return String : Le message nettoyé
	 */
	public static String clean(String reception)
	{
		if(reception.length()>4)
			return reception.substring(0, reception.length()-4);
		else
			return reception;
	}
}
