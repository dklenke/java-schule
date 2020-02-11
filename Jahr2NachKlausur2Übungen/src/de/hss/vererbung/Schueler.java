package de.hss.vererbung;

public class Schueler extends Person{
	private String klasse;
	
	public Schueler(String name, String klasse) {
		super(name);
		this.klasse = klasse;
	}
	
	public String kennung() {
		return "Ich bin der Schüler " + this.name + ". Ich bin in der Klasse " + this.klasse + ".";
	}
}
