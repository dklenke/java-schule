package de.hss.uebungen;

import java.util.HashMap;

public class Zimmer {
	public String kundenname;
	public int aufenthaltsdauer;
	public int zimmertyp;
	
	public Zimmer(String n, int d, int z) {
		kundenname = n;
		aufenthaltsdauer = d;
		zimmertyp = z;
	}
	
	@SuppressWarnings("serial")
	public String liefereZimmerpreis() {
		int d = aufenthaltsdauer;
		double zpreis = 0;
		if (zimmertyp == 1) {
			zpreis = d >= 7 ? (49 * d) * 0.8 : d >= 3 ? (49 * d) * 0.9 : (49 * d);
		}
		else if (zimmertyp == 2) {
			zpreis = d >= 7 ? (79 * d) * 0.8 : d >= 5 ? (79 * d) * 0.85 : d >= 3 ? (79 * d) * 0.9 : (79 * d);
		}
		MyUtils utility = new MyUtils();
		String zpreisString = String.valueOf(zpreis);
		return utility.getPrintString(this, new HashMap<String, String>() {{put("Zimmerpreis", zpreisString);}});
	}
}
