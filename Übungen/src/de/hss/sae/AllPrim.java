package de.hss.sae;

public class AllPrim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long primCounter = 0;
		for(long zahl = Long.MIN_VALUE; zahl < Long.MAX_VALUE; zahl++) {
			if (zahl == 0 || zahl == 1) {
				continue;
			}
			long i = Long.MIN_VALUE;
			while(i < zahl) {
				if (i == 0 || i == 1) {
					continue;
				}
				if (zahl % i == 0) {
					primCounter++;
					System.out.println(zahl);
				}
				i++;
			}
		}
		System.out.println("The Long numbers contain " + primCounter + " Prime numbers.");
	}

}
