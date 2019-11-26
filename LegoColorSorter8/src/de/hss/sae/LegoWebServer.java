package de.hss.sae;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class LegoWebServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LegoWebServer(8080);

	}
	public LegoWebServer(int port)
	{
		InetSocketAddress address = new InetSocketAddress(port);
		try
		{
			HttpServer server = HttpServer.create(address, 0);

			server.start();

			LCD.drawString("Server startet.", 0, 0);

			for (int i = 0; i < 5; i++)
			{
				LCD.drawString(".", i, 1);
				Delay.msDelay(300);
			}

			Sound.twoBeeps();
			LCD.drawString("GO!!", 0, 3);

		} catch (Exception e)
		{
			educatorRobot.zeigeInfos(e.getMessage());
		}
	}


}
