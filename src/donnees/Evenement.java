package donnees;

/**
 * Données de l'objet Evenement
 *
 */
public class Evenement 
{
	private int id = -1;
	private String nomEvenement;
	private int budget;
	
	/**
	 * Constructeur vide
	 */
	public Evenement()
	{}
	
	/**
	 * Constructeur avec les paramètres prédéfinis
	 * @param nomEvenement String
	 * @param budget int
	 */
	public Evenement(String nomEvenement, int budget)
	{
		this();
		this.nomEvenement = nomEvenement;
		this.budget = budget;
	}
	
	/**
	 * Constructeur avec les paramètres et l'id prédéfinis
	 * @param id int
	 * @param nomEvenement String
	 * @param budget int
	 */
	public Evenement(int id, String nomEvenement, int budget)
	{
		this();
		this.id = id;
		this.nomEvenement = nomEvenement;
		this.budget = budget;
	}

	/**
	 * Retourne l'id
	 * @return int : L'id
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * Change l'id
	 * @param id int
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * Retourne le nomEvenement
	 * @return String : Le nomEvenement
	 */
	public String getNomEvenement() 
	{
		return nomEvenement;
	}

	/**
	 * Change le nomEvenement
	 * @param nomEvenement String
	 */
	public void setNomEvenement(String nomEvenement)
	{
		this.nomEvenement = nomEvenement;
	}

	/**
	 * Retourne le budget
	 * @return int : Le budget
	 */
	public int getBudget() 
	{
		return budget;
	}

	/**
	 * Change le budget
	 * @param budget int
	 */
	public void setBudget(int budget) 
	{
		this.budget = budget;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Evenement [id=" + id + ", nomEvenement=" + nomEvenement + ", budget=" + budget + "]";
	}
}
