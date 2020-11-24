package ruhl.gui.bsp3;

import java.util.HashMap;

public class Steuerung {
	public void hinzufuegen(GUI_Adressverwaltung gui) {
		HashMap<String, String> newEntry = new HashMap<String, String>() {
			{
				put("vorname", gui.vorText.getText());
				put("nachname", gui.nachText.getText());
				put("strasse", gui.strasText.getText());
				put("wohnort", gui.wohnText.getText());
				put("email", gui.mailText.getText());
				put("telefon", gui.teleText.getText());
			}
		};
		gui.dataEntries.add(newEntry);
		updateDataEntriesCounter(gui);
		clearInputFields(gui);
		gui.currentEntry = 0;
		updateDataEntriesCounter(gui);
	}
	
	private void updateDataEntriesCounter(GUI_Adressverwaltung gui) {
		int val1 = gui.currentEntry;
		int val2 = gui.dataEntries.size() - 1;
		gui.pageCounter.setText(val1 + "/" + val2);
	}
	
	private void clearInputFields(GUI_Adressverwaltung gui) {
		gui.vorText.setText("");
		gui.nachText.setText("");
		gui.strasText.setText("");
		gui.wohnText.setText("");
		gui.mailText.setText("");
		gui.teleText.setText("");
	}
}
