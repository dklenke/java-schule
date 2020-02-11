package de.hss.vererbung;

public class Kfz extends Maschine{
	private double tarifKm;
	private int km;
	public Kfz(double tarifTag, int dauer, double tarifKm, int km) {
		super(tarifTag, dauer);
		this.km = km;
		this.tarifKm = tarifKm;
	}
	public double getMietpreis() {
		if (this.dauer > 10) {
			return (this.tarifTag * 0.6) * this.dauer + this.tarifKm * this.km;
		}
		else {
			return this.tarifTag * this.dauer + this.tarifKm * this.km;
		}
	}
}
