package de.hss.sae;

import java.util.Scanner;

public class SummeBisGrenz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte eingeben bis wohing Zahlen summiert werden sollen: ");
		int g = scanner.nextInt();
		int out = 1;
		int i = 0;
		int addierer = 2;
		while (out <= g) {
			out += addierer;
			i++;
			addierer++;
		}
		//i = i-1;
		out = out - addierer;
		System.out.println("Nach insgesamt " + i + " Iterationen war die Summe " + out + " und damit so hoch wie möglich unter dem Grenzwert.");
	}
}