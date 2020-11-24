package mertens.bsp1;

public class Schueler  {

	private String vorname;
	private String nachname;
	private Klasse klasse;

	public Schueler(String vorname, String nachname, Klasse klasse) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.klasse = klasse;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Klasse getKlasse() {
		return klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

	@Override
	public String toString() {
		return ((klasse != null) ? klasse.getBez() : "--" )+ ": " + vorname + " " + nachname;
	}
	
  }
