package donnees;

/**
 * Données de l'objet Utilisateur
 *
 */
public class Utilisateur 
{
	private int id = -1;
	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	private String motDePasse;
	
	/**
	 * Constructeur vide
	 */
	public Utilisateur()
	{}
	
	/**
	 * Constructeur avec les paramètres prédéfinis
	 * @param nom String
	 * @param prenom String
	 * @param email String
	 * @param pseudo String
	 * @param mdp String
	 */
	public Utilisateur(String nom, String prenom, String email, String pseudo, String mdp)
	{
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pseudo = pseudo;
		this.motDePasse = mdp;
	}

	/**
	 * Retourne l'id
	 * @return int : L'id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Change l'id
	 * @param id int
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Retourne le nom
	 * @return String : Le nom
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Change le nom
	 * @param nom String
	 */
	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	/**
	 * Retourne le prenom
	 * @return String
	 */
	public String getPrenom()
	{
		return prenom;
	}

	/**
	 * Change le prenom
	 * @param prenom String
	 */
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}

	/**
	 * Retourne l'adresse mail
	 * @return String : L'adresse mail
	 */
	public String getEmail() 
	{
		return email;
	}

	/**
	 * Change l'adresse mail
	 * @param email String
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Retourne le pseudo
	 * @return String : Le pseudo
	 */
	public String getPseudo() 
	{
		return pseudo;
	}

	/**
	 * Change le pseudo
	 * @param pseudo String
	 */
	public void setPseudo(String pseudo)
	{
		this.pseudo = pseudo;
	}

	/**
	 * Retourne le mot de passe
	 * @return String : Le mot de passe
	 */
	public String getMotDePasse()
	{
		return motDePasse;
	}	
	
	/**
	 * Change le mot de passe
	 * @param mdp String
	 */
	public void setMotDePasse(String mdp)
	{
		motDePasse = mdp;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pseudo="
				+ pseudo + " (Mot de passe pas affiché)]";
	}
}
