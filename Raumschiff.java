package raumschiffspiel;

import java.util.ArrayList;
import java.util.Scanner;

public class Raumschiff {
    private final String name;
    private int posX;
    private int posY;
    private Kapitaen kapitaen;
    private final int anzahlLadungen;
    private Ladung ladung;
    private final String typ;
    private final ArrayList verbesserungen;
    public static int Waffenstaerke;

    private int Lebenspunkte;

    public Raumschiff(String name, int posX, int posY, Kapitaen kapitaen, int anzahlLadungen, int Waffenstaerke, ArrayList verbesserungen, int Lebenspunkte) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.kapitaen = kapitaen;
        this.anzahlLadungen = anzahlLadungen;
        this.ladung = null;
        this.typ = "Raumschiff";
        this.Waffenstaerke = Waffenstaerke;
        this.verbesserungen = new ArrayList();
        this.Lebenspunkte = Lebenspunkte;
    }


    public String getName() {
        return name;
    }

    public void setkapitaen(Kapitaen kapitaen) {
        this.kapitaen = kapitaen;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Kapitaen getKapitaen() {
        return kapitaen;
    }

    public Ladung getLadung() {
        return ladung;
    }

    public void addLadung(Ladung ladung) {
        this.ladung = ladung;
    }

    public static int getWaffenstaerke() {
        return Waffenstaerke;
    }

    public void setWaffenstaerke() {
        Waffenstaerke += 5;
    }

    public void addVerbesserung(String verbesserung) {
        this.verbesserungen.add(verbesserung);
    }

    public void removeVerbesserung(String verbesserung) {
        this.verbesserungen.remove(verbesserung);
    }

    public int getLebenspunkte() {
        return Lebenspunkte;
    }

    public void setLebenspunkte(int Lebenspunkte) {
        this.Lebenspunkte = Lebenspunkte;
    }

    public void zeigeVerbesserungen() {
        for (Object verbesserung : verbesserungen) {
            System.out.println(verbesserung);
        }
    }

    public void zeigeLadung() {
        if (this.ladung != null) {
            System.out.println("Ladung: " + this.ladung.getName());
        } else {
            System.out.println("Keine Ladung an Bord.");
        }
    }

    public void zeigeStatus() {
        System.out.println("Name: " + this.name);
        System.out.println("Position: " + this.posX + ", " + this.posY);
        System.out.println("Kapitän: " + this.kapitaen.getName());
        System.out.println("Anzahl Ladungen: " + this.anzahlLadungen);
        System.out.println("Waffenstärke: " + Waffenstaerke);
        System.out.println("Verbesserungen: ");
        this.zeigeVerbesserungen();
        this.zeigeLadung();
    }

    public void hit(int damage) {
        this.Lebenspunkte -= damage;
        if (this.Lebenspunkte <= 0) {
            System.out.println("Dein Raumschiff " + this.name + " wurde zerstört!");
        }
    }

    public Ladung removeLadung() {
        Ladung removedLadung = this.ladung;
        this.ladung = null;
        return removedLadung;
    }

    public void fliegen(char richtung) {
        switch (richtung) {
            case 'W':
            case 'w':
                posY++;
                break;
            case 'A':
            case 'a':
                posX--;
                break;
            case 'S':
            case 's':
                posY--;
                break;
            case 'D':
            case 'd':
                posX++;
                break;
            case 'Q':
            case 'q':
                scanEnvironment();
                break;
            default:
                System.out.println("Ungültige Richtung. Bitte verwenden Sie W, A, S oder D.");
                break;
        }
    }


    public boolean pruefeKoordinaten(int x, int y) {
        return this.posX == x && this.posY == y;
    }

    public boolean istInDerNaehe(int x, int y) {
        int toleranz = 4; // Objekte innerhalb von 4 Einheiten werden als "in der Nähe" betrachtet
        return Math.abs(this.posX - x) <= toleranz && Math.abs(this.posY - y) <= toleranz;
    }

    int scanCounter = 0;
    Scanner scanner = new Scanner(System.in);

    public void scanEnvironment() {
        if (scanCounter < 5) {
            System.out.println("Wollen sie die Umgebung scannen (J/N)?");
            char scanAntwort = scanner.next().charAt(0);
            if (scanAntwort == 'J' || scanAntwort == 'j') {

                for (GegnerischesRaumschiff Gegner : Sonnensystem.getGegnerischeRaumschiffe()) {
                    if (this.istInDerNaehe(Gegner.getPosX(), Gegner.getPosY())) {
                        System.out.println("Ein feindliches Raumschiff mit dem Namen " + Gegner.getName() + " ist in der Nähe.");
                    }
                }
                for (Planet planet : Sonnensystem.getPlaneten()) {
                    if (this.istInDerNaehe(planet.getKoordinaten()[0], planet.getKoordinaten()[1])) {
                        System.out.println("Ein Planet mit dem Namen " + planet.getName() + " ist in der Nähe.");
                    }
                }
                for (Asteroidenfeld asteroidenfeld : Sonnensystem.getAsteroidenfelder()) {
                    if (this.istInDerNaehe(asteroidenfeld.getKoordinaten()[0], asteroidenfeld.getKoordinaten()[1])) {
                        System.out.println("Ein Asteroidenfeld ist in der Nähe.");
                    }

                }

                scanCounter++;
            }
        }else {
            System.out.println("Sie haben die Umgebung nicht gescannt.");
        }
    }
}


