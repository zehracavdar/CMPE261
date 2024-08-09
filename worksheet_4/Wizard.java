import java.util.Random;

public class Wizard {
    private int health;
    private int mana;
    private int power;
    

    // overloaded constructors

    public Wizard(int health, int mana, int power) {
        this.health = health;
        this.mana = mana;
        this.power = power;
    }
    
    // setters & getters

    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getMana() {
        return mana;
    }
    
    public void setMana(int mana) {
        this.mana = mana;
    }
    
    public int getPower() {
        return power;
    }
    
    public void setPower(int power) {
        this.power = power;
    }

    // toString method

    public String toString() {
        return "Wizard [health=" + health + ", mana=" + mana + ", power=" + power + "]";
    }

    // fireball method---
    /*this is the outline of damage. damage will be used in "Arena"
    like ---int damage = wizard.fireball();----
    */

    public int fireball() {
        if (mana >= 0) {
            mana -= 5;     //each damage uses up 5 manas 
            Random rand = new Random();
            return rand.nextInt(6) + 1; // damage values takes a random integer between [1,6]
        } else {
            return 0;
        }
    }
    
}