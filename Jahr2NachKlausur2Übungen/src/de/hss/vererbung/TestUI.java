package de.hss.vererbung;

public class TestUI {
	public static void main(String[] args) {
		Person hans = new Person("Hans");
		Lehrer ruhl = new Lehrer("Ruhl","SAE");
		Schueler dario = new Schueler("Dario","E2FI3");
		
		System.out.println(hans.kennung());
		System.out.println(ruhl.kennung());
		System.out.println(dario.kennung());
	}
}
