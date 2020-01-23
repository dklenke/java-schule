package de.hss.assoziationen;

public class DJ {
	private String name;
	private Disco disco;
	
	public DJ(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDisco(Disco disco) {
		this.disco = disco;
	}
	
	public void removeDisco() {
		this.disco = null;
	}
	
	public String info() {
		return this.disco != null ? "DJ " + this.name + " arbeitet gerade für Disco " + this.disco.getName() + "." 
				: "DJ " + this.name + " darf ausschlafen.";
	}
}
