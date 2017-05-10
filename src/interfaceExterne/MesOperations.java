package interfaceExterne;

import java.util.ArrayList;

import donnees.Depense;

public class MesOperations {
	ArrayList<Depense> listeOperations;
	public MesOperations(){
		listeOperations = new ArrayList<>();
	}

	public ArrayList<Depense> chargerOperations(){
		//Sortir les infos de la base
		Depense d1 = new Depense();
		d1.setDescription("Operation n°1");
		d1.setMontant(20);
		d1.setDate("01/02/2016");
		Depense d2 = new Depense();
		d2.setDescription("Operation n°2");
		d2.setMontant(2);
		d2.setDate("14/04/1900");
		Depense d3 = new Depense();
		d3.setDescription("Operation n°3");
		d3.setMontant(120);
		d3.setDate("19/12/2006");
		
		listeOperations.add(d1);
		listeOperations.add(d2);
		listeOperations.add(d3);
		return listeOperations;
	}
}