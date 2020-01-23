package de.hss.assoziationen;

public class Singleton {
	private static Singleton single = new Singleton();
	public int test = 1;
	
	private Singleton(){}
	
	public void increase() {
		this.test++;
	}
	
	public static Singleton getInstance() {
		return Singleton.single;
	}
}
