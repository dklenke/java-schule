package de.hss.sae;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] zahl = {2,7,4,1,9,4,7,9,7,4,5,3,6,45,26,123,87,12,13,14,15,16,89,91,99,345,456,567,678,789,1234,2345,3456,4567,5678,956,957,958,959,21,22,23,24,29,28,27,26,25,37};
		int n = 49;
		boolean vertauscht = false;
		do {
			for (int i=0; i<n-1; i++) {
				if(zahl[i] > zahl[i+1]) {
					int zahli = zahl[i];
					int zahlj = zahl[i+1];
					zahl[i] = zahlj;
					zahl[i+1] = zahli;
					vertauscht = true;
				}
			}
			n--;
		} while (vertauscht == true && n >= 1);
		System.out.println("Sorted: " + Arrays.toString(zahl));
	}

}
