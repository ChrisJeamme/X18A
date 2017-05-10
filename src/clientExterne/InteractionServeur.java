package clientExterne;

import donnees.Depense;
import donnees.Evenement;
import donnees.Participe;
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
	 *  Génère un XML d'ajout d'utilisateur et l'envoi au serveur
	 * @param u
	 * @return
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
					+	"</utilisateur>\nover";
		
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
	
	public void ajoutDepense(Depense d)
	{
		String xml =	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE depense SYSTEM \"xml\\depense.dtd\">"
					+	"<depense idUtilisateur=\""+d.getIdUtilisateur()+"\" idEvenement=\""+d.getIdEvenement()+"\">"
					+	"	<date>"+d.getDate()+"</date>"
					+	"	<montant>"+d.getMontant()+"</montant>"
					+	"	<description>"+d.getDescription()+"</description>"
					+	"</depense>\nover";
		
		String reponse = envoiServeur(xml);
		
		// Faut il faire quelque chose après comme on utilise pas d'id propre ?

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
	
	public boolean ajoutEvenement(Evenement e)
	{
		String xml =	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTYPE evenement SYSTEM \"xml\\evenement.dtd\">"
					+	"<evenement>"
					+	"	<id></id>"
					+	"	<nom>"+e.getNomEvenement()+"</nom>"
					+	"	<budget>"+e.getBudget()+"</budget"
					+	"</evenement>\nover";
		
		String reponse = envoiServeur(xml);
		
		//On récupère l'id de la réponse
		int id = Integer.parseInt(reponse);
		
		if(id != -1 && e.getId() == -1) //Si il a bien été ajouté et l'utilisateur n'a pas déjà un id
		{
			e.setId(id);	//On entre l'id dans l'objet
			return true;
		}
		else
			return false;
	}
	
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
	
	public void ajoutParticipe(Participe p)
	{
		String xml =	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+	"<!DOCTTYPE participe SYSTEM \"xml\\participe.dtd\">"
					+	"<participe idEvenement=\""+p.getIdEvenement()+"\" idUtilisateur=\""+p.getIdUtilisateur()+"\"></participe>\nover";
		
		String reponse = envoiServeur(xml);
		
		// Faut il faire quelque chose après comme on utilise pas d'id propre ?
					
	}
	
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
		if(reception.length()>4)
			return reception.substring(0, reception.length()-4);
		else
			return reception;
	}
}
