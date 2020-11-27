package ruhl.encryption;

public class Vernam {
	public String chiffriere (String input, String schluessel) {
		char[] inArray = input.toCharArray();
		char[] keyArray = schluessel.toCharArray();
		String output = "";
		for (int i = 0; i < inArray.length; i++) {
			int inLetterValue = (int) inArray[i];
			int keyLetterValue = (int) keyArray[i];
			int newLetterVlaue = ((int) inArray[i] + (int) keyArray[i]) % 256;
			System.out.println("input letter: " + inLetterValue + " | key Letter: " + keyLetterValue + " | new Value " + newLetterVlaue + " | new Letter: " + (char) newLetterVlaue);
			output += (char) (((int) inArray[i] + (int) keyArray[i]) % 256); 
		}
		return output;
	}
	
	public String decrypt (String input, String schluessel) {
		char[] inArray = input.toCharArray();
		char[] keyArray = schluessel.toCharArray();
		String output = "";
		for (int i = 0; i < inArray.length; i++) {;
			output += (char) (((int) inArray[i] - (int) keyArray[i]) % 256); 
		}
		return output;
	}
}
