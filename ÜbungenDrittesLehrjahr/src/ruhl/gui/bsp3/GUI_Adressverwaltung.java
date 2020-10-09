package ruhl.gui.bsp3;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class GUI_Adressverwaltung extends JFrame implements WindowListener {

	private JPanel eingabefelder, knoepfe, leftPanel, rightPanel, knopfTop, knopfBot;
	private JLabel vorLabel, nachLabel, strasLabel, wohnLabel, mailLabel, teleLabel, pageCounter, emptyLabel;
	private JTextArea vorText, nachText, strasText, wohnText, mailText, teleText;
	private JButton leftBtn, rightBtn, speichern, loeschen, hinzu, saveUndClose;

	private int currentEntry = 0;
	private ArrayList<HashMap<String, String>> dataEntries = loadDataEntries();

	// Startpunkt
	public static void main(String[] args) {
		new GUI_Adressverwaltung();
	}

	// Konstruktor
	public GUI_Adressverwaltung() {
		setTitle("Adressverwaltung"); // Titel setzen.
		setSize(500, 300); // Größe x, y in Pixel festlegen,
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Anwendung schließt wenn man oben rechts schließen drückt.
		addWindowListener(this);

		addTextFields();
		addNavBtns();
		addKnoepfe();

		hinzu.addActionListener(e -> {
			HashMap<String, String> newEntry = new HashMap<String, String>() {
				{
					put("vorname", vorText.getText());
					put("nachname", nachText.getText());
					put("strasse", strasText.getText());
					put("wohnort", wohnText.getText());
					put("email", mailText.getText());
					put("telefon", teleText.getText());
				}
			};
			dataEntries.add(newEntry);
			updateDataEntriesCounter();
			clearInputFields();
			currentEntry = 0;
			updateDataEntriesCounter();
		});

		rightBtn.addActionListener(e -> {
			if (currentEntry == dataEntries.size() - 1) {
				System.out.println("Can't go to higher than max entrys.");
			} else {
				currentEntry++;
				updateDataEntriesCounter();
				loadCurrentDataEntry(dataEntries.get(currentEntry));
			}
		});

		leftBtn.addActionListener(e -> {
			if (currentEntry == 0) {
				System.out.println("Can't go lower than min entrys.");
			} else {
				currentEntry--;
				updateDataEntriesCounter();
				loadCurrentDataEntry(dataEntries.get(currentEntry));
			}
		});

		saveUndClose.addActionListener(e -> {
			writeToFile();
			dispose();
			System.exit(0);
		});
		
		loeschen.addActionListener(e -> {
			if (currentEntry != 0) {
				dataEntries.remove(currentEntry);
				currentEntry = 0;
				clearInputFields();
				updateDataEntriesCounter();
			}
		});

		Thread thread = new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					checkHinzuSpeicherBtn();
					checkLoeschBtn();
				}
			}

		});
		thread.start();

		setVisible(true);
	}

	private void addKnoepfe() {
		knoepfe = new JPanel(new GridLayout(2, 1, 5, 10));
		knopfBot = new JPanel();
		knopfTop = new JPanel();

		speichern = new JButton("Änderungen speichern");
		speichern.setFocusPainted(false);
		loeschen = new JButton("Adresse löschen");
		loeschen.setFocusPainted(false);
		hinzu = new JButton("neu Hinzufügen");
		hinzu.setFocusPainted(false);
		saveUndClose = new JButton("Anwendung schließen und speichern");
		saveUndClose.setFocusPainted(false);

		knopfTop.add(speichern);
		knopfTop.add(loeschen);
		knopfTop.add(hinzu);
		knopfBot.add(saveUndClose);

		knoepfe.add(knopfTop, BorderLayout.PAGE_START);
		knoepfe.add(knopfBot, BorderLayout.PAGE_END);
		add(knoepfe, BorderLayout.PAGE_END);
	}

	private void addNavBtns() {
		leftPanel = new JPanel(new GridBagLayout());
		rightPanel = new JPanel(new GridBagLayout());
		pageCounter = new JLabel("0/0");
		pageCounter.setHorizontalAlignment(JLabel.RIGHT);
		pageCounter.setBorder(new EmptyBorder(0, 0, 0, 10));
		updateDataEntriesCounter();
		emptyLabel = new JLabel("");

		leftBtn = new JButton("<");
		leftBtn.setFocusPainted(false);
		rightBtn = new JButton(">");
		rightBtn.setFocusPainted(false);

		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.ipady = 0; // reset to default
		gc.weighty = 1.0; // request any extra vertical space
		gc.anchor = GridBagConstraints.PAGE_END; // bottom of space
		gc.insets = new Insets(10, 10, 30, 30); // top padding
		gc.gridx = 1; // aligned with button 2
		gc.gridwidth = 2; // 2 columns wide
		gc.gridy = 2; // third row
		leftPanel.add(leftBtn, gc);
		gc.insets = new Insets(10, 30, 30, 10);
		rightPanel.add(rightBtn, gc);

		gc.anchor = GridBagConstraints.PAGE_START;
		leftPanel.add(emptyLabel, gc);
		rightPanel.add(pageCounter, gc);

		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
	}

	private void addTextFields() {
		eingabefelder = new JPanel(new GridLayout(6, 2, 5, 5));

		vorLabel = new JLabel("Vorname:");
		vorText = new JTextArea();
		vorText.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		vorText.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
		nachLabel = new JLabel("Nachname:");
		nachText = new JTextArea();
		nachText.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		nachText.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
		strasLabel = new JLabel("Straße:");
		strasText = new JTextArea();
		strasText.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		strasText.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
		wohnLabel = new JLabel("Wohnort:");
		wohnText = new JTextArea();
		wohnText.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		wohnText.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
		mailLabel = new JLabel("E-mail:");
		mailText = new JTextArea();
		mailText.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		mailText.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
		teleLabel = new JLabel("Telefonnummer:");
		teleText = new JTextArea();
		teleText.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		teleText.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);

		eingabefelder.add(vorLabel);
		eingabefelder.add(vorText);
		eingabefelder.add(nachLabel);
		eingabefelder.add(nachText);
		eingabefelder.add(strasLabel);
		eingabefelder.add(strasText);
		eingabefelder.add(wohnLabel);
		eingabefelder.add(wohnText);
		eingabefelder.add(mailLabel);
		eingabefelder.add(mailText);
		eingabefelder.add(teleLabel);
		eingabefelder.add(teleText);

		add(eingabefelder);
	}

	private void checkLoeschBtn() {
		if (currentEntry != 0) {
			loeschen.setEnabled(true);
		} else {
			loeschen.setEnabled(false);
		}
	}

	private void clearInputFields() {
		vorText.setText("");
		nachText.setText("");
		strasText.setText("");
		wohnText.setText("");
		mailText.setText("");
		teleText.setText("");
	}

	private void checkHinzuSpeicherBtn() {
		if (checkAllFieldsSet()) {
			hinzu.setEnabled(true);
			if (currentEntry != 0) {
				speichern.setEnabled(true);
			}
		} else {
			hinzu.setEnabled(false);
			speichern.setEnabled(false);
		}
	}

	private void updateDataEntriesCounter() {
		int val1 = currentEntry;
		int val2 = dataEntries.size() - 1;
		pageCounter.setText(val1 + "/" + val2);
	}

	private ArrayList<HashMap<String, String>> loadDataEntries() {
		String filePath = "savedata.txt";
		ArrayList<HashMap<String, String>> loadedDataEntrys = new ArrayList<HashMap<String, String>>();
		try {
			String line;
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			ArrayList<String> fileOut = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				fileOut.add(line);
			}
			reader.close();
			HashMap<String, String> map = new HashMap<String, String>();
			for (String entry : fileOut) {
				if (!entry.startsWith("-")) {
					String[] parts = entry.split(":", 2);
					if (parts.length >= 2) {
						String key = parts[0];
						String value = parts[1];
						map.put(key, value);
					} else {
						System.out.println("ignoring line: " + entry);
					}
				} else {
					loadedDataEntrys.add(map);
					map = new HashMap<String, String>();
				}
			}
			System.out.println(loadedDataEntrys);
			return loadedDataEntrys;
		} catch (IOException e) {
			System.out.println("No load file found.");
			ArrayList<HashMap<String, String>> blankList = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> emptyEntry = new HashMap<String, String>() {
				{
					put("vorname", "");
					put("nachname", "");
					put("strasse", "");
					put("wohnort", "");
					put("email", "");
					put("telefon", "");
				}
			};
			blankList.add(emptyEntry);
			return blankList;
		}
	}

	private void loadCurrentDataEntry(HashMap<String, String> currentEntry) {
		vorText.setText(currentEntry.get("vorname"));
		nachText.setText(currentEntry.get("nachname"));
		strasText.setText(currentEntry.get("strasse"));
		wohnText.setText(currentEntry.get("wohnort"));
		mailText.setText(currentEntry.get("email"));
		teleText.setText(currentEntry.get("telefon"));
	}

	private boolean checkAllFieldsSet() {
		if (!vorText.getText().equals("") && !nachText.getText().equals("") && !strasText.getText().equals("")
				&& !wohnText.getText().equals("") && !mailText.getText().equals("") && !teleText.getText().equals("")) {
			return true;
		}
		return false;
	}

	private void writeToFile() {
		try {
			File f = new File("savedata.txt");
			if (!f.exists()) {
				f.createNewFile();
			}
			PrintWriter myWriter = new PrintWriter("savedata.txt");
			for (HashMap<String, String> m : dataEntries) {
				for (String key : m.keySet()) {
					myWriter.write(key + ":" + m.get(key) + "\n");
				}
				myWriter.write("----------\n");
			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		int option = JOptionPane.showOptionDialog(GUI_Adressverwaltung.this, "Sind sie sicher, dass sie schließen wollen ohne zu speichern?", "Exit Dialog",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if( option == JOptionPane.YES_OPTION ) {  
            System.exit( 0 );  
        } 

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
