package xml;

/**
 * Contient les opérations sur l'objet Demande
 *
 */
public class Demande
{
	private ObjetDemande type;
	private int id;
	private int id2;
	private String date;
	
	/**
	 * Retourne la date
	 * @return String : La date
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
	 * Retourne le type
	 * @return ObjetDemande : Le type
	 */
	public ObjetDemande getType()
	{
		return type;
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
	 * Retourne l'id2
	 * @return int : L'id2
	 */
	public int getId2()
	{
		return id2;
	}
	
	/**
	 * Change le type
	 * @param type ObjetDemande
	 */
	public void setType(ObjetDemande type)
	{
		this.type = type;
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
	 * Change l'id2
	 * @param id2 int
	 */
	public void setId2(int id2)
	{
		this.id2 = id2;
	}
}
