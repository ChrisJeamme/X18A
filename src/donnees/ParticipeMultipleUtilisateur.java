package donnees;

import java.util.ArrayList;

public class ParticipeMultipleUtilisateur
{
	ArrayList<Evenement> evenements;
	int DernierElement;
	int idUtilisateur;

	public ParticipeMultipleUtilisateur()
	{
		evenements = new ArrayList<Evenement>();
		DernierElement = -1;
	}
	
	public ParticipeMultipleUtilisateur(int id)
	{
		this();
		this.idUtilisateur = id;
	}

	public int getId()
	{
		return idUtilisateur;
	}

	public void setId(int id)
	{
		this.idUtilisateur = id;
	}

	public int getDernierElementNum()
	{
		return DernierElement;
	}
	
	public Evenement getDernierElementObj()
	{
		return evenements.get(DernierElement);
	}
	
	public void setDernierElementObj(Evenement e)
	{
		evenements.set(DernierElement, e);
	}
	
	public void nouvelEvenement()
	{
		DernierElement++;
		setDernierElementObj(new Evenement());
	}

	@Override
	public String toString()
	{
		return "ParticipeMultipleUtilisateur [idUtilisateur=" + idUtilisateur + ", evenements=" + evenements + "]";
	}

}
