package de.hss.sae;

public class DieZweiGroessten {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,1,5,7,4,12,-3,8,-2};
		
		//Variablen f�r die zwei gr��ten Elemente deklarieren und initialisieren
		int big = array[0];
		int big2= array[0];
		
		// die zwei gr��ten Elemente deklarieren und initialisieren
		for (int i=1 ; i < array.length; i++) {
			if (array[i] > big) {
				big = array[i];
			}
			else if (array[i] > big2 && array[i] < big) {
				big2 = array[i];
			}
		}
		System.out.println("Die zwei gr��ten Zahlen sind " + big + " und " + big2);
	}

}
