
public class Bruch {
	private int z;
	private int n;
	
	public Bruch (int z, int n) {
		this.z = z;
		this.n = n;
	}
	
	@Override
	public String toString() {
		return z + "/" + n;
	}
	
	public double toDouble() {
		return Double.valueOf(z) / Double.valueOf(n);
	}
	
	public void erweitern (int zahl) {
		this.z *= zahl;
		this.n *= zahl;
	}
	
	public void kuerzen () {
		int tempGGT = ggT(z,n);
		this.n /= tempGGT;
		this.z /= tempGGT;
	}
	
	private int ggT (int zahl1, int zahl2) {
		while (zahl1 != 0) {
			int tmp = zahl2%zahl1;
			zahl2 = zahl1;
			zahl1 = tmp;
		}
		return zahl2;
	}
	
	private int kgV (int zahl1, int zahl2) {
		return Math.abs(zahl1*zahl2)/ggT(zahl1, zahl2);
	}
	
	public Bruch add (Bruch b) {
		this.kuerzen();
		b.kuerzen();
		int hauptnenner = kgV (this.n, b.n);
		this.erweitern(hauptnenner / this.n);
		b.erweitern(hauptnenner / b.n);
		Bruch out = new Bruch(this.z + b.z, hauptnenner);
		out.kuerzen();
		return out;
	}
	
	public Bruch sub (Bruch b) {
		this.kuerzen();
		b.kuerzen();
		int hauptnenner = kgV (this.n, b.n);
		this.erweitern(hauptnenner / this.n);
		b.erweitern(hauptnenner / b.n);
		Bruch out = new Bruch(this.z - b.z, hauptnenner);
		out.kuerzen();
		return out;
	}
	
	public Bruch mul (Bruch b) {
		Bruch out = new Bruch (b.z * this.z, b.n * this.n);
		out.kuerzen();
		return out;
	}
	
	public Bruch div (Bruch b) {
		Bruch out = this.mul(new Bruch(b.n, b.z));
		out.kuerzen();
		return out;
	}
}
