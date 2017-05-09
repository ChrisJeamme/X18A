package donnees;

public class Participe
{
	private int idUtilisateur;
	private int idEvenement;
	
	public Participe()
	{}
	
	public Participe(int user, int event)
	{
		this();
		this.idUtilisateur = user;
		this.idEvenement = event;
	}

	public int getIdUtilisateur() 
	{
		return idUtilisateur;
	}

	public void setIdUtilisateur(int user) 
	{
		this.idUtilisateur = user;
	}
public int getIdEvenement() 
	{
		return idEvenement;
	}

	public void setIdEvenement(int event)
	{
		this.idEvenement = event;
	}

	@Override
	public String toString()
	{
		return "Participe [idUtilisateur=" + idUtilisateur + ",  idEvenement="
				+ idEvenement + "]";
	}
}
