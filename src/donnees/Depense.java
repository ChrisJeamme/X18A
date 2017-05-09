package donnees;

public class Depense 
{
	private int idUtilisateur;
	private String date;                   //java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
	private int montant;
	private int idEvent; 
	private String description;
	
	public Depense()
	{}
	
	public Depense(int user, int event, int montant, String date, String description)
	{
		this();
		this.idUtilisateur = user;
		this.idEvent = event;
		this.montant = montant;
		this.date = date;
		this.description = description;
	}

	public int getIdUtilisateur() 
	{
		return idUtilisateur;
	}

	public void setIdUtilisateur(int user) 
	{
		this.idUtilisateur = Integer.valueOf(user);
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public int getMontant()
	{
		return montant;
	}

	public void setMontant(int montant)
	{
		this.montant = montant;
	}

	public int getIdEvenement() 
	{
		return idEvent;
	}

	public void setIdEvenement(int event)
	{
		this.idEvent = Integer.valueOf(event);
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public String toString()
	{
		return "Depense [idUtilisateur=" + idUtilisateur + ", date=" + date + ", montant=" + montant + ", idEvent="
				+ idEvent + "]";
	}
}
