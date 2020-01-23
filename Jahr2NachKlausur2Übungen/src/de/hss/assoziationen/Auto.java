package de.hss.assoziationen;

public class Auto {
	private String model;
	private String farbe;
	
	public Auto(String model, String farbe) {
		this.model = model;
		this.farbe = farbe;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getFarbe() {
		return this.farbe;
	}
}
