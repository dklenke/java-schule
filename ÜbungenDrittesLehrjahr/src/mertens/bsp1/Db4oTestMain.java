package mertens.bsp1;

import java.util.List;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

public class Db4oTestMain implements Util{

	public static void main(String[] args) {

		ObjectContainer db = Db4o.openFile("C:\\Users\\Dario\\dbtest\\db4oTest.db");
		try {

			deleteDB(db);
			populateDB(db);

//			// Alle Datensätze ausgeben -----------------------------------------------//
//			List<Schueler> s = db.query(Schueler.class);
//			listSchueler("Alle Datensätze:", s);
//
//			// Native Query -- alle Schüler, deren Nachname mit M beginnt -------------//
//			s = db.query(new Predicate<Schueler>() {
//				public boolean match(Schueler schueler) {
//					return schueler.getNachname().startsWith("M");
//				}
//			});
//			listSchueler("Alle Datensätze deren Nachname mit M startet:", s);
//
//			s = db.query(new Predicate<Schueler>() {
//				public boolean match(Schueler schueler) {
//					return Util.containsIgnoreCase(schueler.getNachname(), "merT");
//				}
//			});
//			listSchueler("Alle Datensätze deren Nachname \"merT\" enthält:", s);
//			
//			s = db.query(new Predicate<Schueler>() {
//				public boolean match(Schueler schueler) {
//					//return schueler.getNachname().matches("^((?!.*von.*).*[- ]+.*)$");
//					return altDoppelNameCheck(schueler.getNachname());
//				}
//			});
//			listSchueler("Alle Datensätze deren Nachname ein Doppelnachname ist:", s);
			leihen("Mark", 9, db);
			List<Ausleihe> s = db.query(Ausleihe.class);
			System.out.println("Alle Ausleihen: " + s.size());
			for (int i = 0; i < s.size(); i++) {
				System.out.println(s.get(i).toString());
			}
			

		} finally {
			db.close();
		}
		

	}

	public static void listSchueler(String header, List<Schueler> s) {

		System.out.println(header + " " + s.size());
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i).toString());
		}
	}

	private static void populateDB(ObjectContainer db) {
		// Datensätze anlegen -----------------------------------------------------//
		Klasse e3fiae1 = new Klasse("E3FIAE1");
		Klasse e3fiae2 = new Klasse("E3FIAE2");

		db.store(new Schueler("Mark", "Schrieb", e3fiae1));
		db.store(new Schueler("Jürgen", "Mertens", e3fiae1));
		db.store(new Schueler("Michael", "Maier", e3fiae2));
		db.store(new Schueler("Michael", "Mayer-Mellenhof", e3fiae2));
		db.store(new Schueler("Sabine", "Leutheusser Schnarrenberg", e3fiae1));
		db.store(new Schueler("Johann Wolfgang", "von Goethe", e3fiae1));
		db.store(new Schueler("Manfred", "Prof. Dr. med. Dr. phil. Spitzer", e3fiae1));
		db.store(new Schueler("Karl", "Prof. Winfried-Ehrmann", e3fiae1));
		
		Schueler fmaier = new Schueler("Frank", "Maier", e3fiae2);
		Schueler mborta = new Schueler("Melanie", "Borta", e3fiae2);
		db.store(fmaier);
		db.store(mborta);
		
		db.store(new Buch(8, "Das Kapital", "Karl Marx und Friedrich Engels"));
		db.store(new Buch(9, "Der Wohlstand der Nationen", "Adam Smith"));
		db.store(new Buch(10, "What is a soviet?", "Juan Posadas"));
		db.commit();
	}

	private static void deleteDB(ObjectContainer db) {
		// Alle Datensätze löschen ----------------------------------------------- //
		Query query = db.query();
		ObjectSet set = query.execute();

		while (set.hasNext()) {
			db.delete(set.next());
		}
		db.commit();
	}
	
	private static boolean altDoppelNameCheck(String name) {
		if (name.contains("-")) {
			return true;
		}
		else {
			int it = 0;
			String[] teile = name.split(" ");
			for (String teil : teile) {
				if (!teil.endsWith(".") && Character.isUpperCase(teil.charAt(0))) {
					it++;
				}
			}
			return it>1;
		}
	}
	
	private static void leihen(String vorname, int bid, ObjectContainer db) {
		ObjectSet<Object> searchSchueler = db.queryByExample(new Schueler(vorname, null, null));
		ObjectSet<Object> searchBuch = db.queryByExample(new Buch(bid, null, null));
		if (searchSchueler.hasNext()) {
			if (searchBuch.hasNext()) {
				Ausleihe neueAusleihe = new Ausleihe((Buch) searchBuch.next(), (Schueler) searchSchueler.next(), 6);
				db.store(neueAusleihe);
				db.commit();
			}
		}	
	}
}
