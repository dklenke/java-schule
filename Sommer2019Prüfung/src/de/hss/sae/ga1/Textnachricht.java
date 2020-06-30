package de.hss.sae.ga1;

public class Textnachricht extends Nachricht{
	public String nachricht;
	
	public Textnachricht() {
		super();
		this.nachricht = "";
	}
	public Textnachricht(String nachricht, Person absender) {
		super(absender);
		this.nachricht = nachricht;
	}
	
	@Override
	public String getNachricht() {
		return absender.getNachname() + ", " + nachricht + ", " + likes;
	}
}
