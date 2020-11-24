package ruhl.klassenarbeit1;

public abstract class Mietobjekt {
	private String buchungsCode;
	private int anzahlPersonen;
	private int anzahlTage;
	
	public Mietobjekt(String buchungsCode, int anzahlPersonen, int anzahlTage) {
		this.buchungsCode = buchungsCode;
		this.anzahlPersonen = anzahlPersonen;
		this.anzahlTage = anzahlTage;
	}
	
	public String getBuchungsCode() {
		return buchungsCode;
	}

	public int getAnzahlPersonen() {
		return anzahlPersonen;
	}

	public int getAnzahlTage() {
		return anzahlTage;
	}

	public void setBuchungsCode(String buchungsCode) {
		this.buchungsCode = buchungsCode;
	}

	public void setAnzahlPersonen(int anzahlPersonen) {
		this.anzahlPersonen = anzahlPersonen;
	}

	public void setAnzahlTage(int anzahlTage) {
		this.anzahlTage = anzahlTage;
	}

	public abstract String getRechnung();
}
