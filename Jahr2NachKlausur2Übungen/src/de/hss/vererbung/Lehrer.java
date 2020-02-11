package de.hss.vererbung;

public class Lehrer extends Person{
	private String fach;
	
	public Lehrer(String name, String fach) {
		super(name);
		this.fach = fach;
	}
	
	public String kennung() {
		return "Ich bin der Lehrer " + this.name + ". Ich unterrichte " + this.fach + ".";
	}
}
