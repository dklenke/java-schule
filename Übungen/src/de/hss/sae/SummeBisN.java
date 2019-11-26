package de.hss.sae;

import java.util.Scanner;

public class SummeBisN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte eingeben bis wohing Zahlen summiert werden sollen: ");
		int n = scanner.nextInt();
		int out = 0;
		for(int i = 1; i < (n+1); i++) {
			out = out + 1;
		}
		System.out.println("Die Zahlen bis " + n + " summiert ergeben " + out + ".");
	}
}