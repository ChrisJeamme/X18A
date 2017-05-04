package chat;

public class Message
{
	String texte;
	String date;
	String auteur;
	int idUtilisateur;
	int idEvenement;

	public Message()
	{}
	
	public Message(String texte, String date, String auteur)
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

	public String getDate()
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

	public void setDate(String date)
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

	public void setIdUtilisateur(String string)
	{
		this.idUtilisateur = Integer.valueOf(string);
	}

	public int getIdEvenement()
	{
		return idEvenement;
	}

	public void setIdUtilisateur(int idUtilisateur)
	{
		this.idUtilisateur = idUtilisateur;
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
