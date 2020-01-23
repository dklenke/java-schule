package de.hss.assoziationen;

public class Person {
	private String name;
	private Auto pkw;
	
	public Person(String name) {
		this.name = name;
	}
	
	public void fahren(Auto pkw) {
		this.pkw = pkw;
	}
	
	public void aussteigen() {
		this.pkw = null;
	}
	
	public String info() {
		if (this.pkw != null) {
			return this.name + " fährt gerade ein " + pkw.getFarbe() + "en " + pkw.getModel() + ".";
		}
		else {
			return this.name + " fährt gerade nicht Auto.";
		}
		
	}
}
