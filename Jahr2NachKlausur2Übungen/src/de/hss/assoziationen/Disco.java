package de.hss.assoziationen;

public class Disco {
	private String name;
	private DJ dj;
	
	public Disco(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void buchen(DJ dj) {
		this.dj = dj;
		dj.setDisco(this);
	}
	
	public void absagen() {
		this.dj = null;
		dj.removeDisco();
	}
	
	public String info() {
		return this.dj != null ? "Für Disko " + this.name + " arbeitet gerade DJ " + this.dj.getName() + "." 
				: "Es arbeitet kein DJ für Disko " + this.name + ".";
	}
}
