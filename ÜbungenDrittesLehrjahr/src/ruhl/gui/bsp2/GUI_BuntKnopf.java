package ruhl.gui.bsp2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI_BuntKnopf extends JFrame {
	
	// Deklaration aller GUI Elemente
	private JButton jumpKnopf;
	private JButton btnKnopf2;
	private JButton btnKnopf3;
	private JButton btnKnopf4;
	private JButton btnKnopf5;
	
	private Container pinnwand;
	private Container pinnwand2;
	
	private boolean btnKnopf2Pressed = false;

	// Startpunkt
	public static void main(String[] args) {
		new GUI_BuntKnopf();
	}

	// Konstruktor
	public GUI_BuntKnopf() {
		setTitle("Hallo Welt"); // Titel setzen.
		setVisible(true); // Fenster anzeigen.
		setSize(500, 300); // Größe x, y in Pixel festlegen,
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Anwendung schließt wenn man oben rechts schließen drückt.
		
		pinnwand = getContentPane(); // Referenz auf Zeichenfläche
		pinnwand2 = new JPanel();
		
		// 1.) Komponenten erzeugen
		jumpKnopf = new JButton("center");
		btnKnopf2 = new JButton("south");
		btnKnopf3 = new JButton("north");
		btnKnopf4 = new JButton("east");
		btnKnopf5 = new JButton("west");
		
		jumpKnopf.setFocusPainted(false);
		btnKnopf2.setFocusPainted(false);
		btnKnopf3.setFocusPainted(false);
		btnKnopf4.setFocusPainted(false);
		btnKnopf5.setFocusPainted(false);
		
		// 2.) Komponente anordnen und hinzufügen
		pinnwand.add(pinnwand2, BorderLayout.CENTER);
		pinnwand.add(btnKnopf2,BorderLayout.SOUTH);
		pinnwand.add(btnKnopf3,BorderLayout.NORTH);
		pinnwand.add(btnKnopf4,BorderLayout.EAST);
		pinnwand.add(btnKnopf5,BorderLayout.WEST);
		
		pinnwand2.add(jumpKnopf, BorderLayout.CENTER);
		
		// 3.) Auf Ereignis reagieren
		Farbe myColor = new Farbe();
		jumpKnopf.addActionListener(e->{
			moveButton(myColor);
			this.btnKnopf2Pressed = false;
		});
		btnKnopf2.addActionListener(e->{
			Color currentButtonPress = myColor.zufallsFarbe();
			btnKnopf2Pressed ^= true;
			btnKnopf2.setBackground(currentButtonPress);
			btnKnopf2.setText(getColorDescription(currentButtonPress));
		});
		btnKnopf3.addActionListener(e->{
			Color currentButtonPress = myColor.zufallsFarbe();
			btnKnopf3.setBackground(currentButtonPress);
			btnKnopf3.setText(getColorDescription(currentButtonPress));
		});
		btnKnopf4.addActionListener(e->{
			Color currentButtonPress = myColor.zufallsFarbe();
			btnKnopf4.setBackground(currentButtonPress);
			btnKnopf4.setText(getColorDescription(currentButtonPress));
		});
		btnKnopf5.addActionListener(e->{
			Color currentButtonPress = myColor.zufallsFarbe();
			btnKnopf5.setBackground(currentButtonPress);
			btnKnopf5.setText(getColorDescription(currentButtonPress));
		});
		
		Thread thread = new Thread(new Runnable() {

		     public void run() {
		          while(true) {
		        	  try {
		        		  Thread.sleep(300);
		        	  } catch (InterruptedException e) {
						// TODO Auto-generated catch block
		        		  e.printStackTrace();
		        	  }
		        	  if (btnKnopf2Pressed) {
		        		  moveButton(myColor);
		        	  }
		          }
		     }

		});
		thread.start();
		
		pinnwand.setVisible(true);
	}
	
	private String getColorDescription (Color c) {
		return "R: " + c.getRed() + " G: " + c.getGreen() + " B: " + c.getBlue();
	}
	
	private void moveButton(Farbe myColor) {
		Color currentButtonPress = myColor.zufallsFarbe();
		pinnwand2.removeAll();
		pinnwand2.setBackground(currentButtonPress);
		pinnwand2.setLayout(null); // Absolute Positionierung der Komponenten
		int x = (int) (Math.random() * (pinnwand2.getWidth()-150));
		int y = (int) (Math.random() * (pinnwand2.getHeight()-30));
		jumpKnopf.setText(getColorDescription(currentButtonPress));
		jumpKnopf.setBounds(x, y, 150, 30);
		pinnwand2.add(jumpKnopf);
		pinnwand2.revalidate();
		pinnwand2.repaint();
	}

}
