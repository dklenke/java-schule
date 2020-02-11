package de.hss.vererbung;

public class Maschine {
	protected double tarifTag;
	protected int dauer;
	
	public Maschine(double tarifTagIn, int dauerIn) {
		this.dauer = dauerIn;
		this.tarifTag = tarifTagIn;
	}
	
	public double getMietpreis() {
		return this.dauer * this.tarifTag;
	}
}