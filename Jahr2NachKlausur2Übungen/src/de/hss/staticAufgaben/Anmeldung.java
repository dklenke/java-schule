package de.hss.staticAufgaben;

public class Anmeldung {
	private String name;
	private int nr;
	private static int zaehler = 1;
	
	public Anmeldung (String name) {
		this.name = name;
		this.nr = Anmeldung.zaehler;
		Anmeldung.zaehler ++;
	}

	@Override
	public String toString() {
		return "Anmeldung [name=" + name + ", nr=" + nr + "]";
	}
}
