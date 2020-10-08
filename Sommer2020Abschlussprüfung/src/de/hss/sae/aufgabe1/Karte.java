package de.hss.sae.aufgabe1;

import java.time.LocalDateTime;

public class Karte {
	private double grundPreis;
	private LocalDateTime spielTag;
	private LocalDateTime gekauftAm;
	public Karte(double grundPreis, LocalDateTime spielTag, LocalDateTime gekauftAm) {
		this.grundPreis = grundPreis;
		this.spielTag = spielTag;
		this.gekauftAm = gekauftAm;
	}
	public double BerechneKartenPreis() {
		LocalDateTime fruehBucherTermin = spielTag.minusMonths(1);
		if (gekauftAm.isAfter(fruehBucherTermin)) {
			return grundPreis;
		}
		else {
			return grundPreis * 0.9;
		}
	}
}
