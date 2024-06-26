package raumschiffspiel;

import java.util.ArrayList;

public class Sonnensystem {
    public static ArrayList<Raumschiff> raumschiffe = new ArrayList<>();
    private static ArrayList<Planet> planeten = new ArrayList<>();
    public static ArrayList<Asteroidenfeld> asteroidenfelder = new ArrayList<>();
    public static ArrayList<GegnerischesRaumschiff> GegnerischesRaumschiff = new ArrayList<>();

    public static ArrayList<Raumschiff> getRaumschiffe() {
        return raumschiffe;
    }

    public static ArrayList<Planet> getPlaneten() {
        return planeten;
    }

    public static ArrayList<Asteroidenfeld> getAsteroidenfelder() {
        return asteroidenfelder;
    }

    public static ArrayList<GegnerischesRaumschiff> getGegnerischeRaumschiffe() {
        return GegnerischesRaumschiff;
    }

    public static void addRaumschiff(Raumschiff raumschiff) {
        raumschiffe.add(raumschiff);
    }

    public static void addGegnerischesRaumschiff(GegnerischesRaumschiff gegnerischesRaumschiff) {
        GegnerischesRaumschiff.add(gegnerischesRaumschiff);
    }

    public static void addPlanet(Planet planet) {
        planeten.add(planet);
    }

    public static void addAsteroidenfeld(Asteroidenfeld asteroidenfeld) {
        asteroidenfelder.add(asteroidenfeld);
    }
}
