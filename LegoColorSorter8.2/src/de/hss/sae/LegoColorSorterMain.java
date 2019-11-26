package de.hss.sae;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.Button;
import lejos.utility.Delay;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;

import java.io.File;
import java.util.ArrayList;

public class LegoColorSorterMain {
	
	// Initialisierung von Motoren, Sensoren und einer Variablen auf die wir von überall aus zugreifen müssen: die Position des Wagens.
	// static = Wird nur einmal beim Bauen der Instanz (einzelne Ausführung einer Klasse) Speicher zugewiesen. (spart auf lange Sicht Speicher)
	static EV3LargeRegulatedMotor motorSorter = new EV3LargeRegulatedMotor(MotorPort.B);
	static EV3LargeRegulatedMotor motorBand = new EV3LargeRegulatedMotor(MotorPort.A);
	static EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
	static EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
	static byte currentPosition;
	
	public static void main(String[] args) throws InterruptedException {
		// In main rufen wir nur die anderen Methoden auf.
		ArrayList<Integer> test = scanForBlocks();
		// testColorValues(test);
		dispenseBlocks(test);
	}
	// Methode ist nicht void = am Ende der Methode muss eine Variable vom Typ der Methode (in diesem Fall ArrayList<Integer>) zurückgegeben werden.
	public static ArrayList<Integer> scanForBlocks () {
		
		// sensor in ColorID Modus. Kategorisiert intern allen input als eine von 7 Farben oder NONE
		colorSensor.setCurrentMode(0);
		
		// Das Array, in das die Werte rein geschrieben werden. Das ist nötig, obwohl es immer nur ein Wert ist bei uns (müsste also kein Array sein)
		// Wahrscheinlich so standartisiert, weil andere Modi des Sensors mehrere Werte zurückgeben.
		float[] colorSample = new float[colorSensor.sampleSize()];
		int buttonID = 0;
		
		// Liste, die wir für die Ausgabe verwenden
		ArrayList<Integer> currentBlocks = new ArrayList<Integer>();
		
		// Haupt Logik zum Farbenscannen: Nach jedem button press wird einmal gescannt, es sei denn der gedrückte button war exit.
		while (buttonID != Button.ID_ESCAPE) {
			LCD.drawString("Bitte Stein an Scanner halten und mit ok bestätigen", 1, 1);
			buttonID = Button.waitForAnyPress();
			if (buttonID == Button.ID_ESCAPE) {
				break;
			}
			colorSensor.fetchSample(colorSample, 0);
			currentBlocks.add(Math.round(colorSample[0]));
		}
		return currentBlocks;
	}
	
	public static void move (int targetState) {
		
		// Methode bewegt den Wagen auf dem Fließband zu bestimmten Gradzahlen, die ich durch ausprobieren festgelegt hab.
		// switch führt in diesem Fall, ein bisschen wie if und else, bei bestimmen Werten der Variable "targetState" bestimmte Befehle aus.
		switch (targetState) {
			case 0: 
				motorBand.rotateTo(0);
				currentPosition = 0;
				break;
			case 1: 
				motorBand.rotateTo(160);
				currentPosition = 1;
				break;
			case 2: 
				motorBand.rotateTo(320);
				currentPosition = 2;
				break;
			case 3: 
				motorBand.rotateTo(480);
				currentPosition = 3;
				break;
		}
	}
	public static void dispenseBlocks (ArrayList<Integer> currentBlocks) {
		
		// Methode um alle Blöcke in die Richtigen Gläser zu legen. Nutzt initState um die Startposition zu sichern, 
		// move um den Wagen zu bewegen und dispenseSingleBlock um einen Block auszuwerfen.
		initState();
		
		// sog. "enhanced for". iteriert durch jedes element in einem array/einer Liste. Kommt dir bestimmt aus einen anderen Sprache bekannt vor ;)
		for (int block : currentBlocks) {
			switch (block) {
				case 0: 
					move(0);
					dispenseSingleBlock();
					break;
				case 1:
					move(1);
					dispenseSingleBlock();
					break;
				case 2:
					move(2);
					dispenseSingleBlock();
					break;
				case 3:
					move(3);
					dispenseSingleBlock();
					break;
			}
		}
		move(0);
	}
	
	public static void dispenseSingleBlock () {
		motorSorter.resetTachoCount();
		motorSorter.rotate(-90);
		Delay.msDelay(500);
		motorSorter.rotate(90);
	}
	
	public static boolean initState () {
		
		// Nutzt den TouchSensor um sicher zu gehen, dass die Position 0 auch ganz links am Fließband liegt.
		float[] touchSample;
		touchSensor.setCurrentMode("Touch");
		touchSample = new float[touchSensor.sampleSize()];
		
		while (touchSample[0] == 0.0) {
			touchSensor.fetchSample(touchSample, 0);
			System.out.println(touchSample);
			motorBand.rotate(-10);
		}
		currentPosition = 0;
		return true;
	}
	
	public static void testColorValues (ArrayList<Integer> currentBlocks) {
		
		// zum Testen: gibt die Werte eines Int Arrays auf dem Display wieder. Soll mit dem output von scanForBlocks verwendet werden.
		String test = "";
		for (int i = 0; i < currentBlocks.size(); i++) {
			test += currentBlocks.get(i) + "/";
		}
		LCD.drawString(test, 0, 1);
		LCD.drawString(currentBlocks.size() + "", 0, 2);
		Delay.msDelay(5000);
	}
	
	public static void playSlayer() throws InterruptedException {
		String path = "C:\\Development\\eclipse-java\\LegoColorSort\\src\\de\\hss\\sae\\rainingblood_mono_sample_8bit_short_lowhertz.wav";
		File file = new File(path);
		int returnCode = Sound.playSample(new File (path), Sound.VOL_MAX);
		LCD.drawInt(returnCode, 1, 1);
		Thread.sleep(10000);
	}
}
