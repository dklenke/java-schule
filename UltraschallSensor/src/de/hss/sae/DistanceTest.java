package de.hss.sae;

import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class DistanceTest {

	public static void main(String[] args) {

		// Motoren
		EV3LargeRegulatedMotor motorLinks = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor motorRechts = new EV3LargeRegulatedMotor(MotorPort.C);

		// Sensoren
		HssUltraSensor hssUltraSensor = new HssUltraSensor(SensorPort.S2);

		// Variablen
		int anzahlMessungen = 1000000;
		double summe = 0;
		double mittelwert = 0;
		int delay = 10000000 / anzahlMessungen;
		
		double currentDistance;
		double[] distances = new double[anzahlMessungen];
		int iteratorMessungen = anzahlMessungen;

		// Geschwindigkeit setzten
		motorLinks.setSpeed(50);
		motorRechts.setSpeed(50);

		// Motoren fahren los
		motorLinks.rotate(3000, true);
		motorRechts.rotate(3000, true);

		// Messungen:
		while (iteratorMessungen>0) {
			currentDistance = hssUltraSensor.getDistance();
			distances[anzahlMessungen - iteratorMessungen] = currentDistance;
			summe = summe + currentDistance;
			Delay.usDelay(delay);
			iteratorMessungen--;	
		}

		motorRechts.flt();
		motorLinks.flt();

		// Berechnung
		mittelwert = summe / anzahlMessungen;
		
		// Ausgabe
		LCD.drawString("Mittel: " + mittelwert, 0, 2);

		motorLinks.close();
		motorRechts.close();

		Delay.msDelay(6000);
	}
}