package de.hss.sae;

import java.util.Scanner;

public class Durchschnitt2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int smallest = 0;
		int largest = 0;
		int iter = 0;
		int addedUp = 0;
		
		while(iter<10) {
			System.out.println("Bitte Zahl eingeben: ");
			int current = scanner.nextInt();
			addedUp += current;
			if (iter == 0) {
				smallest = current;
				largest = current;
			}
			else {
				if(current<smallest) {smallest = current;}
				if(current>largest) {largest = current;}
			}
			iter++;
		}
		scanner.close();
		addedUp = addedUp - smallest - largest;
		double durchschnitt = addedUp / 8.0;
		System.out.println(durchschnitt);
	}
}
