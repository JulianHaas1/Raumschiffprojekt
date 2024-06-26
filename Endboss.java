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
        this.armLHealth = 50; // Example values
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
        if (this.armLHealth <= 0) {
            System.out.println("Der Arm von " + this.name + " wurde zerstört!");
        }
    }

    public void hitRArm(int damage) {
        this.armRHealth -= damage;
        if (this.armRHealth <= 0) {
            System.out.println("Der Arm von " + this.name + " wurde zerstört!");
        }
    }

    public void hitLLeg(int damage) {
        this.legLHealth -= damage;
        if (this.legLHealth <= 0) {
            System.out.println("Das Bein von " + this.name + " wurde zerstört!");
        }
    }

    public void hitRLeg(int damage) {
        this.legRHealth -= damage;
        if (this.legRHealth <= 0) {
            System.out.println("Das Bein von " + this.name + " wurde zerstört!");
        }
    }

    public void hitLEye(int damage) {
        this.eyeLHealth -= damage;
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

