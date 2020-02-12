package de.hss.abstrakt;

public class Arbeiter extends Mitarbeiter{
	private double stundenlohn;
	private int stunden;
	public Arbeiter(String id, String name, int kinderzahl, double stundenlohn, int stunden) {
		super(id, name, kinderzahl);
		this.stundenlohn = stundenlohn > 12.5 ? Math.min(stundenlohn, 32.0) : 12.5;
		this.stunden = stunden > 0 ? Math.min(stunden, 220) : 0;
	}
	public String berechneMonatslohn() {
		return "---- Arbeiter -----------\nID: " + this.id + "\nName: " + this.name + "\nKinderanzahl: " + 
				this.kinderanzahl + "\nStundenlohn: " + this.stundenlohn + "€\nStunden: " + this.stunden + 
				"\nMonatslohn: " + (this.stunden * this.stundenlohn) + "€\n-------------------------";
	}
}
