package de.hss.abstrakt;

public class Doppelzimmer extends Mietobjekt {
	private boolean halbpension;
	public Doppelzimmer(int anzahlPersonen, int anzahlTage, boolean halbpension) {
		super(anzahlPersonen, anzahlTage);
		this.halbpension = halbpension;
	}
	public double getRechnung() {
		if (this.halbpension) {
			return (this.getAnzahlPersonen() * 40.0) * this.getAnzahlTage() + 18.0;
		}
		return (this.getAnzahlPersonen() * 40.0) * this.getAnzahlTage();
	}
}
