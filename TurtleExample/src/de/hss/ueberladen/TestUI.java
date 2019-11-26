package de.hss.ueberladen;

public class TestUI {

	public static void main(String[] args) {
		Kunde testKunde = new Kunde("dario", "1a2b3c4", 2.0);
		testKunde.einkaufen(5.99);
		System.out.println(testKunde.bezahlen());
	}

}
