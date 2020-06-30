package de.hss.sae.ga1;

public class Person {
	private String nachname;
	private String vorname;
	
	public Person(String nn, String vn) {
		this.nachname = nn;
		this.vorname = vn;
	}

	public String getNachname() {
		return nachname;
	}

	public String getVorname() {
		return vorname;
	}
	
	public String getPaswort(String satz) {
		String out = "";
		int count = 0;
		for (String wort : satz.split(" ")) {
			out += count % 2 == 0 ? wort.substring(0, 1).toUpperCase() : wort.substring(0, 1).toLowerCase();
			count++;
		}
		return out;
	}
}
