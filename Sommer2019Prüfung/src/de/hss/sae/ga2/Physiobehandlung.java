package de.hss.sae.ga2;

public class Physiobehandlung extends Behandlung{
	
	public Physiobehandlung() {
		super();
	}
	
	public Physiobehandlung(String kvNummer, String beschreibung, double kostensatz) {
		super(kvNummer, beschreibung, kostensatz);
	}
	
	@Override
	public double getKosten() {
		return this.getKostensatz() * 1.5;
	}

}
