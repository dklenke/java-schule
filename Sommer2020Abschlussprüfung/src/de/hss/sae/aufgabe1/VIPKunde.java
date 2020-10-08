package de.hss.sae.aufgabe1;

import java.util.ArrayList;

public class VIPKunde extends Kunde {
	private String telefonnummer;
	private ArrayList<VIPKunde> VIPFreunde = new ArrayList<VIPKunde>();
	public VIPKunde(String name, String telefonnummer) {
		super(name);
		this.telefonnummer = telefonnummer;
	}
	public VIPKunde(String name, String telefonnummer, ArrayList<VIPKunde> freunde) {
		super(name);
		this.telefonnummer = telefonnummer;
		this.VIPFreunde = freunde;
	}
	@Override
	public double BerechneKartenPreis() {
		if (VIPFreunde.size() > 1) {
			return super.BerechneKartenPreis() * 0.95;
		}
		else {
			return super.BerechneKartenPreis();
		}
	}
	@Override
	public String toString() {
		return super.toString() + " VIPKunde [telefonnummer=" + telefonnummer + "]";
	}
	
}
