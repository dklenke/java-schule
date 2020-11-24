package ruhl.klassenarbeit1;

public class Ferienwohnung extends Mietobjekt {
	private boolean endreinigung;
	
	public Ferienwohnung (String buchungsCode, int anzahlPersonen, int anzahlTage, boolean endreinigung) {
		super(buchungsCode, anzahlPersonen, anzahlTage);
		this.endreinigung = endreinigung;
	}

	@Override
	public String getRechnung() {
		int tagespreis = this.getAnzahlPersonen() <= 5 ? 120 : 205;
		int preis = tagespreis * this.getAnzahlPersonen() * this.getAnzahlTage();
		preis += this.endreinigung ? 0 : 50;
		return "Rechnungsbetrag: " + preis;
	}
}
