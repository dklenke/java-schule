package de.hss.uebungen2;

public class Mitarbeiter {
	private String mitarbeiterNr;
	private double gehalt;
	
	public Mitarbeiter(String mitarbeiterNr, double gehalt) {
		this.mitarbeiterNr = mitarbeiterNr;
		this.setGehalt(gehalt);
	}
	
	public String getMitarbeiterNr() {
		return mitarbeiterNr;
	}
	public void setMitarbeiterNr(String mitarbeiterNr) {
		this.mitarbeiterNr = mitarbeiterNr;
	}
	public double getGehalt() {
		return gehalt;
	}
	public void setGehalt(double gehalt) {
		if (gehalt > 10000.0) {
			this.gehalt = 10000.0;
		}
		else if (gehalt < 1500.0){
			this.gehalt = 1500.0;
		}
		this.gehalt = gehalt;
	}

	@Override
	public String toString() {
		return "Mitarbeiter [mitarbeiterNr=" + mitarbeiterNr + ", gehalt=" + gehalt + "]";
	}
}
