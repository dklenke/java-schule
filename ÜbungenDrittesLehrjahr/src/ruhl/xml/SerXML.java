package ruhl.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class SerXML {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Schueler s = new Schueler("Max Musterman", "E2FI3");
		ArrayList<Schueler> al_s = new ArrayList<Schueler>();
		al_s.add(new Schueler("Paul Panzer", "M1xx"));
		al_s.add(new Schueler("Hans Panzer", "M2xx"));
		al_s.add(new Schueler("Georg Panzer", "M2xx"));
		XMLEncoder xmle = new XMLEncoder(new FileOutputStream("schueler.xml"));
		xmle.writeObject(al_s);
		xmle.close();
		
		XMLDecoder xmld = new XMLDecoder(new FileInputStream("schueler.xml"));
		ArrayList<Schueler> s_neu = (ArrayList<Schueler>) xmld.readObject();
		xmld.close();
		
		System.out.println(s_neu);

	}

}
