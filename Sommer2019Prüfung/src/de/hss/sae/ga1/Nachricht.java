package de.hss.sae.ga1;

public abstract class Nachricht {
	protected int likes;
	protected Person absender;
	
	public Nachricht() {
		this.absender = null;
		this.likes = 0;
	}
	
	public Nachricht(Person absender) {
		super();
		this.absender = absender;
		this.likes = 0;
	}
	
	public void hinzufuegenLike() {
		this.likes++;
	}
	
	public abstract String getNachricht();
}
