package de.hss.abstrakt;

public class Doppelzimmer extends Mietobjekt {
	private boolean halbpension;
	public Doppelzimmer(int anzahlPersonen, int anzahlTage, boolean halbpension) {
		super(anzahlPersonen, anzahlTage);
		this.halbpension = halbpension;
	}
	public double getRechnung() {
		double grundpreis = (this.getAnzahlPersonen() * 40.0) * this.getAnzahlTage();
		if (this.halbpension) {
			return grundpreis + 18.0;
		}
		return grundpreis;
	}
}
