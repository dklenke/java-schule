package de.hss.datenkapselung;

public class Handy {
	private String name;
	private String vorname;
	private int kundennummer;
	private int tageinheit;
	private int nachteinheit;
	
	public Handy(String nameIn, String vornameIn, int kundennummerIn, int tageinheitIn, int nachteinheitIn) {
		this.setName(nameIn);
		this.setVorname(vornameIn);
		this.setKundennummer(kundennummerIn);
		this.setTageinheit(tageinheitIn);
		this.setNachteinheit(nachteinheitIn);
	}
	
	public String handyrechnung() {
		int te = this.getTageinheit();
		double tePreis = 0.0;
		while(te > 0) {
			tePreis += te >= 50 ? 0.32 : 0.39;
			te--;
		}
		
		int ne = this.getNachteinheit();
		double nePreis = 0.0;
		while(ne > 0) {
			nePreis += ne >= 50 ? 0.15 : 0.19;
			ne--;
		}
		
		String out = "******************Handyrechnung*********************\n"
				+ "Kundennummer:     " + this.getKundennummer() + "\n"
				+ "Tageinheit:       " + this.getTageinheit() + "    Preis: " +  Math.floor(tePreis * 100) / 100 + " EURO\n"
				+ "Tageinheit:       " + this.getNachteinheit() + "    Preis: " + Math.floor(nePreis * 100) / 100 + " EURO\n"
				+ "--------------------------------------------------------\n"
				+ "Gesamtpreis:                                    " + (Math.floor((nePreis + tePreis) * 100) / 100) + "\n"
				+ "****************************************************";
		return out;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public int getKundennummer() {
		return kundennummer;
	}
	public void setKundennummer(int kundennummer) {
		if (kundennummer < 0) {
			System.out.println("Please enter positive Value");
		}
		else {
			this.kundennummer = kundennummer;			
		}
	}
	public int getTageinheit() {
		return tageinheit;
	}
	public void setTageinheit(int tageinheit) {
		if (tageinheit < 0) {
			System.out.println("Please enter positive Value");
		}
		else {
			this.tageinheit = tageinheit;			
		}
	}
	public int getNachteinheit() {
		return nachteinheit;
	}
	public void setNachteinheit(int nachteinheit) {
		if (nachteinheit < 0) {
			System.out.println("Please enter positive Value");
		}
		else {
			this.nachteinheit = nachteinheit;			
		}
	}
	
}
