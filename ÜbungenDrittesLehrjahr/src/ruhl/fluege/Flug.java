package ruhl.fluege;

public class Flug {
	private String flugnummer;
	private Pilot pilot;
	private Flugzeug flugzeug;
	
	public Flug(String flugnummer, Pilot pilot, Flugzeug flugzeug) {
		this.flugnummer = flugnummer;
		this.flugzeug = flugzeug;
		this.pilot = pilot;
	}
	
	public boolean buchen (Passagier passagier) {
		return this.flugzeug.hinzufuegen(passagier);
	}
	
	public String passagierliste() {
		return "Passagierliste f�r Flug-Nr." + this.flugnummer + "\nPilot: " + this.pilot.getName() + 
				"\nFlugzeugtyp: " + this.flugzeug.getTyp() + "\n" + 
				this.flugzeug.getPassagiere() + "\n" + this.flugzeug.passagierListe;
	}
}
