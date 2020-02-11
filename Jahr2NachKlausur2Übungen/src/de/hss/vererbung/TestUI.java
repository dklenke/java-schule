package de.hss.vererbung;

import java.util.ArrayList;

public class TestUI {
	public static void main(String[] args) {
		ArrayList<Person> personen = new ArrayList<Person>();
		
		personen.add(new Person("Hans"));
		personen.add(new Lehrer("Ruhl","SAE"));
		personen.add(new Schueler("Dario","E2FI3"));
		
		for (Person p : personen) {
			System.out.println(p.kennung());
		}
	}
}
