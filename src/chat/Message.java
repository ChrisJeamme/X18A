package xml;

public class Message
{
	String texte;
	String date;
	String auteur;
	int id;

	public Message()
	{
		
	}
	
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

	public int getId()
	{
		return id;
	}

	public void setId(String string)
	{
		this.id = Integer.valueOf(string);
	}

	@Override
	public String toString()
	{
		return "Message [texte=" + texte + ", date=" + date + ", auteur=" + auteur + ", id=" + id + "]";
	}
}
