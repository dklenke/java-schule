package de.hss.sae.ga1;

public class NetzwerkUI {
	public static void main(String[] args) {
		SozialesNetzwerk hss = new SozialesNetzwerk();
		Person p1 = new Person("Schlemmer", "Horst");
		Person p2 = new Person("Berger", "Erika");
		
		hss.hinzufuegenMitglied(p1);
		hss.hinzufuegenMitglied(p2);
		
		Nachricht n1 = new Textnachricht("Wie gehts?", p1);
		Nachricht n2 = new Textnachricht("Hallo Welt", p2);
		
		hss.hinzufuegenNachricht(n1);
		hss.hinzufuegenNachricht(n2);
		
		n1.hinzufuegenLike();
		
		System.out.println(hss.getAlleNachrichten());
		
		System.out.println(p1.getPaswort("Das ist ein Beispiel Satz"));
	}
}
