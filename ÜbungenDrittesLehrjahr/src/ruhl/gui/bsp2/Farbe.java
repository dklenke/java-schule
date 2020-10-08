package ruhl.gui.bsp2;

import java.awt.Color;

public class Farbe {
	
	private static Color currentColor;

	public static Color zufallsFarbe() {
		Color newCol;
		do {
			float red = (float) Math.random();
			float green = (float) Math.random();
			float blue = (float) Math.random();
			newCol = new Color(red, green, blue);
		}
		while (newCol.equals(currentColor));
		currentColor = newCol;
		return newCol;
	}

}
