package de.hss.konstruktoren;

public class Student {
    private String name;
    private int matrikelnummer;
    private int studienfach = 0;
    private int geburtsjahr = 0;
    private double punkteSeminar;
    private String[] faecher = {"---", "Mathematik", "Informatik", "Architektur", "Wirtschaftswissenschaften", "Biologie", "Geschichte", "Germanistik", "Politologie", "Physik"};

    public Student(String name, int matrikelnummer) {
        this.name = name;
        setMatrikelnummer(matrikelnummer);
    }

    public Student(String name, int matrikelnummer, int studienfach, int geburtsjahr) {
        this.name = name;
        setMatrikelnummer(matrikelnummer);
        setStudienfach(studienfach);
        setGeburtsjahr(geburtsjahr);
    }

    public double seminararbeit(int schriftlich, int muendlich) {
        this.punkteSeminar = (schriftlich * 3.0 + muendlich * 2) / 5;
        return this.punkteSeminar;
    }

    public void setMatrikelnummer(int matrikelnummer) {
        int lang = String.valueOf(matrikelnummer).length();
        boolean ungerade = matrikelnummer % 2 != 0;
        if (ungerade && lang == 5) {
            this.matrikelnummer = matrikelnummer;
        }
    }

    public void setStudienfach(int studienfach) {
        if (studienfach > 0 && studienfach < 10) {
            this.studienfach = studienfach;
        }
    }

    public void setGeburtsjahr(int geburtsjahr) {
        this.geburtsjahr = geburtsjahr < 1920 ? 1920 : Math.min(geburtsjahr, 2002);
    }

    @Override
    public String toString() {
        String gebjahr = this.geburtsjahr == 0 ? "---" : String.valueOf(this.geburtsjahr);
        String semarb = this.punkteSeminar == 0 ? "---" : String.valueOf(this.punkteSeminar);
        return "Name: " + this.name + "\nMatrikelnummer: " + this.matrikelnummer + "\nStudienfach " + faecher[this.studienfach] +
                "\nGeburtsjahr: " + gebjahr + "\nPunkte Seminararbeit: " + semarb + "\n";
    }
}
