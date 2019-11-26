package de.hss.sae;

import java.util.Scanner;

public class PrimZahl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte eine ganze Zahl eingeben: ");
		long prim = scanner.nextLong();
		long i = 2;
		while(i < prim) {
			if (prim % i == 0) {
				System.out.println(Long.toString(prim) + " ist keine Primzahl, da sie durch " + Long.toString(i) + " teilbar ist.");
				System.exit(0);
			}
			i++;
		}
		System.out.println(Long.toString(prim) + " ist eine Primzahl.");
		
	}

}
