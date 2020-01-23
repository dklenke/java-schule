package de.hss.klausurvorbereitung;

public class TestUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fitness testFit = new Fitness('m', 24, 1, "Dario");
		System.out.println(testFit.toString());
		System.out.println(testFit.zeigeBereich(240));
	}

}
