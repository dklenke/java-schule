package mertens.bsp1;

import java.time.LocalDateTime;

public class Ausleihe {
	private Buch buch;
	private Schueler schueler;
	private LocalDateTime entleihDatum;
	private LocalDateTime rueckgabeDatum;
	
	public Ausleihe(Buch buch, Schueler schueler) {
		super();
		this.buch = buch;
		this.schueler = schueler;
		this.entleihDatum = LocalDateTime.now();
	}

	public LocalDateTime getRueckgabeDatum() {
		return rueckgabeDatum;
	}

	public void setRueckgabeDatum(LocalDateTime rueckgabeDatum) {
		this.rueckgabeDatum = rueckgabeDatum;
	}

	@Override
	public String toString() {
		return "Ausleihe [buch=" + buch + ", schueler=" + schueler + ", entleihDatum=" + entleihDatum
				+ ", rueckgabeDatum=" + rueckgabeDatum + "]";
	}
}
