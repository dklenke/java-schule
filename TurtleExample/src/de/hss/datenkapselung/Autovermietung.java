package de.hss.datenkapselung;

public class Autovermietung {
	private String kundennummer;
	private int ausgelieheneTage;
	private int fahrzeugtarif;
	
	public Autovermietung(String kundennummer, int ausgelieheneTage, int fahrzeugtarife) {
		this.setKundendaten(kundennummer, ausgelieheneTage, fahrzeugtarife);
	}
	
	public double rechnung() {
		int t = this.getFahrzeugtarif();
		int tarif = t == 1 ? 25 : t == 2 ? 30 : 40;
		return tarif * this.ausgelieheneTage;
	}
	
	@Override
	public String toString() {
		return "Kundennummer: " + this.kundennummer + ", ausgeliehene Tage: " + this.ausgelieheneTage + ", Fahrzeugtarif: "
				+ this.fahrzeugtarif + ", Rechnungsbetrag: " + this.rechnung();
	}
	
	public void setKundendaten(String kundennummer, int ausgelieheneTage, int fahrzeugtarif) {
		this.setKundennummer(kundennummer);
		this.setAusgelieheneTage(ausgelieheneTage);
		this.setFahrzeugtarif(fahrzeugtarif);
	}
	public String getKundennummer() {
		return kundennummer;
	}
	public void setKundennummer(String kundennummer) {
		this.kundennummer = kundennummer;
	}
	public int getAusgelieheneTage() {
		return ausgelieheneTage;
	}
	public void setAusgelieheneTage(int ausgelieheneTage) {
		this.ausgelieheneTage = Math.abs(ausgelieheneTage);
	}
	public int getFahrzeugtarif() {
		return fahrzeugtarif;
	}
	public void setFahrzeugtarif(int fahrzeugtarif) {
		if (fahrzeugtarif==1 || fahrzeugtarif==2) {
			this.fahrzeugtarif = fahrzeugtarif;
		}
		else {
			this.fahrzeugtarif = 3;
		}
	}
}
