package de.hss.abstrakt;

public class Lohnabrechnung {

	public static void main(String[] args) {
		Mitarbeiterliste mal = new Mitarbeiterliste("SAB");
		
		mal.einstellen(new Angestellter("mit-123", "Paul Panzer", 2, 2900.0));
		mal.einstellen(new Arbeiter("mit-124", "Paul Panzer", 2, 15.90, 143));
		mal.einstellen(new Angestellter("mit-123", "Paul Panzer", 2, 2900.0));
		mal.einstellen(new Arbeiter("mit-123", "Paul Panzer", 2, 2900.0));
	}

}
