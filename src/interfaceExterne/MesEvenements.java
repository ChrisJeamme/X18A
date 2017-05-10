package interfaceExterne;

import java.util.ArrayList;

import donnees.Evenement;

public class MesEvenements {
		ArrayList<Evenement> listeEvent;
		public MesEvenements(){
			listeEvent = new ArrayList<>();
		}

		public ArrayList<Evenement> chargerEvenements(){
			//Sortir les infos de la base
			Evenement e1 = new Evenement();
			e1.setNomEvenement("Evenement1");
			e1.setBudget(100);
			Evenement e2 = new Evenement();
			e2.setNomEvenement("Evenement2");
			e2.setBudget(20);
			Evenement e3 = new Evenement();
			e3.setNomEvenement("Evenement3");
			e3.setBudget(450);
			listeEvent.add(e1);
			listeEvent.add(e2);
			listeEvent.add(e3);
			return listeEvent;
		}
}