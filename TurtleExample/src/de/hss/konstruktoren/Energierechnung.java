package de.hss.konstruktoren;

public class Energierechnung {
	private double energieverbrauch;
	private String monat;
	private String kdnr;
	private int tarif = 1;
	
	public Energierechnung(double energieverbrauch, String monat, String kdnr, int tarif) {
		setEnergieverbrauch(energieverbrauch);
		setMonat(monat);
		setKdnr(kdnr);
		setTarif(tarif);
	}

	public double getEnergieverbrauch() {
		return energieverbrauch;
	}

	public void setEnergieverbrauch(double energieverbrauch) {
		this.energieverbrauch = energieverbrauch;
	}

	public String getMonat() {
		return monat;
	}

	public void setMonat(String monat) {
		this.monat = monat;
	}

	public String getKdnr() {
		return kdnr;
	}

	public void setKdnr(String kdnr) {
		this.kdnr = kdnr;
	}

	public int getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		if (tarif <= 1) {
			this.tarif = 1;
		}
		else if (tarif >= 2) {
			this.tarif = 2;
		}
	}
	
	public String getRechnung() {
		String out = "Monat: " + this.monat + "\nKundennummer: " + this.kdnr + "\nMonatsgesamtverbrauch(kWh): "
				+ this.energieverbrauch + "\nRechnungsbetrag incl. MWST: ";
		if (this.getTarif() == 1) {
			return out + String.valueOf(Math.floor((2 + 0.21 * this.energieverbrauch) * 100) / 100) + " (Tarif 1)";
		}
		else {
			return out + String.valueOf(Math.floor((5 + 0.14 * this.energieverbrauch) * 100) / 100) + " (Tarif 2)";
		}
	}
}
