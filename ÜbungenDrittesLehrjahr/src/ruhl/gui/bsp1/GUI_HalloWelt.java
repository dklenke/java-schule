package ruhl.gui.bsp1;

import javax.swing.JFrame;

public class GUI_HalloWelt extends JFrame{

	// Startpunkt
	public static void main(String[] args) {
		new GUI_HalloWelt();
	}

	// Konstruktor
	public GUI_HalloWelt() {
		setTitle("Hallo Welt"); // Titel setzen.
		setVisible(true); // Fenster anzeigen.
		setSize(500, 300); // Gr��e x, y in Pixel festlegen,
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Anwendung schlie�t wenn man oben rechts schlie�en dr�ckt.
	}
}
