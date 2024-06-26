package raumschiffspiel;

import java.util.ArrayList;

public class Handelsstation {

    private String name;
    private ArrayList<Ladung> ladungen;

    private ArrayList verbesserungen;


    public Handelsstation(String name) {
        this.name = name;
        this.ladungen = new ArrayList<>();
    }

    public void addLadung(Ladung ladung) {
        ladungen.add(ladung);
    }

    public void removeLadung(Ladung ladung) {
        ladungen.remove(ladung);
    }

    public void zeigeLadungen() {
        for (Ladung ladung : ladungen) {
            System.out.println(ladung.name);
        }
    }
}