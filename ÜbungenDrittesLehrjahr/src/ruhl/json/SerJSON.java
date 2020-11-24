package ruhl.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ruhl.xml.Schueler;

public class SerJSON {

	public static void main(String[] args) throws IOException {
		Schueler s = new Schueler("Paul Panzer", "E2FI3");
		ArrayList<Schueler> al_s = new ArrayList<Schueler>();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		FileWriter fw = new FileWriter("schueler.json");
		FileWriter al_fw = new FileWriter("al_schueler.json");
		
		gson.toJson(s, fw);
		gson.toJson(al_s, al_fw);
		fw.close();
		
		BufferedReader br = new BufferedReader(new FileReader("schueler.json"));
		
		Schueler s_neu = gson.fromJson(br, Schueler.class);
		System.out.println(s_neu);
	}

}
