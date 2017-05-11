package donnees;

import java.util.ArrayList;

/**
 * Donn�es de l'objet DepenseUtilisateur
 *
 */
public class DepenseUtilisateur
{
	ArrayList<Depense> depense;
	int DernierElement;
	int idUtilisateur;
	int nombreDepense;

	/**
	 * Constructeur sans param�tres
	 */
	public DepenseUtilisateur()
	{
		depense = new ArrayList<Depense>();
		DernierElement = -1;
	}
	
	/**
	 * Constructeur avec l'id pr�d�fini
	 * @param id int
	 */
	public DepenseUtilisateur(int id)
	{
		this();
		this.idUtilisateur = id;
	}

	/**
	 * Retourne l'idUtilisateur
	 * @return int : L'idUtilisateur
	 */
	public int getIdUtilisateur()
	{
		return idUtilisateur;
	}

	/**
	 * Change l'idUtilisateur
	 * @param id int
	 */
	public void setIdUtilisateur(int id)
	{
		this.idUtilisateur = id;
	}

	/**
	 * Retourne le num�ro du dernier element de la liste
	 * @return int : Le num�ro du dernier �l�ment de la liste
	 */
	public int getDernierElementNum()
	{
		return DernierElement;
	}
	
	/**
	 * Retourne le dernier �l�ment de la liste
	 * @return Depense : Le dernier �l�ment de la liste
	 */
	public Depense getDernierElementObj()
	{
		return depense.get(DernierElement);
	}
	
	/**
	 * Change le dernier �l�ment de la liste
	 * @param d Depense
	 */
	public void setDernierElementObj(Depense d)
	{
		depense.set(DernierElement, d);
	}
	
	/**
	 * Retourne la date du dernier �l�ment de la liste
	 * @return String : La date du dernier �l�ment de la liste
	 */
	public String getDernierElementDate() // Je ne sais pas si ces trois suivants sont vraiments utiles mais bon
	{
		return getDernierElementObj().getDate();
	}
	
	/**
	 * Retourne le montant du dernier �l�ment de la liste
	 * @return int : Le montant du dernier �l�ment de la liste
	 */
	public int getDernierElementMontant()
	{
		return getDernierElementObj().getMontant();
	}
	
	/**
	 * Retourne la description du dernier �l�ment de la liste
	 * @return String : La description du dernier �l�ment de la liste
	 */
	public String getDernierElementDescription()
	{
		return getDernierElementObj().getDescription();
	}
	
	/**
	 * Cr�e une nouvel objet Depense dans la liste
	 */
	public void nouvelleDepense()
	{
		DernierElement++;
		setDernierElementObj(new Depense());
	}
	
	/**
	 * Change le nombre d'�l�ment Depense
	 * @param nb int
	 */
	public void setNombreDepense(int nb)
	{
		nombreDepense=nb;
	}
	
	/**
	 * Retourne le nombre d'�l�ments Depense
	 * @return
	 */
	public int getNombreDepense()
	{
		return nombreDepense;
	}
	
	/**
	 * Retourne la date de l'�l�ment en position numero
	 * @param numero int
	 * @return String : La date de l'�l�ment en position numero
	 */
	public String getDate(int numero) 
	{
		return depense.get(numero).getDate();
	}

	/**
	 * Change la date de l'�l�ment en position numero
	 * @param numero int
	 * @param date String
	 */
	public void setDate(int numero, String date)
	{
		depense.get(numero).setDate(date);
	}

	/**
	 * Retourne le montant de l'�l�ment en position numero
	 * @param numero int
	 * @return int : Le montant de l'�l�ment en position numero
	 */
	public int getMontant(int numero)
	{
		return depense.get(numero).getMontant();
	}

	/**
	 * Change le montant de l'�l�ment en position numero
	 * @param numero int
	 * @param montant int
	 */
	public void setMontant(int numero, int montant)
	{
		depense.get(numero).setMontant(montant);
	}
	
	/**
	 * Retourne la description de l'�l�ment en position numero
	 * @param numero int
	 * @return String : La description de l'�l�ment en position numero
	 */
	public String getDescription(int numero)
	{
		return depense.get(numero).getDescription();
	}

	/**
	 * Change la description de l'�l�ment en position numero
	 * @param numero int
	 * @param description String
	 */
	public void setDescription(int numero, String description)
	{
		depense.get(numero).setDescription(description);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DepenseUtilisateur [idUtilisateur=" + idUtilisateur + ", depense=" + depense + "]";
	}

}
