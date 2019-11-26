package de.hss.sae;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wetterstation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temps = {12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 13, 15, 12};
		int high = 0;
		int low = 0;
		int[] umschwung = new int[13];
		for (int i = 1; i < 14; i++) {
			if (temps[i] > temps[high]) {
				high = i;
			}
			if (temps[i] < temps[low]) {
				low = i;
			}
			umschwung[i-1] = Math.abs(temps[i] - temps[i-1]);
		}
		
		//System.out.println(Arrays.toString(umschwung));
		int maxumschwung = 0;
		List<Integer> duplicateMax = new ArrayList<Integer>(); 
		duplicateMax.add(maxumschwung);
		
		for(int j = 1; j < umschwung.length; j++) {
			if(umschwung[j] > umschwung[maxumschwung]) {
				maxumschwung = j;
				duplicateMax.clear();
				duplicateMax.add(j);
			}
			else if(umschwung[j] == umschwung[maxumschwung]) {
				duplicateMax.add(j);
			}
		}
		
		String output = "Der höchste Umschwung war " + umschwung[maxumschwung] + " an dem Tag/den Tagen: ";
		for(int element : duplicateMax) {
			output = output + "Tag " + (element +1) + " auf Tag " + (element +2) + ", ";
		}
		
		System.out.println(output);
		System.out.println("Die höchste registrierte Temperatur war " + temps[high] + " am Tag " + (high + 1));
		System.out.println("Die niedrigste registrierte Temperatur war " + temps[low] + " am Tag " + (low + 1));

	}

}
