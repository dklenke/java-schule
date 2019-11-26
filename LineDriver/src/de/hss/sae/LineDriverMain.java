package de.hss.sae;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;

public class LineDriverMain {
	
	static EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
	static EV3LargeRegulatedMotor motorLinks = new EV3LargeRegulatedMotor(MotorPort.A);
	static EV3LargeRegulatedMotor motorRechts = new EV3LargeRegulatedMotor(MotorPort.C);

	public static void main(String[] args) {
		colorSensor.setCurrentMode(2);
		float[] colorSample = new float[colorSensor.sampleSize()];
		motorLinks.setAcceleration(500);
		motorRechts.setAcceleration(500);
		while (!Button.LEFT.isDown() && !Button.RIGHT.isDown() && !Button.DOWN.isDown() && !Button.ENTER.isDown() && !Button.UP.isDown() && !Button.ESCAPE.isDown()) {
			motorLinks.forward();
			motorRechts.forward();
			motorRechts.setSpeed(300);
			motorLinks.setSpeed(300);
			colorSensor.fetchSample(colorSample, 0);
			float red = colorSample[0] * 1000;
			float green = colorSample[1] * 1000;
			float blue = colorSample[2] * 1000;
			LCD.drawString("Red: " + red, 0, 1);
			LCD.drawString("Green: " + green, 0, 2);
			LCD.drawString("Blue: " + blue, 0, 3);
			float colorAmount = red + green + blue;
			LCD.drawString("Amount: " + colorAmount, 0, 4);
			if (colorAmount < 490) {
				motorLinks.setSpeed(50);
				Delay.msDelay(200);
			}
			else if (colorAmount > 510) {
				motorRechts.setSpeed(50);
				Delay.msDelay(200);
			}
		}
	}

}
