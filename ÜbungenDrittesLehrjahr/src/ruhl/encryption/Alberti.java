package ruhl.encryption;

public class Alberti {
	public String encrypt(String input, int key1, int key2) {
		if (!validateKeys(key1, key2)) {return "Falsche Schlüssel, Schlüssel müssen zwischen 1-25 und unterschiedlich sein!";}
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			if (i % 2 == 0) {
				int newChar = (int) input.charAt(i) + key1; 
				output += (char) newChar;
			}
			else {
				int newChar = (int) input.charAt(i) + key2; 
				output += (char) newChar;
			}
		}		
		return output;
	}
	public String decrypt(String input, int key1, int key2) {
		if (!validateKeys(key1, key2)) {return input;}
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			if (i % 2 == 0) {
				int newChar = (int) input.charAt(i) - key1; 
				output += (char) newChar;
			}
			else {
				int newChar = (int) input.charAt(i) - key2; 
				output += (char) newChar;
			}
		}		
		return output;
	}
	
	private boolean validateKeys (int key1, int key2) {
		if (key1 < 1 || key1 > 25 || key2 < 1 || key2 > 25 || key1 == key2) {return false;}
		return true;
	}
}
