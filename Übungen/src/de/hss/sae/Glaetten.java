package de.hss.sae;

import java.util.Arrays;

public class Glaetten {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] signal = {1,5,4,5,7,6,8,6,5,4,5,4};
		int[] geglaettet = new int[signal.length];
		
		for (int i = 0; i < signal.length; i++) {
			int current;
			if(i == 0) {
				current = (signal[i] + signal[i+1]) / 2;
			}
			else if(i == signal.length - 1) {
				current = (signal[i] + signal[i-1]) / 2;
			}
			else {
				current = (signal[i+1] + signal[i] + signal[i-1]) / 3;
			}
			geglaettet[i] = current;
		}
		System.out.println("Input" + Arrays.toString(signal));
		System.out.println("Output" + Arrays.toString(geglaettet));
	}

}
