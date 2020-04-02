/**
 * A Spell class
 */
class Spell extends Property{
    protected int damage;
    protected int manaCost;
    public Spell(String name,int price, int minimumLevel,int damage, int manaCost){
        super(name,price, minimumLevel);
        this.damage = damage;
        this.manaCost = manaCost;
    }
    public void display(){
        System.out.println("Spell: "+this.name+" Damage: "+ this.damage +" ManaCost: "+ this.manaCost);
    }
    public String getType(){
        return "Spell";
    }
    public int getdamage(){
        return this.damage;
    }
    public int getManaCost(){
        return this.manaCost;
    }
    
}
