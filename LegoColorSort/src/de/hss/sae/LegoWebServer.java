package de.hss.sae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class LegoWebServer {

    public static void main(String[] args) throws Exception {
    	new LegoWebServer(80);
    }
    
	public LegoWebServer(int port)
	{
		InetSocketAddress address = new InetSocketAddress(port);
		try
		{
			HttpServer server = HttpServer.create(address, 0);
			server.createContext("/Main", new LegoHandler());
			server.setExecutor(null);
			server.start();

			LCD.drawString("Server startet.", 0, 0);

			for (int i = 0; i < 5; i++)
			{
				LCD.drawString(".", i, 1);
				Delay.msDelay(300);
			}

			//Sound.twoBeeps();
			LCD.drawString("GO!!", 0, 3);

		} catch (Exception e)
		{
			LCD.clear();
			LCD.drawString(e.getMessage().substring(0, 10), 1, 1);
		}
	}
	
    class LegoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
        	try {
				byte [] response = htmlReader("ColorSorterSite.html").getBytes();
	//        	byte [] response = "Big Test".getBytes();
				t.sendResponseHeaders(200, response.length);
				OutputStream os = t.getResponseBody();
				os.write(response);
				os.close();
        	} catch (Exception e) {
        		LCD.clear();
    			LCD.drawString(e.getMessage().substring(0, 10), 1, 1);
        	}
        }
    }
	
	private String htmlReader(String filename)
	{
		String content = new String();
		try
		{

			InputStream inputStream = this.getClass().getResourceAsStream("/" + filename);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String oneRow;

			oneRow = bufferedReader.readLine();

			while (oneRow != null)
			{
				content = content + oneRow + "\n";
				oneRow = bufferedReader.readLine();
			}

			bufferedReader.close();
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

		return content;
	}

}