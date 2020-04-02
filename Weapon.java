/**
 * An weapon class
 */

public class Weapon extends Property{
    private int damage;
    private int requiredHands;
    public Weapon(String name,int price, int minimumLevel, int damage, int requireHands){
        super(name,price, minimumLevel);
        this.damage = damage;
        this.requiredHands = requireHands;
    }
    public void display(){
        System.out.println("Weapon: "+this.name+" Damage:"+ this.damage );
    }
    public String getType(){
        return "Weapon";
    }
    public int getDamage(){
        return this.damage;
    }
    public String getName(){
        return this.name;
    }
}