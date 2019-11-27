package de.hss.konstruktoren;

public class Steuern {
    private String steuernummer;
    private int einkommen;
    private boolean verheiratet;
    private int anzahlKinder;

    public Steuern(String steuernummer, int einkommen, boolean verheiratet, int anzahlKinder) {
        this.steuernummer = steuernummer;
        setEinkommen(einkommen);
        setVerheiratet(verheiratet);
        setAnzahlKinder(anzahlKinder);
    }

    public Steuern(String steuernummer, int einkommen) {
        this.steuernummer = steuernummer;
        this.einkommen = einkommen;
        this.verheiratet = false;
        this.anzahlKinder = 0;
    }

    public void setEinkommen(int einkommen) {
        if(einkommen<0) {
            this.einkommen = 0;
        }
        else {
            this.einkommen = einkommen;
        }
    }

    public void setVerheiratet(boolean verheiratet) {
        this.verheiratet = verheiratet;
    }

    public void setAnzahlKinder(int anzahlKinder) {
        this.anzahlKinder = anzahlKinder < 0 ? 0 : Math.min(anzahlKinder, 15);
    }

    public String getInfo() {
        String heirat = this.verheiratet == true ? "Ja" : "Nein";
        int freibetrag = this.verheiratet ? 7500 : 5000;
        for (int i=0;i<this.anzahlKinder;i++){freibetrag += 1000;}
        double zuVersteuern = this.einkommen - freibetrag;
        double zuZahlen = zuVersteuern > 60000 ? (zuVersteuern - 60000) * 0.4 + 30000 * 0.3 + 30000 * 0.2 :
                zuVersteuern > 30000 ? (zuVersteuern - 30000) * 0.3 + 30000 * 0.2 : zuVersteuern * 0.2;
        zuZahlen = Math.floor(zuZahlen * 100) / 100;
        return"Steuernummer: " + this.steuernummer + "\nEinkommen: " + this.einkommen + "\nVerheiratet: " + heirat +
                "\nanrechenbare Kinder: " + this.anzahlKinder + "\nzu versteuerndes Einkommen: " + zuVersteuern +
                " D$\nSteuer: " + String.valueOf(zuZahlen);
    }
}
