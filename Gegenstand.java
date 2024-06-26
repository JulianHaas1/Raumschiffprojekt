package raumschiffspiel;

public class Gegenstand {

private String typ;
    private int faktor;

    public Gegenstand(String typ, int faktor) {
        this.typ = typ;
        this.faktor = faktor;
    }

    public Gegenstand() {
        this.typ = "Unbekannt";
        this.faktor = 0;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getFaktor() {
        return faktor;
    }

    public void setFaktor(int faktor) {
        this.faktor = faktor;
    }

    public String toString() {
        return "Typ: " + typ + ", Faktor: " + faktor;
    }


}
