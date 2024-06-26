package raumschiffspiel;

public class GalaxieObjekte {

    private String name;
    private int posX;
    private int posY;
    private String typ;
    private Gegenstand gegenstand;


    public GalaxieObjekte(String name, int posX, int posY, String typ, Gegenstand gegenstand) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.typ = typ;
        this.gegenstand = gegenstand;
    }

    public GalaxieObjekte() {
        this.name = "Unbekannt";
        this.posX = 0;
        this.posY = 0;
        this.typ = "Unbekannt";
        this.gegenstand = new Gegenstand();
    }

public String getName() {
        return name;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getTyp() {
        return typ;
    }

    public Gegenstand getGegenstand() {
        return gegenstand;
    }




}


