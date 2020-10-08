package de.hss.sae.aufgabe1;

public class SpontanKunde extends Kunde {
	private String email;
	public SpontanKunde(String name, String email) {
		super(name);
		this.email = email;
	}
	public double BerechneKartenPreis() {
		return super.BerechneKartenPreis();
	}
	@Override
	public String toString() {
		return super.toString() + " SpontanKunde [email=" + email + "]";
	}
	
}
