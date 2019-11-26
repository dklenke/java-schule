package de.hss.sae;

import java.util.Scanner;

public class AllPrimPositive {
	
	public static void main(String[] args) {
		
		long primCounter = 0;
		Scanner scanner = new Scanner(System.in);
		
		for(long zahl = 2; zahl < Long.MAX_VALUE; zahl++) {
			long teiler = 2;
			while(teiler <= zahl/2) {
				if (zahl % teiler == 0) {
					primCounter++;
					System.out.println(zahl);
					break;
				}
				teiler++;
			}
		}
		System.out.println("The Long numbers contain " + primCounter + " Prime numbers.");
	}

}
