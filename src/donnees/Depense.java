package donnees;

import java.util.Date;

public class Depense 
{
	private Utilisateur user;
	private Date date;
	private int montant;
	private Evenement event; 
	
	
	public Depense(Utilisateur user, Evenement event, int montant) //On cr�e la d�pense
	{
		this.user = user;
		this.event = event;
		this.montant = montant;
		this.date = new Date();
	}
	
	public Depense(Utilisateur user, Evenement event, int montant, Date date) //on r�cup�re une d�pense existante
	{
		this.user = user;
		this.event = event;
		this.montant = montant;
		this.date = date;
	}

	public Utilisateur getUser() 
	{
		return user;
	}

	public void setUser(Utilisateur user) 
	{
		this.user = user;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date)
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

	public Evenement getEvent() 
	{
		return event;
	}

	public void setEvent(Evenement event)
	{
		this.event = event;
	}
	
	
}
