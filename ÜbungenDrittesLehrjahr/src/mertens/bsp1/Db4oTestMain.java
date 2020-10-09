package mertens.bsp1;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

public class Db4oTestMain {
	public static void main(String[] args) {
		ObjectContainer db = Db4o.openFile("");
		Schueler schueler = new Schueler("Jürgen", "Mertens");
	}
}
