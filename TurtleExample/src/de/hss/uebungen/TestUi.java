package de.hss.uebungen;

public class TestUi {

	public static void main(String[] args) {
		Geraet testGeraet = new Geraet("1", 2, 100);
		Zimmer testZimmer = new Zimmer("karl", 6, 2);
		Miet testMiet = new Miet("1", 15, 500);
		Bmi testBmi = new Bmi("Dario", 100.0, 1.96);
		
		System.out.print(testGeraet.liefereGeraeteWert());
		System.out.print(testZimmer.liefereZimmerpreis());
		System.out.print(testMiet.liefereRechnung());
		System.out.print(testBmi.liefereBMI());
	}
}
