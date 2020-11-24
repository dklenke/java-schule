package ruhl.encryption;

public class TestUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Caesar c = new Caesar(1);
		String crypt1 = c.encrypt("Caesar war für seine Zeit ein grosser Feldherr");
		System.out.println(crypt1);
		System.out.println(c.decrypt(crypt1));
	}

}
