package donnees;

import java.util.ArrayList;

public class DepenseUtilisateur
{
	ArrayList<Depense> depense;
	int DernierElement;
	int idUtilisateur;
	int nombreDepense;

	public DepenseUtilisateur()
	{
		depense = new ArrayList<Depense>();
		DernierElement = -1;
	}
	
	public DepenseUtilisateur(int id)
	{
		this();
		this.idUtilisateur = id;
	}

	public int getIdUtilisateur()
	{
		return idUtilisateur;
	}

	public void setIdUtilisateur(int id)
	{
		this.idUtilisateur = id;
	}

	public int getDernierElementNum()
	{
		return DernierElement;
	}
	
	public Depense getDernierElementObj()
	{
		return depense.get(DernierElement);
	}
	
	public void setDernierElementObj(Depense d)
	{
		depense.set(DernierElement, d);
	}
	
	public String getDernierElementDate() // Je ne sais pas si ces trois suivants sont vraiments utiles mais bon
	{
		return getDernierElementObj().getDate();
	}
	
	public int getDernierElementMontant()
	{
		return getDernierElementObj().getMontant();
	}
	
	public String getDernierElementDescription()
	{
		return getDernierElementObj().getDescription();
	}
	
	public void nouvelleDepense()
	{
		DernierElement++;
		setDernierElementObj(new Depense());
	}
	
	public void setNombreDepense(int nb)
	{
		nombreDepense=nb;
	}
	
	public int getNombreDepense()
	{
		return nombreDepense;
	}
	
	public String getDate(int numero) 
	{
		return depense.get(numero).getDate();
	}

	public void setDate(int numero, String date)
	{
		depense.get(numero).setDate(date);
	}

	public int getMontant(int numero)
	{
		return depense.get(numero).getMontant();
	}

	public void setMontant(int numero, int montant)
	{
		depense.get(numero).setMontant(montant);
	}
	
	public String getDescription(int numero)
	{
		return depense.get(numero).getDescription();
	}

	public void setDescription(int numero, String description)
	{
		depense.get(numero).setDescription(description);
	}

	@Override
	public String toString()
	{
		return "DepenseUtilisateur [idUtilisateur=" + idUtilisateur + ", depense=" + depense + "]";
	}

}
