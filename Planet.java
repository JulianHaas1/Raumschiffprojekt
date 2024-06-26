package raumschiffspiel;

public class Planet {
    private String name;
    private boolean hatAtmosphaere;
    private Ladung ladung;
    private int[] koordinaten;

    private KosmischeNachrichten Nachricht;

    public Planet(String name, boolean hatAtmosphaere, Ladung ladung, int[] koordinaten, KosmischeNachrichten Nachricht) {
        this.name = name;
        this.hatAtmosphaere = hatAtmosphaere;
        this.ladung = null;
        this.koordinaten = new int[]{koordinaten[0], koordinaten[1]};
        this.Nachricht = Nachricht;
    }

    public String getName() {
        return name;
    }

    public boolean hatAtmosphaere() {
        return hatAtmosphaere;
    }

    public Ladung getLadung() {
        return ladung;
    }

    public void addLadung(Ladung ladung) {
        this.ladung = ladung;
    }

    public Ladung removeLadung() {
        Ladung removedLadung = this.ladung;
        this.ladung = null;
        return removedLadung;
    }

    public int[] getKoordinaten() {
        return koordinaten;
    }

    public KosmischeNachrichten hatKosmischeNachricht() {
        return Nachricht;
    }


}

