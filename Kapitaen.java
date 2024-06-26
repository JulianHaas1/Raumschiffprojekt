package raumschiffspiel;

import static raumschiffspiel.Raumschiff.*;

public class Kapitaen {


    private String name;
    private int charisma;
    private static int erfahrung;
    private static int geld;

    private Raumschiff raumschiff;

    public Kapitaen(String name, int charisma, int erfahrung, int geld, Raumschiff raumschiff) {
        this.name = name;
        this.charisma = charisma;
        this.erfahrung = erfahrung;
        this.geld = geld;
        this.raumschiff = raumschiff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharisma() {
        return charisma;
    }

    public boolean diplomatischeVerhandlung() {
        int zufall = (int)(Math.random() * 10) + 1;
        if (zufall <= this.erfahrung + this.charisma) {
            System.out.println("Die diplomatischen Verhandlungen waren erfolgreich!");
            return true;
        } else {
            System.out.println("Die diplomatischen Verhandlungen waren nicht erfolgreich.");
            return false;
        }
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public static int getErfahrung() {
        return Kapitaen.erfahrung;
    }

    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }

    public void levelUp() {
        this.erfahrung++;
        if (this.erfahrung == 5) {
        System.out.println(this.name + "ist ein Level aufgestiegen!");
        raumschiff.setWaffenstaerke();
        this.erfahrung = 0;
        }
    }
    public static int getGeld() {
        return Kapitaen.geld;
    }

    public void setGeld(int betrag)
    {
        this.geld=betrag;
    }

}