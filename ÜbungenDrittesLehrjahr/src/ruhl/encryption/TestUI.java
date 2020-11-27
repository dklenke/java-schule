package ruhl.encryption;

public class TestUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Caesar c = new Caesar(1);
		String crypt1 = c.encrypt("Caesar war für seine Zeit, um 100 v. Chr., ein grosser Feldherr");
		System.out.println(crypt1);
		System.out.println(c.decrypt(crypt1));
		
		Vernam asd = new Vernam();
		String sdf = asd.chiffriere("Darioüöä,!", "asdfg!!!rt");
		System.out.println(sdf);
		System.out.println(asd.decrypt(sdf, "asdfg!!!rt"));
	}

}
