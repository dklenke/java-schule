package de.hss.sae;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;

public class UltraStop {
	
	static EV3LargeRegulatedMotor motorLinks = new EV3LargeRegulatedMotor(MotorPort.A);
	static EV3LargeRegulatedMotor motorRechts = new EV3LargeRegulatedMotor(MotorPort.C);
	static EV3UltrasonicSensor ultraSensor = new EV3UltrasonicSensor(SensorPort.S2);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		motorRechts.setSpeed(180);
		motorLinks.setSpeed(180);
		
		ultraSensor.setCurrentMode("Distance");
		float[] ultraSample = new float[ultraSensor.sampleSize()];
		ultraSensor.fetchSample(ultraSample, 0);
		float abstand = ultraSample[0] * 100;
		
		//LCD.drawString(String.valueOf(abstand), 1, 1);
		
		motorRechts.forward();
		motorLinks.forward();
		
		while (abstand > 20) {
			ultraSensor.fetchSample(ultraSample, 0);
			abstand = ultraSample[0] * 100;
		}
		
		LCD.drawString("STOP", 1, 1);
		motorRechts.stop();
		motorLinks.stop();
		Delay.msDelay(2000);
	}

}
