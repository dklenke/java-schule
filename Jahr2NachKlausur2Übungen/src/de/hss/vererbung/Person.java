package de.hss.vererbung;

public class Person {
	protected String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String kennung() {
		return "Ich bin die Person " + this.name + ".";
	}
}
