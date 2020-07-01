package de.hss.sae.ga2;

import java.util.ArrayList;

public class Praxis {
	private ArrayList<Behandlung> behandlungen = new ArrayList<Behandlung>();
	private ArrayList<Patient> patienten = new ArrayList<Patient>();

	public ArrayList<Patient> getPatient(String name) {
		ArrayList<Patient> gesuchtepatienten = new ArrayList<Patient>();
		for (Patient p : this.patienten) {
			if (p.getName().equals(name)) {
				gesuchtepatienten.add(p);
			}
		}
		return gesuchtepatienten;
	}

	public ArrayList<Behandlung> getBehandlung(String kvNummer) {
		ArrayList<Behandlung> gesuchtebehandlungen = new ArrayList<Behandlung>();
		for (Behandlung b : this.behandlungen) {
			if (b.getKvNummer().equals(kvNummer)) {
				gesuchtebehandlungen.add(b);
			}
		}
		return gesuchtebehandlungen;
	}

	public int anzBehandlung(String kvNummer) {
		return getBehandlung(kvNummer).size();
	}

	public String zeigePatienten(int anzahlBehandlungen) {
		String out = "";
		for (Patient p : this.patienten) {
			int pCount = 0;
			for (Behandlung b : this.behandlungen) {
				if (b.getKvNummer().equals(p.getKvNummer())) {
					pCount++;
				}
			}
			if (pCount >= anzahlBehandlungen) {
				out += p.getName() + ", ";
			}
			
		}
		if (out.length() > 0) {
			out = out.substring(0, out.length() - 2);
		}
		return out;
	}

	public void addBehandlung(Behandlung b) {
		this.behandlungen.add(b);
	}
	
	public double ermittleKosten() {
		double alleKosten = 0.0;
		for (Behandlung b : this.behandlungen) {
			alleKosten += b.getKosten();
		}
		return alleKosten;
	}
	
	public void addPatient(Patient p) {
		this.patienten.add(p);
	}
}
