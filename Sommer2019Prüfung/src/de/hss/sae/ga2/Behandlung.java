package de.hss.sae.ga2;

public abstract class Behandlung {
	private String kvNummer;
	private String beschreibung;
	private double kostensatz;
	
	public abstract double getKosten();
	
	public Behandlung() {
		this.kvNummer = "00000";
	}

	public Behandlung(String knNummer, String beschreibung, double kostensatz) {
		super();
		this.kvNummer = knNummer;
		this.beschreibung = beschreibung;
		this.kostensatz = kostensatz;
	}

	public String getKvNummer() {
		return kvNummer;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public double getKostensatz() {
		return kostensatz;
	}	
	
}
