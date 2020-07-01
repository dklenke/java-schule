package de.hss.sae.ga2;

public class Patient {
	private String kvNummer;
	private String name;
	private String vorname;
	
	public Patient() {
		this.kvNummer = "00000";
		this.name = "Mustermann";
		this.vorname = "Max";
	}
	
	public Patient(String knNummer, String name, String vorname) {
		this.kvNummer = knNummer;
		this.name = name;
		this.vorname = vorname;
	}

	public String getKvNummer() {
		return kvNummer;
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}
}
