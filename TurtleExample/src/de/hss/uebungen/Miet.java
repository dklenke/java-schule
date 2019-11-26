package de.hss.uebungen;

import java.util.HashMap;

public class Miet {
	public String kundenNr;
	public int tage;
	public int km;
	
	public Miet(String kunNr, int tag, int kilometer) {
		kundenNr = kunNr;
		tage = tag;
		km = kilometer;
	}
	
	@SuppressWarnings("serial")
	public String liefereRechnung() {
		int itterator = tage;
		double kosten = 0.0;
		while(itterator > 10) {
			kosten += 25.0;
			itterator --;
		}
		while(itterator > 0) {
			kosten += 39.0;
			itterator --;
		}
		kosten += (0.19 * km);
		String kostenString = String.valueOf(kosten);
		MyUtils utility = new MyUtils();
		return utility.getPrintString(this, new HashMap<String, String>() {{put("Rechnung", kostenString);}});
	}
}
