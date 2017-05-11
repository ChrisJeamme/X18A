package donnees;

/**
 * Données de l'objet Participe
 *
 */
public class Participe
{
	private int idUtilisateur;
	private int idEvenement;
	
	/**
	 * Constructeur vide
	 */
	public Participe()
	{}
	
	/**
	 * Constructeur avec les paramètres prédéfinis
	 * @param user int
	 * @param event int
	 */
	public Participe(int user, int event)
	{
		this();
		this.idUtilisateur = user;
		this.idEvenement = event;
	}

	/**
	 * Retourne l'idUtilisateur
	 * @return int : L'idUtilisateur
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
	 * Retourne l'idEvenement
	 * @return int : L'idEvenement
	 */
	public int getIdEvenement() 
	{
		return idEvenement;
	}

	/**
	 * Change l'idEvenement
	 * @param event int
	 */
	public void setIdEvenement(int event)
	{
		this.idEvenement = event;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Participe [idUtilisateur=" + idUtilisateur + ",  idEvenement="
				+ idEvenement + "]";
	}
}
