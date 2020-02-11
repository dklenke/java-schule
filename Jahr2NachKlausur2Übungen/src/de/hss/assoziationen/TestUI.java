package de.hss.assoziationen;

public class TestUI {

	public static void main(String[] args) {
		Auto a1 = new Auto("Opel Corsa", "rot");
		Person p1 = new Person("Heinz");
		p1.fahren(a1);
		System.out.println(p1.info());
		p1.aussteigen();
		System.out.println(p1.info());
		System.out.println("-----------------------------");
		Disco d1 = new Disco("Stefan");
		DJ j1 = new DJ("Ruhl");
		System.out.println(d1.info());
		System.out.println(j1.info());
		d1.buchen(j1);
		System.out.println("--- Disco bucht DJ ---");
		System.out.println(d1.info());
		System.out.println(j1.info());
		System.out.println("----------------------------------");
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1.test);
		s2.increase();
		System.out.println(s1.test);
	}

}
