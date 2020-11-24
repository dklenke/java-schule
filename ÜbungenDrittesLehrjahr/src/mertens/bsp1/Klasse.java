package mertens.bsp1;

public class Klasse {
	private String bez;

	public Klasse(String bez) {
		super();
		this.bez = bez;
	}

	public String getBez() {
		return bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

	@Override
	public String toString() {
		return "Klasse [bez=" + bez + "]";
	}
}
