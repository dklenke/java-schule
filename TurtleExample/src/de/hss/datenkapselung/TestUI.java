package de.hss.datenkapselung;

public class TestUI {

	public static void main(String[] args) {
		Handy testHandy = new Handy("Klenke", "Dario", 12345, 53, 23);
		System.out.println(testHandy.handyrechnung());
		Autovermietung testAutovermietung = new Autovermietung("1df34fs", 15, 4);
		System.out.println(testAutovermietung.toString());
	}

}
