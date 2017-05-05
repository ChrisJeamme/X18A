package donnees;

public class Evenement 
{
	private int id;
	private String nomEvenement;
	private int budget;
	
	public Evenement()
	{}
	
	public Evenement(int id, String nomEvenement, int budget)
	{
		this.id = id;
		this.nomEvenement = nomEvenement;
		this.budget = budget;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getNomEvenement() 
	{
		return nomEvenement;
	}

	public void setNomEvenement(String nomEvement)
	{
		this.nomEvenement = nomEvement;
	}

	public int getBudget() 
	{
		return budget;
	}

	public void setBudget(int budget) 
	{
		this.budget = budget;
	}

	@Override
	public String toString()
	{
		return "Evenement [id=" + id + ", nomEvenement=" + nomEvenement + ", budget=" + budget + "]";
	}
}
