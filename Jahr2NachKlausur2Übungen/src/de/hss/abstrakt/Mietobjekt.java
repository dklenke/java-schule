package de.hss.abstrakt;

public abstract class Mietobjekt {
	private int anzahlPersonen;
	private int anzahlTage;
	
	public Mietobjekt(int anzahlPersonen, int anzahlTage) {
		this.anzahlPersonen = anzahlPersonen > 1 ? Math.min(anzahlPersonen, 10) : 1;
		this.anzahlTage = anzahlTage;
	}
	
	public int getAnzahlPersonen() {
		return this.anzahlPersonen;
	}
	
	public int getAnzahlTage() {
		return this.anzahlTage;
	}
	
	public abstract double getRechnung();
}
