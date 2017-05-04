package donnees;

public class Evenement 
{
	private int id;
	private String nomEvement;
	private int budget;
	
	public Evenement(int id, String nomEvenement, int budget)
	{
		this.id = id;
		this.nomEvement = nomEvenement;
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

	public String getNomEvement() 
	{
		return nomEvement;
	}

	public void setNomEvement(String nomEvement)
	{
		this.nomEvement = nomEvement;
	}

	public int getBudget() 
	{
		return budget;
	}

	public void setBudget(int budget) 
	{
		this.budget = budget;
	}
	
	
}
