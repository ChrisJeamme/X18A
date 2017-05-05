package donnees;

public class Depense 
{
	private int idUtilisateur;
	private java.sql.Date date;                   //java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
	private int montant;
	private int idEvent; 
	
	public Depense()
	{}
	
	public Depense(int user, int event, int montant, String date)
	{
		this();
		this.idUtilisateur = user;
		this.idEvent = event;
		this.montant = montant;
		this.date = java.sql.Date.valueOf(date);
	}

	public int getIdUtilisateur() 
	{
		return idUtilisateur;
	}

	public void setIdUtilisateur(int user) 
	{
		this.idUtilisateur = user;
	}

	public java.sql.Date getDate() 
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = java.sql.Date.valueOf(date);
	}
	
	public void setDate(java.sql.Date date)
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
		this.idEvent = event;
	}

	@Override
	public String toString()
	{
		return "Depense [idUtilisateur=" + idUtilisateur + ", date=" + date + ", montant=" + montant + ", idEvent="
				+ idEvent + "]";
	}
}
