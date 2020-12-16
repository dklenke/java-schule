package ruhl.encryption;

public class Vigenere {
	public String encrypt (String input, String schluessel) {
		schluessel = adaptKeyLength(input, schluessel);
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			output += (char) (((int) input.charAt(i) + (int) schluessel.charAt(i)) % 256); 
		}
		return output;
	}
	
	public String decrypt (String input, String schluessel) {
		schluessel = adaptKeyLength(input, schluessel);
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			output += (char) (((int) input.charAt(i) - (int) schluessel.charAt(i) - 256) % 256 + 256); 
		}
		return output;
	}
	
	private String adaptKeyLength (String input, String schluessel) {
		while (input.length() > schluessel.length()) {
			schluessel += schluessel;
		}
		while (input.length() != schluessel.length()) {
			schluessel = schluessel.substring(0, schluessel.length() - 1);
		}
		return schluessel;
	}
}
