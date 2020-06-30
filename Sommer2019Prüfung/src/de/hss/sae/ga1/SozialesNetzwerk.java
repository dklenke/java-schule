package de.hss.sae.ga1;

import java.util.ArrayList;

public class SozialesNetzwerk {
	private ArrayList<Person>mitgliederListe = new ArrayList<Person>();
	private ArrayList<Nachricht>nachrichtListe = new ArrayList<Nachricht>();
	
	public void hinzufuegenMitglied(Person person) {
		this.mitgliederListe.add(person);
	}
	
	public void hinzufuegenNachricht(Nachricht nachricht) {
		this.nachrichtListe.add(nachricht);
	}
	
	public String getAlleNachrichten() {
		String out = "";
		for (Nachricht n : this.nachrichtListe) {
			out += n.getNachricht() + "\n";
		}
		return out;
	}
}
