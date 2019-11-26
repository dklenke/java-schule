package de.hss.sae;

import lejos.hardware.lcd.LCD;

public class xwandern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int x = 0; x < 8; x++) {
			LCD.clear();
			int y = 7 - x;
			LCD.drawString("x", x*2, x);
			LCD.drawString("x", y*2, y);
		}
	}

}
