package donnees;

public class Utilisateur 
{
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	private String motDePasse;
	
	public Utilisateur()
	{}
	
	public Utilisateur(int id, String nom, String prenom, String email, String pseudo, String mdp)
	{
		this();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pseudo = pseudo;
		this.motDePasse = mdp;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPseudo() 
	{
		return pseudo;
	}

	public void setPseudo(String pseudo)
	{
		this.pseudo = pseudo;
	}

	public String getMotDePasse()
	{
		return motDePasse;
	}	
	
	public void setMotDePasse(String mdp)
	{
		motDePasse = mdp;
	}	
	
	@Override
	public String toString()
	{
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pseudo="
				+ pseudo + " (Mot de passe pas affiché)]";
	}
}
