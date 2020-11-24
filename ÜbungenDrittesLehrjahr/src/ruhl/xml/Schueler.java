package ruhl.xml;

public class Schueler {
	private String name;
	private String klasse;
	public Schueler() {
		super();
	}
	public Schueler(String name, String klasse) {
		super();
		this.name = name;
		this.klasse = klasse;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKlasse() {
		return klasse;
	}
	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}
	@Override
	public String toString() {
		return "Schueler [name=" + name + ", klasse=" + klasse + "]";
	}

}
