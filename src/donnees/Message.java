package donnees;

public class Message
{
	String texte;
	String date;
	int idUtilisateur;
	int idEvenement;

	public Message()
	{}
	
	public Message(String texte, String date, int idUtilisateur, int idEvenement)
	{
		this();
		this.texte = texte;
		this.date = date;
		this.idUtilisateur = idUtilisateur;
		this.idEvenement = idEvenement;
	}
	
	public String getTexte()
	{
		return texte;
	}

	public String getDate()
	{
		return date;
	}

	public void setTexte(String message)
	{
		this.texte = message;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}

	public int getIdUtilisateur()
	{
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur)
	{
		this.idUtilisateur = Integer.valueOf(idUtilisateur);
	}

	public int getIdEvenement()
	{
		return idEvenement;
	}

	public void setIdUtilisateur(int idUtilisateur)
	{
		this.idUtilisateur = idUtilisateur;
	}

	public void setIdEvenement(String idEvenement)
	{
		this.idEvenement = Integer.valueOf(idEvenement);
	}
	
	public void setIdEvenement(int idEvenement)
	{
		this.idEvenement = idEvenement;
	}

	@Override
	public String toString()
	{
		return "Message [texte=" + texte + ", date=" + date + ", idUtilisateur=" + idUtilisateur + ", idEvenement="
				+ idEvenement + "]";
	}
}
