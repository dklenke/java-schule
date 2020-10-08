
public class TestUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bruch b1 = new Bruch(1, 2);
		
		pr(b1.toString());
		
		pr("-----------------------");
		
		Bruch b2 = new Bruch(3, 4);
		b2.erweitern(3);
		pr(b2);
		b2.kuerzen();
		pr(b2);
		
		pr("-----------------------");
		
		pr(b1.add(new Bruch(1, 3)));
		
		pr("-----------------------");
		
		pr(b1.mul(b1));
		pr(b1.div(new Bruch (1, 2)));
	}
	
	private static void pr (Object print) {
		System.out.println(print);
	}

}
