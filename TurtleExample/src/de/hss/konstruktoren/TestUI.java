package de.hss.konstruktoren;

public class TestUI {

	public static void main(String[] args) {
//		Energierechnung testE = new Energierechnung(271.03, "Januar", "0123456789", 1);
//		System.out.println(testE.getRechnung() + "\n");
//
//		Buch testBuchIsbn = new Buch("asd12345", "How to write bad code", "Dario Klenke", "4-420-1337-6");
//		Buch testBuchNoIsbn = new Buch("dsa54321", "How to write good code", "Holger Ruhl");
//		System.out.println(testBuchIsbn.toString());
//		testBuchIsbn.ausleihen("kndr-1337");
//		System.out.println(testBuchIsbn.toString());
//		testBuchIsbn.zurueckbekommen();
//		System.out.println(testBuchIsbn.toString());
//
//		System.out.println(testBuchNoIsbn.toString());
		Steuern testSteuer = new Steuern("456-132", 100000, false, 0);
		System.out.println(testSteuer.getInfo());

		Student testStudent = new Student("Dario Klenke", 12345);
		System.out.println(testStudent.toString());
		Student testStudent2 = new Student("Oydin Iqbal", 54321, 1, 1997);
		testStudent2.seminararbeit(14, 9);
		System.out.println(testStudent2.toString());
	}

}
