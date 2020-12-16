package ruhl.encryption;

public class Vernam {
	public String chiffriere (String input, String schluessel) {
		char[] inArray = input.toCharArray();
		char[] keyArray = schluessel.toCharArray();
		String output = "";
		for (int i = 0; i < inArray.length; i++) {
			output += (char) (((int) inArray[i] + (int) keyArray[i]) % 256); 
		}
		return output;
	}
	
	public String decrypt (String input, String schluessel) {
		char[] inArray = input.toCharArray();
		char[] keyArray = schluessel.toCharArray();
		String output = "";
		for (int i = 0; i < inArray.length; i++) {
			output += (char) (((int) inArray[i] - (int) keyArray[i] - 256) % 256 + 256); 
		}
		return output;
	}
}
