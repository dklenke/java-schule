package de.hss.uebungen;

import java.util.Scanner;

public class Kreis {
	public double radius;
	
	public Kreis() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Geben Sie den Radius des Kreises ein:");
	    radius = scan.nextDouble();
	    scan.close();
	}
	
	public double umfang() {
		double umfang = 2 * Math.PI * radius;
		System.out.println("Der Kreis hat einen Umfang von " + String.valueOf(umfang) + " cm.");
		return umfang ;
	}
	
	public double flaeche() {
		double flaeche = Math.PI * radius * radius;
		System.out.println("Der Kreis hat eine Fläche von " + String.valueOf(flaeche) + " cm².");
		return flaeche;
	}
	
	public double volumen() {
		double volumen = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
		System.out.println("Der Kreis hat ein Volumen von " + String.valueOf(volumen) + " cm³.");
		return volumen;
	}
}
