package de.hss.sae;

import java.util.Arrays;

public class ArrayUmkehren1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int[] ziel = new int[array.length];
		
		// die Daten von array in umgekehrter Reihenfolge nach ziel kopieren
		for (int i=0; i < array.length; i++) {
			ziel[i] = array[array.length-1-i];
		}
		System.out.println("Original: " + Arrays.toString(array));
		System.out.println("Umgekehrt: " + Arrays.toString(ziel));
		//Ergebnis ausgeben
		for (int i = 0; i < ziel.length; i++) {
			//System.out.println(ziel[i]);
		}
	}

}
