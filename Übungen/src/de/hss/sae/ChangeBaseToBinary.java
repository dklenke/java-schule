package de.hss.sae;

import java.util.Scanner;

public class ChangeBaseToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte umzuwandelnde Dezimalzahl eingeben: ");
		int dez = scanner.nextInt();
		int workDez = dez;
		String binary = "";
		int iter = 0;
		
		while(workDez != 0) {
			binary = String.valueOf(workDez%2) + binary;
			workDez = workDez / 2;
			if ((iter+1)%4 == 0) {
				binary = " " + binary;
			}
			iter++;
		}
		while (iter%4 != 0){
			binary = "0" + binary;
			iter++;
		}
		System.out.println(dez + " entspricht der Binärzahl " + binary);
		
	}

}
