package mertens.bsp1;

import java.time.LocalDate;

public class Ausleihe {
	private Buch buch;
	private Schueler schueler;
	private LocalDate entleihDatum;
	private LocalDate rueckgabeDatum;
	
	public Ausleihe(Buch buch, Schueler schueler, int rueckgabeTage) {
		super();
		this.buch = buch;
		this.schueler = schueler;
		this.entleihDatum = LocalDate.now();
		this.rueckgabeDatum = LocalDate.now().plusDays(rueckgabeTage);
	}
}
