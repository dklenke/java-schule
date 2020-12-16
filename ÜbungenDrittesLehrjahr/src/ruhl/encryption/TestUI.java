package ruhl.encryption;

public class TestUI {

	public static void main(String[] args) {
		Caesar c = new Caesar(1);
		String crypt1 = c.encrypt("Caesar war für seine Zeit, um 100 v. Chr., ein grosser Feldherr");
		System.out.println(crypt1);
		System.out.println(c.decrypt(crypt1));
		
		Vernam asd = new Vernam();
		String sdf = asd.chiffriere("Darioäöü,!", "asdfg!!!rt");
		System.out.println(sdf);
		System.out.println(asd.decrypt(sdf, "asdfg!!!rt"));
		
		Vigenere v1 = new Vigenere();
		String vigOut = v1.encrypt("Caesar war für seine Zeit, um 100 v. Chr., ein grosser Feldherr", "Dieser Test");
		System.out.println(vigOut);
		System.out.println(v1.decrypt(vigOut, "Dieser Test"));
		
		Alberti a1 = new Alberti();
		String albOut = a1.encrypt("Dies ist ein Test !", 3, 6);
		System.out.println(albOut);
		System.out.println(a1.decrypt(albOut, 3, 6));
		
		Eva e1 = new Eva();
		String evaOut = e1.encrypt("Dies ist ein Test!");
		System.out.println(evaOut);
		System.out.println(e1.decrypt(evaOut));
	}

}
