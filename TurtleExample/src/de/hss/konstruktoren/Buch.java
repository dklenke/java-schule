package de.hss.konstruktoren;

public class Buch {
	private String buchNr;
	private String isbn;
	private String titel;
	private String autor;
	private int anzahlAusleihen;
	private String kundenNummer;
	
	public Buch(String buchNr, String titel, String autor) {
		setBuchNr(buchNr);
		setTitel(titel);
		setAutor(autor);
		setAnzahlAusleihen(0);
		setKundenNummer("kdnr-0000");
		setIsbn("0-0000-0000-0");
	}
	
	public Buch(String buchNr, String titel, String autor, String isbn) {
		setBuchNr(buchNr);
		setTitel(titel);
		setAutor(autor);
		setIsbn(isbn);
		setAnzahlAusleihen(0);
		setKundenNummer("kdnr-0000");
	}

	public String getBuchNr() {
		return buchNr;
	}

	public void setBuchNr(String buchNr) {
		this.buchNr = buchNr;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnzahlAusleihen() {
		return anzahlAusleihen;
	}

	public void setAnzahlAusleihen(int anzahlAusleihen) {
		this.anzahlAusleihen = anzahlAusleihen;
	}

	public String getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(String kundenNummer) {
		this.kundenNummer = kundenNummer;
	}
	
	public void ausleihen(String kndNr) {
		setKundenNummer(kndNr);
		this.anzahlAusleihen += 1;
	}
	
	public void zurueckbekommen() {
		setKundenNummer("kdnr-0000");
	}
	
	public String toString() {
		String out = "\"" + this.titel + ", ISBN " + this.isbn + ", BuchNr " + this.buchNr + ".\n" +
				"Bisher " + this.anzahlAusleihen + " mal ausgeliehen.\n" + "Zur Zeit ";
		if (this.kundenNummer.equals("kdnr-0000")) {
			return  out + "im Regal.";
		}
		else {
			return  out + "an " + this.kundenNummer + " ausgeliehen.";
		}
	}
}
