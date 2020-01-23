package de.hss.statisch;

public class Rechnung {
	private String kdnr;
	private double netto;
	private static double mwst = 0.19;
	
	public Rechnung (String kdnr, double netto) {
		this.kdnr = kdnr;
		this.netto = netto;
	}

	public static double getMwst() {
		return mwst;
	}

	public static void setMwst(double mwst) {
		Rechnung.mwst = mwst;
	}
	
	public String getRechnung() {
		return "---- Rechnung ----\nKdnr: " + this.kdnr + "\nNetto:  " + this.netto + "€\nMwst: " + Rechnung.mwst 
				* this.netto + "€\nBrutto: " + (this.netto + Rechnung.mwst * this.netto) + "€\n------------------";
	}
}
