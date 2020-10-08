package de.hss.sae.aufgabe1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Kunde {
	private String name;
	private ArrayList<Karte> karten = new ArrayList<Karte>();
	public Kunde(String name) {
		this.name = name;
	}
	public double BerechneKartenPreis() {
		double kartengesamtpreis = 0;
		for (Karte k : this.karten) {
			kartengesamtpreis += k.BerechneKartenPreis();
		}
		return kartengesamtpreis;
	}
	public void KaufeKarte(double grundPreis, LocalDateTime kaufTag, LocalDateTime spielTag) {
		this.karten.add(new Karte(grundPreis, spielTag, kaufTag));
	}
	@Override
	public String toString() {
		return "Kunde [name=" + name + "]";
	}
	
}
