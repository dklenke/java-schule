package de.hss.klausurvorbereitung;

public class Fitness {
	private char geschlecht = 'm';
	private int alter;
	private int trainingsziel = 1;
	private String name;
	
	public Fitness(char geschlecht, int alter, int trainingsziel) {
		setGeschlecht(geschlecht);
		this.alter = alter;
		setTrainingsziel(trainingsziel);
	}
	
	public Fitness(char geschlecht, int alter, int trainingsziel, String name) {
		setGeschlecht(geschlecht);
		this.alter = alter;
		setTrainingsziel(trainingsziel);
		this.name = name;
	}
	
	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht == 'f' ? 'f' : 'm';
	}
	
	public void setTrainingsziel(int trainingsziel) {
		this.trainingsziel = trainingsziel == 2 ? 2 : 1;
	}
	
	@Override
	public String toString() {
		String g = this.geschlecht == 'f' ? "Frau" : "Mann";
		String ziel = this.trainingsziel == 2 ? "Muskelaufbau" : "Fitness";
		String output = "--- Fitnessinformationen ---\nGeschlecht: "+g+"\nAlter: "+this.alter+"\nTrainingsziel: "+ziel;
		if (this.name != null) {
			output += "\nName: " + this.name;
		}
		return output += "\n----------------------------";
	}
	
	public String zeigeBereich(int aktuelleHerzfrequenz) {
		int hz = aktuelleHerzfrequenz;
		int maxFreq = this.geschlecht == 'f' ? 226 - this.alter : 220 - this.alter;
		
		if (hz > maxFreq * 0.9) {return "Warnstufe";}
		else if (isBetween(hz, maxFreq * 0.8, maxFreq * 0.9)) {return this.trainingsziel == 1 ? "zu hoch" : "Muskelaufbau";		}
		else {
			if (this.trainingsziel == 2) {return "zu niedrig";}
			else {
				if (isBetween(hz, maxFreq * 0.5, maxFreq * 0.8)) {return "Fitnessbereich";}
				else {return "zu niedrig";}
			}
		}
	}
	
	private boolean isBetween (int num, double lower, double upper) {
		if (num <= upper && num >= lower) {
			return true;
		}
		return false;
	}
}
