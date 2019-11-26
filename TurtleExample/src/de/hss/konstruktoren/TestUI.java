package de.hss.konstruktoren;

public class TestUI {

	public static void main(String[] args) {
		Energierechnung testE = new Energierechnung(271.03, "Januar", "0123456789", 1);
		System.out.println(testE.getRechnung());
		
	}

}
