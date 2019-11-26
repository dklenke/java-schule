package de.hss.uebungen;

import java.util.HashMap;

public class Personalverwaltung {
	public String persNr;
	public double gehalt;
	public int jahre;
	
	public Personalverwaltung(String personalNr, double monatsGehalt, int arbeitsJahre) {
		persNr = personalNr;
		gehalt = monatsGehalt;
		jahre = arbeitsJahre;
	}
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		Personalverwaltung karl = new Personalverwaltung("1", 5000.0, 10);
		MyUtils utility = new MyUtils();
		System.out.print(utility.getPrintString(karl, new HashMap<String, String>() {{put("Urlaubsgeld", karl.liefereUrlaubsgeld());}}));
	}
	
	public String liefereUrlaubsgeld() {
		double urlaubsgeld = (gehalt * 0.2) + (50.0 * jahre);
		if (urlaubsgeld > 2000.0) {
			return String.valueOf(2000.0);
		}
		return String.valueOf(urlaubsgeld);
	}
}
