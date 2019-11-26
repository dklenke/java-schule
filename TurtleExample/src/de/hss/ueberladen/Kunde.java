package de.hss.ueberladen;

public class Kunde {
	private String kdnr = "----";
	private String name = "----";
	private double betrag = 0.0;
	
	public Kunde(String name, String kdnr) {
		this.kdnr = kdnr;
		this.name = name;
	}
	
	public Kunde(String name, String kdnr, double betrag) {
		this.kdnr = kdnr;
		this.name = name;
		this.betrag = betrag;
	}
	
	public Kunde(String name, double betrag) {
		this.betrag = betrag;
		this.name = name;
	}	
	public void einkaufen(double wert) {
		this.betrag += wert;
	}
	
	public String bezahlen() {
		double betr = this.betrag;
		this.betrag = 0.0;
		return "Name: " + this.name + "\nKundennummer: " + this.kdnr + "\nRechnungsbetrag: " + betr;
	}

}
