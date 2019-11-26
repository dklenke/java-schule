package de.hss.sae;

import java.util.Scanner;

public class Zinseszins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte Startkapital eingeben: ");
		float k0 = scanner.nextFloat();
		System.out.println("Bitte Zinssatz eingeben: ");
		int intrest = scanner.nextInt();
		System.out.println("Bitte Laufzeit eingeben: ");
		int dur = scanner.nextInt();
		
		int workDur = dur;
		float k1 = k0;
		
		while(workDur>0) {
			k1 = k1 + k1/100 * intrest;
			workDur--;
		}
		
		System.out.printf("Nach " + dur + " Jahren ist das Startkapital von " + k0 + " auf %f gewachsen.",k1);
	}

}
