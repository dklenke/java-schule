package mertens.bsp1;

public class Buch {
	private int buchID;
	private String titel;
	private String autor;
	
	public Buch (int buchID, String titel, String autor) {
		this.buchID = buchID;
		this.autor =  autor;
		this.titel = titel;
	}

	@Override
	public String toString() {
		return "Buch [buchID=" + buchID + ", titel=" + titel + ", autor=" + autor + "]";
	}
}
