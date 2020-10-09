package mertens.bsp1;

public class Schueler {
	private String name;
	private String vorname;
	
	public Schueler(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}
