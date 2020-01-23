package de.hss.staticAufgaben;

public class Kreis {
	private static final double PI = 3.1415;
	
	private Kreis() {		
	}
	
	public static double umfang (double r) {
		return 2*Kreis.PI*r;
	}
	
	public static double flaeche (double r) {
		return Kreis.PI*r*r;
	}
}
