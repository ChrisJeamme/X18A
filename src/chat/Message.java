package chat;

public class Message
{
	String texte;
	java.sql.Date date;
	String auteur;
	int idUtilisateur;
	int idEvenement;

	public Message()
	{}
	
	public Message(String texte, java.sql.Date date, String auteur)
	{
		this();
		this.texte = texte;
		this.date = date;
		this.auteur = auteur;
	}
	
	public String getTexte()
	{
		return texte;
	}

	public java.sql.Date getDate()
	{
		return date;
	}

	public String getAuteur()
	{
		return auteur;
	}

	public void setTexte(String message)
	{
		this.texte = message;
	}

	public void setDate()
	{
		date = new java.sql.Date(new java.util.Date().getTime());
	}
	
	public void setDate(String date)
	{
		this.date = java.sql.Date.valueOf(date);
	}
	
	public void setDate(java.sql.Date date)
	{
		this.date = date;
	}

	public void setAuteur(String auteur)
	{
		this.auteur = auteur;
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
		return "Message [texte=" + texte + ", date=" + date + ", auteur=" + auteur + ", idUtilisateur=" + idUtilisateur
				+ ", idEvenement=" + idEvenement + "]";
	}
}
