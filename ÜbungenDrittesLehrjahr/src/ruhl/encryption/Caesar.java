package ruhl.encryption;

public class Caesar {
	private int schluessel;
	final private char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	public Caesar (int schluessel) {
		this.schluessel = schluessel > 25 ? 25 : schluessel < 1 ? 1 : schluessel;
	}
	
	public String encrypt(String in) {
		in = in.toLowerCase().replace("ä", "ae").replace("ö", "oe").replace("ü", "ue");
		String out = "";
		for (int i = 0; i < in.length(); i++) {
			char x = in.charAt(i);
			out += x == ' ' ? " " : moveChar(x, false);
		}
		return out;
	}
	
	public String decrypt(String in) {
		in = in.toLowerCase().replace("ä", "ae").replace("ö", "oe").replace("ü", "ue");
		String out = "";
		for (int i = 0; i < in.length(); i++) {
			char x = in.charAt(i);
			out += x == ' ' ? " " : moveChar(x, true);
		}
		return out;
	}
	
	private char moveChar (char input, boolean decrypt) {
		int pos = find(alph,input);
		int newPos = decrypt ? pos - this.schluessel : pos + this.schluessel;
		int finalPos = newPos > 25 ? newPos - 26 : newPos < 0 ? 26 + newPos : newPos;
		return alph[finalPos];
	}
	
	public int getSchluessel() {
		return schluessel;
	}

	public void setSchluessel(int schluessel) {
		this.schluessel = schluessel > 25 ? 25 : schluessel < 1 ? 1 : schluessel;
	}
	
	private static int find(char[] a, char target)
	{
		for (int i = 0; i < a.length; i++)
			if (a[i] == target)
				return i;

		return -1;
	}
}
