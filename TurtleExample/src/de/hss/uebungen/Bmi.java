package de.hss.uebungen;

import java.util.HashMap;

public class Bmi {
	public String name;
	public double gewicht;
	public double laenge;
	
	public Bmi(String n, double g, double l) {
		name = n;
		gewicht = g;
		laenge = l;
	}

	public static void main(String[] args) {
		
	}
	
	@SuppressWarnings("serial")
	public String liefereBMI() {
		MyUtils utility = new MyUtils();
		double bmi = gewicht / (laenge * laenge);
		String bmiString = bmi >= 40 ? "extremes Übergewicht" : bmi >= 25 ? "Übergewicht" : bmi >= 19 ? "normal" : bmi >= 16 ? "Untergewicht" : "extremes Untergewicht";
		return utility.getPrintString(this, new HashMap<String, String>() {{put("BMI Fazit", bmiString);}});
	}

}
