package de.hss.sae.ga2;

public class PraxisUI {

	public static void main(String[] args) {
		Praxis pr1 = new Praxis();
		
		pr1.addPatient(new Patient("kn-1234", "Schlemmer", "Horst"));
		pr1.addPatient(new Patient("kn-1235", "Schlemmer", "Horstine"));
		pr1.addPatient(new Patient("kn-4321", "Büchner", "Georg"));
		
		Physiobehandlung chirogymnastik = new Physiobehandlung("kn-4321", "Dehnübungen gegen akuten Wahnsinn", 12.87);
		Physiobehandlung wärmeanwendung = new Physiobehandlung("kn-1234", "", 4.23);
		Standardbehandlung arthrose = new Standardbehandlung("kn-1234", "Zu viele Schnitzel machen die Gelenke weich", 45.12);
		Standardbehandlung ultraschall = new Standardbehandlung("kn-4321", "So lebte er hin", 26.8);
		
		pr1.addBehandlung(ultraschall);
		pr1.addBehandlung(arthrose);
		pr1.addBehandlung(wärmeanwendung);
		pr1.addBehandlung(chirogymnastik);
		
		System.out.println(pr1.ermittleKosten());
		System.out.println(pr1.zeigePatienten(2));
		System.out.println(pr1.getPatient("Schlemmer"));
		System.out.println(pr1.anzBehandlung("kn-4321"));
		System.out.println(pr1.getBehandlung("kn-4321"));

	}

}
