package ruhl.fluege;

public class Flugzeug {
	private String typ;
	private int anzahlPlaetze;
	public Platz[] passagierListe;
	
	public Flugzeug(String typ, int anzahlPlaetze) {
		this.typ = typ;
		this.anzahlPlaetze = anzahlPlaetze;
		this.passagierListe = new Platz[anzahlPlaetze];
		for (int i = 0; i<this.passagierListe.length; i++) {
			this.passagierListe[i] = new Platz(i + 1);
		}
	}
	
	public String getTyp() {
		return this.typ;
	}
	
	public boolean hinzufuegen(Passagier passagier) {
		 for (Platz p : this.passagierListe) {
			 if(p.getPassagier() == null) {
				 p.setPassagier(passagier);
				 return true;
			 }
		 }
		 return false;
	 }

	public String getPassagiere() {
		String out = "";
		int belegtePlaetze = 0;
		for (Platz p : this.passagierListe) {
			if (p.getPassagier() != null) {
				out += "Platznummer " + p.getNummer() + " sitzt " + p.getPassagier().getName() + ".\n";
				belegtePlaetze++;
			}
		}
		String verb = belegtePlaetze == 1 ? "ist " : "sind ";
		out = "Es " + verb + belegtePlaetze + " von " + this.anzahlPlaetze + " Plätzen belegt.\n" + out;
		return out;
	}
}
