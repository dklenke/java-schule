package de.hss.abstrakt;

import java.util.ArrayList;

public class Mitarbeiterliste {
	private String firma;
	private ArrayList<Mitarbeiter> a1_mitarbeiter = new ArrayList<Mitarbeiter>();
	
	public Mitarbeiterliste(String firma) {
		super();
		this.firma = firma;
	}
	
	public void einstellen(Mitarbeiter mitarbeiter) {
		a1_mitarbeiter.add(mitarbeiter);
	}
	
	public String entlassen(String mitarbeiter) {
		for(Mitarbeiter m : a1_mitarbeiter) {
			if (mitarbeiter.equals(m.id)) {
				a1_mitarbeiter.remove(m);
				return "Mitarbeiter mit ID: " + mitarbeiter + " wurde entlassen";
			}
		}
		return "Kein Mitarbeiter mit ID: " + mitarbeiter + " vorhanden";
	}
}
