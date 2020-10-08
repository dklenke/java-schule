package ruhl.fluege;

public class Platz {
	private int nummer;
	private Passagier passagier;
	
	protected Platz(int nummer) {
		this.nummer = nummer;
	}
	
	public Passagier getPassagier() {
		return this.passagier;
	}
	
	public void setPassagier(Passagier passagier) {
		this.passagier = passagier;
	}
	
	public int getNummer() {
		return this.nummer;
	}
}
