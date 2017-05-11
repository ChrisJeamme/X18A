package donnees;

import java.util.ArrayList;

/**
 * Donn�es de l'objet ParticipeMultipleUtilisateur
 *
 */
public class ParticipeMultipleUtilisateur
{
	ArrayList<Evenement> evenements;
	int DernierElement;
	int idUtilisateur;
	int nombreEvenements;

	/**
	 * Constructeur sans param�tres
	 */
	public ParticipeMultipleUtilisateur()
	{
		evenements = new ArrayList<Evenement>();
		DernierElement = -1;
	}
	
	/**
	 * Constructeur avec l'id pr�d�fini
	 * @param id int
	 */
	public ParticipeMultipleUtilisateur(int id)
	{
		this();
		this.idUtilisateur = id;
	}

	/**
	 * Retourne l'id
	 * @return int : L'id
	 */
	public int getId()
	{
		return idUtilisateur;
	}

	/**
	 * Change l'id
	 * @param id int
	 */
	public void setId(int id)
	{
		this.idUtilisateur = id;
	}

	/**
	 * Retourne le num�ro du dernier �l�ment de la liste
	 * @return int : Le num�ro du dernier �l�ment de la liste
	 */
	public int getDernierElementNum()
	{
		return DernierElement;
	}
	
	/**
	 * Retourne le dernier �l�ment de la liste
	 * @return Evenement : Le dernier �l�ment de la liste
	 */
	public Evenement getDernierElementObj()
	{
		return evenements.get(DernierElement);
	}
	
	/**
	 * Change le dernier �l�ment de la liste
	 * @param e Evenement
	 */
	public void setDernierElementObj(Evenement e)
	{
		evenements.set(DernierElement, e);
	}
	
	/**
	 * Cr�e un nouvel objet Evenement dans la liste
	 */
	public void nouvelEvenement()
	{
		DernierElement++;
		setDernierElementObj(new Evenement());
	}
	
	/**
	 * Change le nombre d'evenements
	 * @param nb int
	 */
	public void setNombreEvenements(int nb)
	{
		nombreEvenements=nb;
	}
	
	/**
	 * Retorune le nombre d'evenements
	 * @return int : Le nombe d'evenements
	 */
	public int getNombreEvenements()
	{
		return nombreEvenements;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ParticipeMultipleUtilisateur [idUtilisateur=" + idUtilisateur + ", evenements=" + evenements + "]";
	}

}
