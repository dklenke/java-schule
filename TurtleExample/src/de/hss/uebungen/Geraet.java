package de.hss.uebungen;

import java.util.HashMap;

public class Geraet {
	public String geraeteNr;
	public int alter;
	public int neupreis;
	
	public Geraet(String gerNr, int alt, int preis) {
		geraeteNr = gerNr;
		alter = alt;
		neupreis = preis;
	}

	@SuppressWarnings("serial")
	public String liefereGeraeteWert() {
		int n = neupreis;
		double wert = alter <= 1 ? n : alter == 2 ? n * 0.5 : alter == 3 ? n * 0.25 : alter == 4 ? n * 0.125 : n * 0.1;
		MyUtils utility = new MyUtils();
		String wertString = String.valueOf(wert);
		return utility.getPrintString(this, new HashMap<String, String>() {{put("Gerätepreis", wertString);}});
	}
}
