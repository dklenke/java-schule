package de.hss.abstrakt;

public abstract class Mitarbeiter {
	protected String id;
	protected String name;
	protected int kinderanzahl;
	public Mitarbeiter(String id, String name, int kinderanzahl) {
		this.id =id;
		this.name = name;
		this.kinderanzahl = kinderanzahl > 1 ? Math.min(kinderanzahl, 10) : 1;
	}
	public abstract String berechneMonatslohn();
}
