package raumschiffspiel;

public class Ladung {

    public String name;
    public int einheit;
    public int gewicht;
    public int wert;


    public Ladung(String name, int einheit, int gewicht, int wert) {
        this.name = name;
        this.einheit = einheit;
        this.gewicht = gewicht;
        this.wert = wert;
    }


    public Ladung() {
        this.name = "Unbekannt";
        this.einheit = 0;
    }

    public String getName() {
        return name;
    }

    public int getEinheit() {
        return einheit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEinheit(int einheit) {
        this.einheit = einheit;
    }


}
