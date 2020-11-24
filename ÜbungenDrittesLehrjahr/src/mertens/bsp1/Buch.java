package mertens.bsp1;

import java.time.LocalDate;

public class Buch {
	private int buchID;
	private String titel;
	private String autor;
	
	public Buch (int buchID, String titel, String autor) {
		this.buchID = buchID;
		this.autor =  autor;
		this.titel = titel;
	}
}
