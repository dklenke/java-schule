package ruhl.encryption;

public class Eva {
	public String encrypt(String input) {
		String output = "";
		int it = 1;
		for (char c : input.toCharArray()) {
			output += (char) ((int) c + it);
			it = (it+1) % 10;
			it = it == 0 ? 1 : it;
		}
		return output;
	}
	public String decrypt(String input) {
		String output = "";
		int it = 1;
		for (char c : input.toCharArray()) {
			output += (char) ((int) c - it);
			it = (it+1) % 10;
			it = it == 0 ? 1 : it;
		}
		return output;
	}
}
