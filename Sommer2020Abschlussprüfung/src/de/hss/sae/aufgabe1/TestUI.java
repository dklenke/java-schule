package de.hss.sae.aufgabe1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestUI {

	public static void main(String[] args) {
		Kunde k1 = new SpontanKunde("Max Mustermann", "max@muster.de");
		VIPKunde k2 = new VIPKunde("Mann ohne Freunde", "0123456789");
		VIPKunde k3 = new VIPKunde("NPC", "000000000");
		ArrayList<VIPKunde> freunde = new ArrayList<VIPKunde>();
		freunde.add(k2);
		freunde.add(k3);
		Kunde k4 = new VIPKunde("Mann mit Freunden", "0987654321", freunde);
		k1.KaufeKarte(100.0, LocalDateTime.now().minusDays(35), LocalDateTime.now());
		System.out.println(k1.toString() + " : " + k1.BerechneKartenPreis());
		k4.KaufeKarte(100.0, LocalDateTime.now(), LocalDateTime.now());
		k3.KaufeKarte(100.0, LocalDateTime.now(), LocalDateTime.now());
		System.out.println(k4.toString() + " : " + k4.BerechneKartenPreis());
		System.out.println(k3.toString() + " : " + k3.BerechneKartenPreis());
	}

}
