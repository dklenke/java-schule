package de.hss.dreiersteklassen;

/*
 * Beschreibung:	erste eigene Fachklasse, die von anderen Klassen
 * 					benutzt wird
 * 
 */

public class Hallo {

	//--- Attribute ---
	
	//--- Methoden ---
	// Modifizierer - Rückgabetyp - Name der Methode
	
	public void sagHallo() {
		System.out.println("Hallo, wie gehts?");
	}
	
	public void sagTschuess() {
		System.out.println("Tschüss!");
	}
	
	public void sagEtwas() {
		int rand = (int)(Math.random()*100);
		if (rand <= 25) {
			System.out.println("Hi!");
		}
		else if (rand > 25 && rand <= 50) {
			System.out.println("Halli-Hallo");
		}
		else if (rand > 50 && rand <= 75) {
			System.out.println("Ich hab eine " + String.valueOf(rand) + " gewürfelt!");
		}
		else if (rand == 99) {
			System.out.println("SYSTEM MALFUNCTION! E.X.T.E.R.M.I.N.A.T.E ( ͡ʘ ͜ʖ ͡ʘ)");
		}
		else {
			System.out.println("Auf Wiedersehen!");
		}
	}

}
