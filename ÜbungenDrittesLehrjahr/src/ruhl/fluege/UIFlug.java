package ruhl.fluege;

public class UIFlug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flug f1 = new Flug("FR-1234", new Pilot("Paul Panzer"), new Flugzeug("a-3012", 3));
		
		System.out.println(f1.buchen(new Passagier("Klara Fröhlich")));
		System.out.println(f1.buchen(new Passagier("Karl Fröhlich")));
		System.out.println(f1.buchen(new Passagier("Dario Klenke")));
		System.out.println(f1.buchen(new Passagier("Wütender Gast")));
		System.out.println(f1.passagierliste());
	}

}
