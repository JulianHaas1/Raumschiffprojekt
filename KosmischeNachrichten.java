package raumschiffspiel;

import java.util.ArrayList;

public class KosmischeNachrichten{
    private String Inhalt;
    private int Verschluesselungsgrad;
    private String typ;
    private Kapitaen kapitaen;

    public KosmischeNachrichten(String Inhalt, int Verschluesselungsgrad, String typ) {
        this.Inhalt = Inhalt;
        this.Verschluesselungsgrad = Verschluesselungsgrad;
        this.typ = typ;

    }

    public static void versucheZuEntschluesseln(KosmischeNachrichten Nachricht) {
        int zufallszahl = (int) (Math.random() * 10);
        zufallszahl += Kapitaen.getErfahrung();
        if (Nachricht.typ.equals("geheimeInformation"))
        if (zufallszahl > Nachricht.getVerschluesselungsgrad()){

            System.out.println("Die Nachricht wurde erfolgreich entschluesselt: " + Nachricht.Inhalt);
        } else {
            System.out.println("Nachricht konnte nicht entschluesselt werden.");
        } //erneuter Versuch soll noch möglich sein
    }

    public String getInhalt() {
        return Inhalt;
    }

    public int getVerschluesselungsgrad() {
        return Verschluesselungsgrad;
    }

    public String getTyp() {
        return typ;
    }
}