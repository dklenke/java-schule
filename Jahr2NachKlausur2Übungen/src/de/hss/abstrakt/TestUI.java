package de.hss.abstrakt;

import java.util.ArrayList;

public class TestUI {

	public static void main(String[] args) {
		ArrayList<Mietobjekt> mietobjektListe = new ArrayList<Mietobjekt>();
		mietobjektListe.add(new Doppelzimmer(2, 7, true));
		mietobjektListe.add(new Ferienwohnung(7, 10, false));
		
		for (Mietobjekt m : mietobjektListe) {
			System.out.println(m.getRechnung());
		}
		
		ArrayList<Mitarbeiter> mitarbeiterListe = new ArrayList<Mitarbeiter>();
		mitarbeiterListe.add(new Angestellter("mit-420", "Karl", 53, 15000.99));
		mitarbeiterListe.add(new Arbeiter("mit-137", "Peter", 666, 6.5, 721));
		
		for (Mitarbeiter a : mitarbeiterListe) {
			System.out.println(a.berechneMonatslohn());
		}
	}

}
