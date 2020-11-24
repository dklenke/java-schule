package ruhl.klassenarbeit1;

public class Doppelzimmer extends Mietobjekt {
	private boolean halbpension;
	
	public Doppelzimmer(String buchungsCode, int anzahlPersonen, int anzahlTage, boolean halbpension) {
		super(buchungsCode, anzahlPersonen, anzahlTage);
		this.halbpension = halbpension;
	}

	@Override
	public String getRechnung() {
		int preis = 40 * this.getAnzahlPersonen() * this.getAnzahlTage();
		if (halbpension) {preis += 18 * this.getAnzahlPersonen() * this.getAnzahlTage();}
		return "Rechnungsbetrag: " + preis;
	}

}
