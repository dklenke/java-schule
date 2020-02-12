package de.hss.abstrakt;

public class Ferienwohnung extends Mietobjekt{
	private boolean endreinigung;
	public Ferienwohnung(int anzahlPersonen, int anzahlTage, boolean endreinigung) {
		super(anzahlPersonen, anzahlTage);
		this.endreinigung = endreinigung;
	}
	public double getRechnung() {
		int tarifProTag = this.getAnzahlPersonen() <= 5 ? 120 : 205;
		if (endreinigung) {
			return tarifProTag * this.getAnzahlTage();
		}
		return tarifProTag * this.getAnzahlTage() + 50;
	}
}
