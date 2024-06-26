package raumschiffspiel;

import java.util.ArrayList;
import java.util.Random;

public class Asteroidenfeld {

    private static int gefahrenpotential;
    private int[] koordinaten;

    public Asteroidenfeld(int gefahrenpotential, int x, int y) {
        this.gefahrenpotential = gefahrenpotential;
        this.koordinaten = new int[]{x, y};
    }

    public static int getGefahrenpotential() {
        return gefahrenpotential;
    }

    public int[] getKoordinaten() {
        return koordinaten;
    }



public static boolean Ausweichmanöver() {
    int Erfahrung = Kapitaen.getErfahrung();
    Random random = new Random();
    int zufallszahl = random.nextInt(100);

    if (gefahrenpotential < Erfahrung + zufallszahl) {
        return true;
    } else {
        return false;
    }
}



}