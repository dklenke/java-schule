package de.hss.assoziationen;

import java.util.ArrayList;

public class Artikel {
	private String artBez;
	private ArrayList<Lieferant> lieferanten = new ArrayList<Lieferant>();
	
	public Artikel(String artBez) {
		this.artBez = artBez;
	}
	
	public String getArtBez() {
		return this.artBez;
	}
	
	public void addLieferant(Lieferant lieferant) {
		this.lieferanten.add(lieferant);
	}
	
	public void removeLieferant(Lieferant lieferant) {
		this.lieferanten.remove(lieferant);
	}
	
	public ArrayList<Lieferant> getLieferanten() {
		return this.lieferanten;
	}
}
