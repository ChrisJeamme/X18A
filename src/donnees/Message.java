package donnees;

/**
 * Données de l'objet Message
 *
 */
public class Message
{
	String texte;
	String date;
	int idUtilisateur;
	int idEvenement;

	/**
	 * Constructeur vide
	 */
	public Message()
	{}
	
	/**
	 * Constructeur avec les paramètres prédéfinis
	 * @param texte String
	 * @param date String
	 * @param idUtilisateur int
	 * @param idEvenement int
	 */
	public Message(String texte, String date, int idUtilisateur, int idEvenement)
	{
		this();
		this.texte = texte;
		this.date = date;
		this.idUtilisateur = idUtilisateur;
		this.idEvenement = idEvenement;
	}
	
	/**
	 * Retourne le texte du message
	 * @return String : Le texte du message
	 */
	public String getTexte()
	{
		return texte;
	}

	/**
	 * Retourne la date du message
	 * @return String : La date du message
	 */
	public String getDate()
	{
		return date;
	}

	/**
	 * Change le texte du message
	 * @param message String
	 */
	public void setTexte(String message)
	{
		this.texte = message;
	}
	
	/**
	 * Change la date du message
	 * @param date String
	 */
	public void setDate(String date)
	{
		this.date = date;
	}

	/**
	 * Retourne l'idUtilisateur du message (l'auteur)
	 * @return int : L'idUtilisateur de l'auteur du message
	 */
	public int getIdUtilisateur()
	{
		return idUtilisateur;
	}

	/**
	 * Change l'idUtilisateur avec un String en paramètres
	 * @param idUtilisateur String
	 */
	public void setIdUtilisateur(String idUtilisateur)
	{
		this.idUtilisateur = Integer.valueOf(idUtilisateur);
	}

	/**
	 * Retourne l'idEvenement
	 * @return int : L'idEvenement
	 */
	public int getIdEvenement()
	{
		return idEvenement;
	}

	/**
	 * Change l'idUtilisateur avec un int en paramètres
	 * @param idUtilisateur int
	 */
	public void setIdUtilisateur(int idUtilisateur)
	{
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * Change l'idEvenement avec un String en paramètres
	 * @param idEvenement String
	 */
	public void setIdEvenement(String idEvenement)
	{
		this.idEvenement = Integer.valueOf(idEvenement);
	}
	
	/**
	 * Change l'idEvenement avec un int en paramètres
	 * @param idEvenement int
	 */
	public void setIdEvenement(int idEvenement)
	{
		this.idEvenement = idEvenement;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Message [texte=" + texte + ", date=" + date + ", idUtilisateur=" + idUtilisateur + ", idEvenement="
				+ idEvenement + "]";
	}
}
