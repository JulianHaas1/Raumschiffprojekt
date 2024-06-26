package raumschiffspiel;


import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;



public class Spiel {
    public static void main(String[] args) {
        // Initialisierung
        Random random = new Random();
        int x = 0;
        int y = 0;
        int x1 = 2 + random.nextInt(13);
        int y1 = 2 + random.nextInt(13);
        int x2 = 2 + random.nextInt(13);
        int y2 = 2 + random.nextInt(13);
        int x3 = 2 + random.nextInt(13);
        int y3 = 2 + random.nextInt(13);
        int[] koordinaten1 = {x1, y1};
        int[] koordinaten2 = {x2, y2};
        int[] koordinaten3 = {x3, y3};
        int zuege = 0;
        int endbossSpawnZeit = 30;
        boolean endbossdead = false;
        Raumschiff eosNova = new Raumschiff("Eos Nova", x, y, null, 3, 10, new ArrayList<>(), 200);
        Kapitaen alexiaNova = new Kapitaen("Alexia Nova", 7, 10, 812, eosNova);
        eosNova.setkapitaen(alexiaNova);

        GegnerischesRaumschiff gegner1 = new GegnerischesRaumschiff("T-36 Fighter", 5, 5, 2, 40, 100);
        GegnerischesRaumschiff gegner2 = new GegnerischesRaumschiff("C-60 Fighter", 11, 10, 10, 55, 50);
        GegnerischesRaumschiff gegner3 = new GegnerischesRaumschiff("X-12 Fighter", 13, 11, 4, 98, 30);
        GegnerischesRaumschiff gegner4 = new GegnerischesRaumschiff("Z-99 Fighter", 8, 1, 10, 10, 40);
        GegnerischesRaumschiff gegner5 = new GegnerischesRaumschiff("Y-77 Fighter", 5, 2, 15, 20, 20);
        GegnerischesRaumschiff gegner6 = new GegnerischesRaumschiff("A-01 Fighter", 3, 3, 1, 60, 100);
        GegnerischesRaumschiff gegner7 = new GegnerischesRaumschiff("B-02 Fighter", 4, 4, 4, 30, 70);

        Sonnensystem.addGegnerischesRaumschiff(gegner1);
        Sonnensystem.addGegnerischesRaumschiff(gegner2);
        Sonnensystem.addGegnerischesRaumschiff(gegner3);
        Sonnensystem.addGegnerischesRaumschiff(gegner4);
        Sonnensystem.addGegnerischesRaumschiff(gegner5);
        Sonnensystem.addGegnerischesRaumschiff(gegner6);
        Sonnensystem.addGegnerischesRaumschiff(gegner7);


        Sonnensystem.addRaumschiff(eosNova);

        Ladung ladung1 = new Ladung("Gold", 12, 100, 1000);
        Ladung ladung2 = new Ladung("Silber", 12, 12, 700);
        Ladung ladung3 = new Ladung("Bronze", 12, 12, 300);

        //Gegennstände
        Gegenstand gegenstand1 = new Gegenstand("Quantenkanone", 5);
        Gegenstand gegenstand2 = new Gegenstand("Dunkeltracerraketen", 10);
        Gegenstand gegenstand3 = new Gegenstand("Plasmablaster", 15);

        GalaxieObjekte galaxieObjekte = new GalaxieObjekte("Mysteriöser Komet", 15, 1, "sehr selten", gegenstand1);
        GalaxieObjekte galaxieObjekte1 = new GalaxieObjekte("Seltener Kristall", 1, 15, "selten", gegenstand2);

        Sonnensystem.getGalaxieObjekte().add(galaxieObjekte);
        Sonnensystem.getGalaxieObjekte().add(galaxieObjekte1);

        // Enschlüsselte Nachrichten
        KosmischeNachrichten Schwachstelle = new KosmischeNachrichten("Einst gekämpft, einst verloren. Vernarbtes rechtes Auge, scheint bei meiner letzten Mission verletzt worden zu sein.", 10, "geheimeInformation");
        KosmischeNachrichten SeltenerGeg = new KosmischeNachrichten("Alte Krieger, alte Waffen, altes Wissen. Alter Kristall am Rand des Sonnensystems.", 8, "geheimeInformation");
        KosmischeNachrichten Volkswissen = new KosmischeNachrichten("Der Name Xenon steht immer wieder in den alten Büchern. Ein Held aller Völker, sagen sie. Halte seinen Namen in Ehren und sie werden dich ehren.", 5, "geheimeInformation");

        Planet auroria = new Planet("Auroria", true, ladung1, koordinaten1, Schwachstelle);
        Planet solara = new Planet("Solara", false, ladung2, koordinaten2, SeltenerGeg);
        Planet ktaris = new Planet("Ktaris", true, ladung3, koordinaten3, Volkswissen);

        auroria.addLadung(ladung1);
        solara.addLadung(ladung2);
        ktaris.addLadung(ladung3);


        Sonnensystem.addPlanet(auroria);
        Sonnensystem.addPlanet(solara);
        Sonnensystem.addPlanet(ktaris);

        Asteroidenfeld asteroidenfeld6 = new Asteroidenfeld(5, 2, 1);
        Asteroidenfeld asteroidenfeld1 = new Asteroidenfeld(10, 5, 10);
        Asteroidenfeld asteroidenfeld2 = new Asteroidenfeld(15, 3, 8);
        Asteroidenfeld asteroidenfeld3 = new Asteroidenfeld(20, 11, 11);
        Asteroidenfeld asteroidenfeld4 = new Asteroidenfeld(25, 15, 1);
        Asteroidenfeld asteroidenfeld5 = new Asteroidenfeld(30, 3, 13);

        Sonnensystem.addAsteroidenfeld(asteroidenfeld1);
        Sonnensystem.addAsteroidenfeld(asteroidenfeld2);
        Sonnensystem.addAsteroidenfeld(asteroidenfeld3);
        Sonnensystem.addAsteroidenfeld(asteroidenfeld4);
        Sonnensystem.addAsteroidenfeld(asteroidenfeld5);
        Sonnensystem.addAsteroidenfeld(asteroidenfeld6);

        System.out.println("Das Spiel beginnt. Sie fliegen das Raumschiff " + eosNova.getName());
        System.out.println("Gesteuert von " + alexiaNova.getName() + " mit " + Kapitaen.getErfahrung() + " Erfahrungspunkten.");

        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        int scanCounter = 0;

        while (!gameOver) {
            // Begrenzung der Koordinaten
            if (eosNova.getPosY() > 15) {
                System.out.println("Die Gravitation zieht dich zurück in das Sonnensystem, flieg in eine andere Richtung!.");
                eosNova.setPosY(15);
            } else if (eosNova.getPosY() < 0) {
                System.out.println("Die Gravitation zieht dich zurück in das Sonnensystem, flieg in eine andere Richtung!.");
                eosNova.setPosY(0);
            } else if (eosNova.getPosX() > 15) {
                System.out.println("Die Gravitation zieht dich zurück in das Sonnensystem, flieg in eine andere Richtung!.");
                eosNova.setPosX(15);
            } else if (eosNova.getPosX() < 0) {
                System.out.println("Die Gravitation zieht dich zurück in das Sonnensystem, flieg in eine andere Richtung!.");
                eosNova.setPosX(0);
            }

            // Aktuelle Position anzeigen
            System.out.println("Aktuelle Position: X = " + eosNova.getPosX() + " Y = " + eosNova.getPosY());
            System.out.println("Bitte geben Sie eine Richtung ein (W A S D Q - Scannen):");
            char richtung = scanner.next().charAt(0);
            eosNova.fliegen(richtung);
            zuege++;


            // Interaktionen mit Planeten
            for (Planet planet : Sonnensystem.getPlaneten()) {
                if (eosNova.pruefeKoordinaten(planet.getKoordinaten()[0], planet.getKoordinaten()[1])) {
                    System.out.println("Sie haben den Planeten " + planet.getName() + " erreicht. Dieser Planet hat " + (planet.hatAtmosphaere() ? "eine Atmosphäre." : "keine Atmosphäre."));
                    System.out.println("Möchten Sie dort landen? (J/N)");
                    char antwort = scanner.next().charAt(0);
                    if (antwort == 'J' || antwort == 'j') {
                        if (!planet.hatAtmosphaere()) {
                            eosNova.hit(10); // Beispiel: Raumschiff erleidet 10 Schaden
                            System.out.println("Das Raumschiff hat Schaden erlitten, da der Planet keine Atmosphäre hat.");
                        } else {
                            System.out.println("Sie landen auf dem Planeten!.");
                        }
                        if (planet.getLadung() != null) {
                            System.out.println("1. Der Planet hat eine Ladung: " + planet.getLadung().getName());
                            System.out.println("Möchten Sie die Ladung aufnehmen? (J/N)");
                            char antwort1 = scanner.next().charAt(0);
                            if (antwort1 == 'J' || antwort1 == 'j') {
                                eosNova.addLadung(planet.removeLadung());
                                System.out.println("Sie haben die Ladung aufgenommen.");
                            }
                        } else if (eosNova.getLadung() != null) {
                            System.out.println("Sie haben eine Ladung: " + eosNova.getName());
                            System.out.println("Möchten Sie die Ladung abgeben? (J/N)");
                            char antwort2 = scanner.next().charAt(0);
                            if (antwort2 == 'J' || antwort2 == 'j') {
                                planet.addLadung(eosNova.getLadung());
                                eosNova.removeLadung();
                                System.out.println("Sie haben die Ladung abgegeben.");
                            }
                        }

                        if (planet.hatKosmischeNachricht() != null) {
                            System.out.println("2. Dein Weltenradio empfängt eine ungewönliche Frequenz in der Umlaufbahn von " + planet.getName());
                            System.out.println("Möchten Sie die Nachricht entschlüsseln? (J/N)");
                            char antwort3 = scanner.next().charAt(0);
                            if (antwort3 == 'J' || antwort3 == 'j') {
                                KosmischeNachrichten.versucheZuEntschluesseln(planet.hatKosmischeNachricht());
                            }
                        }
                        System.out.println("3. Möchten Sie mit den Bewohnern sprechen? (J/N)");

                        char antwort3 = scanner.next().charAt(0);
                        if (antwort3 == 'J' || antwort3 == 'j') {
                            System.out.println("Die Bewohner von " + planet.getName() + " begrüßen Sie.");
                            System.out.println("Sagen Sie etwas:");
                            String nachricht = scanner.next();
                            if (nachricht.equals("Xenon")) {
                                System.out.println("Ein vermumter Fremder aus der Masse von Leuten kommt auf dich zu und  gibt dir einen Zettel " +
                                        "mit Koordinaten:  15,1 und flüstert dir zu: 'Des Kraters Herz ist der Schlüssel zur Macht.'");
                            } else {
                                System.out.println("Die Bewohner von " + planet.getName() + " schauen dich verwirrt an, sie scheinen dich nicht zu " +
                                        "verstehen.'");
                            }
                        }
                    }
                }
            }

            // Interaktionen mit Asteroidenfeldern
            for (Asteroidenfeld asteroidenfeld : Sonnensystem.getAsteroidenfelder()) {
                if (eosNova.pruefeKoordinaten(asteroidenfeld.getKoordinaten()[0], asteroidenfeld.getKoordinaten()[1])) {
                    System.out.println("Ein Asteroidenfschauer kommt auf dich zu!");
                    if (Asteroidenfeld.Ausweichmanöver()) {
                        eosNova.hit(Asteroidenfeld.getGefahrenpotential());
                        System.out.println("Dein Raumschiff hat " + Asteroidenfeld.getGefahrenpotential() + " Schaden erlitten, da es durch ein Asteroidenfeld geflogen ist.");
                    } else {
                        System.out.println("Dein Kapitän konnte gerade noch gekonnt ausweichen.");
                    }
                }
            }

            //Interaktionen mit Galaxieobjekten
            for (GalaxieObjekte galaxieObjekt : Sonnensystem.getGalaxieObjekte()) {
                if (eosNova.pruefeKoordinaten(galaxieObjekt.getPosX(), galaxieObjekt.getPosY())) {
                    System.out.println("Du bist auf ein" + galaxieObjekt.getName() + " gestoßen!");
                    System.out.println("Möchtest du das Galaxieobjekt untersuchen? (J/N)");
                    char antwort = scanner.next().charAt(0);
                    if (antwort == 'J' || antwort == 'j') {
                        System.out.println("Glückwunsch,der " + galaxieObjekt.getName() + " enthält " + galaxieObjekt.getGegenstand().getTyp());
                        eosNova.addVerbesserung(galaxieObjekt.getGegenstand());
                        eosNova.setWaffenstaerke(galaxieObjekt.getGegenstand());
                        System.out.println("Dein Raumschiff hat nun durch das neue Waffensystem eine Waffenstärke von " + Raumschiff.getWaffenstaerke());
                    } else {
                        System.out.println("Du ignorierst die Untersuchung, schade.");
                    }
                }
            }


            // Interaktion mit gegnerischen Raumschiffen
            for (GegnerischesRaumschiff gegner : Sonnensystem.getGegnerischeRaumschiffe()) {
                if (eosNova.pruefeKoordinaten(gegner.getPosX(), gegner.getPosY())) {
                    System.out.println("Ein gegnerisches Raumschiff " + gegner.getName() + " wurde gesichtet!");
                    while (!gegner.isDestroyed() && (eosNova.getLebenspunkte() > 0)) {
                        System.out.println("Möchten Sie angreifen oder fliehen? (A/F)");
                        char kampfAntwort = scanner.next().charAt(0);
                        if (kampfAntwort == 'A' || kampfAntwort == 'a') {
                            gegner.hit(Raumschiff.getWaffenstaerke());
                            System.out.println("Das gegnerische Raumschiff " + gegner.getName() + " wurde getroffen und hat noch "
                                    + gegner.getLebenspunkte() + " Lebenspunkte.");
                            if (!gegner.isDestroyed()) {
                                gegner.attack(eosNova);
                                System.out.println("Das Raumschiff " + eosNova.getName() + " wurde von " + gegner.getName() + " getroffen und hat noch " +
                                        eosNova.getLebenspunkte() + " Lebenspunkte.");

                            } else {
                                System.out.println("Du hast das gegnerische Raumschiff zerstört!");
                                eosNova.getKapitaen().levelUp();
                                eosNova.setWaffenstaerke(new Gegenstand("Waffenupgrade", 5));
                                System.out.println("Dein Raumschiff hat nun eine Waffenstärke von " +
                                        Raumschiff.getWaffenstaerke());
                            }
                        } else if (kampfAntwort == 'F' || kampfAntwort == 'f') {
                            if (alexiaNova.diplomatischeVerhandlung()) {
                                System.out.println("Du hast das gegnerische Raumschiff " + gegner.getName() +
                                        " überzeugt, dass ein Kampf nicht nötig ist.");
                                break;
                            }

                        }
                    }
                }

            }


// Endboss


            if (zuege >= endbossSpawnZeit) {
                Endboss endboss = new Endboss("GALAXUS", 50, 50, 50, 50, 20, 20, 10, 10, 10);
                System.out.println("Du verspührst eine Änderung im Machtfeld des Sonnensystems! Position: X = " + Endboss.getPosX()
                        + " Y = " + Endboss.getPosY());

                if (eosNova.pruefeKoordinaten(Endboss.getPosX(), Endboss.getPosY())) {
                    System.out.println("Du bist dem Endboss GALAXUS begegnet! Angriff oder Flucht? (A/F)");
                    char kampfAntwort = scanner.next().charAt(0);
                    if (kampfAntwort == 'A' || kampfAntwort == 'a') {
                        while (!endbossdead && (eosNova.getLebenspunkte() > 0)) {
                            System.out.println("Wohin möchtest du zielen ? (1 - Linker Arm, 2 - Rechter Arm, 3 - Linkes Bein, " +
                                    "4 - Rechtes Bein, 5 - Linkes Auge, 6 - Rechtes Auge)");
                            String ziel = scanner.next();
                            int schaden = Raumschiff.getWaffenstaerke();
                            switch (ziel) {
                                case "1":
                                    endboss.hitArm(schaden);
                                    break;
                                case "2":
                                    endboss.hitRArm(schaden);
                                    break;
                                case "3":
                                    endboss.hitLLeg(schaden);
                                    break;
                                case "4":
                                    endboss.hitRLeg(schaden);

                                    break;
                                case "5":
                                    endboss.hitLEye(schaden);
                                    break;
                                case "6":
                                    endboss.hitREye(schaden);
                                    break;
                                default:
                                    System.out.println("Ungültiges Ziel.");
                                    break;
                            }


                            if (!endboss.isDefeated()) {
                                endboss.attack(eosNova);
                                endboss.attackDamage += 5;
                                System.out.println("Das Raumschiff " + eosNova.getName() + " wurde von GALXUS getroffen und hat noch " +
                                        eosNova.getLebenspunkte() + " Lebenspunkte.");
                                if (eosNova.getLebenspunkte() <= 0) {
                                    gameOver = true;
                                }
                            } else if (endboss.isDefeated()) {
                                System.out.println("Du hast den Endboss besiegt! Du hast das Spiel gewonnen!");
                                gameOver = true;
                                endbossdead = true;


                            } else if (kampfAntwort == 'F' || kampfAntwort == 'f') {
                                if (alexiaNova.diplomatischeVerhandlung()) {
                                    System.out.println("Du fliegst vor dem Endboss GALAXUS davon!");
                                } else {
                                    System.out.println("Der Endboss GALAXUS hat dich angegriffen!");
                                    endboss.attack(eosNova);
                                }


                            } else {
                                System.out.println("Ungültige Eingabe.");
                            }
                        }
                    }
                }


            }
        }
    }
}

















