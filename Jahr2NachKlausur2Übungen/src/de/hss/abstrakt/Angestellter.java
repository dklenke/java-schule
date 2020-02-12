package de.hss.abstrakt;

public class Angestellter extends Mitarbeiter {
	private double monatsgehalt;
	public Angestellter(String id, String name, int kinderanzahl, double monatsgehalt) {
		super(id, name, kinderanzahl);
		this.monatsgehalt = monatsgehalt > 2000.0 ? Math.min(monatsgehalt, 10000.0) : 2000.0;
	}
	public String berechneMonatslohn() {
		return "--- Angestellter --------\nID: " + this.id + "\nName: " + this.name + "\nKinderanzahl: " + 
				this.kinderanzahl + "\nMonatslohn: " + this.monatsgehalt + "€\n-------------------------";
	}
}
