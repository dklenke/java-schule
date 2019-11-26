package de.hss.uebungen2;

/*
 * Beschreibung: Testet / Benutzt die Fachklasse Mitarbeiter
 */

public class UIMitarbeiter {

	public static void main(String[] args) {
		Mitarbeiter mit1 = new Mitarbeiter("00001", 2700);
		Mitarbeiter mit2 = new Mitarbeiter("00002", 27000);
		Mitarbeiter mit3 = new Mitarbeiter("00003", 700);
		
		System.out.println(mit1);
		System.out.println(mit2);
		System.out.println(mit3);
	}

}
