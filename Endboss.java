// Endboss.java
package raumschiffspiel;

public class Endboss {
    private String name;
    private int armLHealth;
    private int armRHealth;
    private int legRHealth;
    private int legLHealth;
    private int eyeRHealth;
    private int eyeLHealth;

    public int attackDamage = 10;
     private static int PosX;
    private static int PosY;

    public Endboss(String name, int armLHealth, int armRHealth, int legRHealth, int legLHealth, int eyeRHealth, int eyeLHealth, int attackDamage, int PosX, int PosY) {
        this.name = name;
        this.armLHealth = 50;
        this.armRHealth = 50;
        this.legRHealth = 50;
        this.legLHealth = 50;
        this.eyeRHealth = 50;
        this.eyeLHealth = 20;
        this.attackDamage = attackDamage;
        this.PosX = PosX;
        this.PosY = PosY;
    }

    public void hitArm(int damage) {
        this.armLHealth -= damage;
        System.out.println("Verbleibende LP: " + this.armLHealth);
        if (this.armLHealth <= 0) {
            System.out.println("Der Arm von " + this.name + " wurde zerstört!");
        }
    }

    public void hitRArm(int damage) {
        this.armRHealth -= damage;
        System.out.println("Verbleibende LP: " + this.armRHealth);
        if (this.armRHealth <= 0) {
            System.out.println("Der Arm von " + this.name + " wurde zerstört!");
        }
    }

    public void hitLLeg(int damage) {
        this.legLHealth -= damage;
        System.out.println("Verbleibende LP: " + this.legLHealth);
        if (this.legLHealth <= 0) {
            System.out.println("Das Bein von " + this.name + " wurde zerstört!");
        }
    }

    public void hitRLeg(int damage) {
        this.legRHealth -= damage;
        System.out.println("Verbleibende LP: " + this.legRHealth);
        if (this.legRHealth <= 0) {
            System.out.println("Das Bein von " + this.name + " wurde zerstört!");
        }
    }

    public void hitLEye(int damage) {
        this.eyeLHealth -= damage;
        System.out.println("Verbleibende LP: " + this.eyeLHealth);
        if (this.eyeLHealth <= 0) {
            System.out.println("Das Auge von " + this.name + " wurde zerstört!");
            int schwachstellenschaden = 20;
                System.out.println("Der Endboss wurde an seiner Schwachstelle getroffen und verliert 20 Lebenspunkte!");
                this.armLHealth -= schwachstellenschaden;
                this.armRHealth -= schwachstellenschaden;
                this.legLHealth -= schwachstellenschaden;
                this.legRHealth -= schwachstellenschaden;
        }

    }

    public void hitREye(int damage) {
        this.eyeRHealth -= damage;
        System.out.println("Verbleibende LP: " + this.eyeRHealth);
        if (this.eyeRHealth <= 0) {
            System.out.println("Das Auge von " + this.name + " wurde zerstört!");
        }
    }

    public boolean isDefeated() {
        return this.armLHealth <= 0 && this.armRHealth <= 0 && this.legLHealth <= 0 && this.legRHealth <= 0 && this.eyeLHealth <= 0 && this.eyeRHealth <= 0 ;
    }

    public void attack(Raumschiff raumschiff) {
        raumschiff.hit(this.attackDamage);
    }

    public static int getPosX(){
        return PosX;
    }

    public static int getPosY(){
        return PosY;
    }

    public void setPosX(int PosX){
        this.PosX = PosX;
    }

    public void setPosY(int PosY){
        this.PosY = PosY;
    }

    public void zeigeStatus() {
        System.out.println("Name: " + this.name);
        System.out.println("Position: " + this.PosX + ", " + this.PosY);
        System.out.println("Arm links: " + this.armLHealth);
        System.out.println("Arm rechts: " + this.armRHealth);
        System.out.println("Bein links: " + this.legLHealth);
        System.out.println("Bein rechts: " + this.legRHealth);
        System.out.println("Auge links: " + this.eyeLHealth);
        System.out.println("Auge rechts: " + this.eyeRHealth);
    }

    public int getArmLHealth(){
        return armLHealth;
    }

    public int getArmRHealth(){
        return armRHealth;
    }

    public int getLegLHealth(){
        return legLHealth;
    }

    public int getLegRHealth(){
        return legRHealth;
    }

    public int getEyeLHealth(){
        return eyeLHealth;
    }

    public int getEyeRHealth(){
        return eyeRHealth;
    }

    public String getName(){
        return name;
    }



}

