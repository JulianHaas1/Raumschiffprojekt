package raumschiffspiel;

public class GegnerischesRaumschiff {
    private String name;
    private int posX;
    private int posY;
    private int waffenstaerke;
    private int lebenspunkte;

    private int Treffgenauigkeit = 0;

    public GegnerischesRaumschiff(String name, int posX, int posY, int waffenstaerke, int lebenspunkte, int Treffgenauigkeit) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.waffenstaerke = waffenstaerke;
        this.lebenspunkte = lebenspunkte;
        this.Treffgenauigkeit = Treffgenauigkeit;
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

    public void hit(int damage) {

        if (Math.random() * 100 < Treffgenauigkeit) {
            System.out.println("Das gegnerische Raumschiff " + this.name + " hat getroffen!");
            this.lebenspunkte -= damage;
        } else {
            System.out.println("Das gegnerische Raumschiff " + this.name + " hat verfehlt!");
        }
        this.lebenspunkte -= damage;
        if (this.lebenspunkte <= 0) {
            System.out.println("Das gegnerische Raumschiff " + this.name + " wurde zerstört!");
        }
    }

    public boolean isDestroyed() {
        return this.lebenspunkte <= 0;
    }

    public void attack(Raumschiff raumschiff) {
        raumschiff.hit(this.waffenstaerke);
    }

    public int getLebenspunkte(){
        return lebenspunkte;
    }
}
