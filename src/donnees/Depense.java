package donnees;

/**
 * Données de l'objet Depense
 *
 */
public class Depense 
{
	private int idUtilisateur;
	private String date;                   //java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
	private int montant;
	private int idEvent; 
	private String description;
	
	/**
	 * Constructeur vide
	 */
	public Depense()
	{}
	
	/**
	 * Constructeur avec tous les éléments prédéfinis
	 * @param user int
	 * @param event int
	 * @param montant int
	 * @param date String
	 * @param description String
	 */
	public Depense(int user, int event, int montant, String date, String description)
	{
		this();
		this.idUtilisateur = user;
		this.idEvent = event;
		this.montant = montant;
		this.date = date;
		this.description = description;
	}

	/**
	 * Retourne l'idUtilisateur
	 * @return int : idUtilisateur
	 */
	public int getIdUtilisateur() 
	{
		return idUtilisateur;
	}

	/**
	 * Change l'idUtilisateur
	 * @param user int
	 */
	public void setIdUtilisateur(int user) 
	{
		this.idUtilisateur = user;
	}

	/**
	 * Retourne la date
	 * @return String : La dates
	 */
	public String getDate() 
	{
		return date;
	}

	/**
	 * Change la date
	 * @param date String
	 */
	public void setDate(String date)
	{
		this.date = date;
	}

	/**
	 * Retourne le montant
	 * @return int : Le montant
	 */
	public int getMontant()
	{
		return montant;
	}

	/**
	 * Change le montant
	 * @param montant int
	 */
	public void setMontant(int montant)
	{
		this.montant = montant;
	}

	/**
	 * Retorune l'idEvenement
	 * @return int : L'idEvenement
	 */
	public int getIdEvenement() 
	{
		return idEvent;
	}

	/**
	 * Change l'idEvenement
	 * @param event int
	 */
	public void setIdEvenement(int event)
	{
		this.idEvent = event;
	}

	/**
	 * Retourne la description
	 * @return String : La description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Change la description
	 * @param description String
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Depense [idUtilisateur=" + idUtilisateur + ", date=" + date + ", montant=" + montant + ", idEvent="
				+ idEvent + "]";
	}
}
