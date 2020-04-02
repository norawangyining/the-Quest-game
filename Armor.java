/**
 * An armor class
 */
public class Armor extends Property{
    private int damageReduc;
    public Armor(String name,int price, int minimumLevel, int damageReduction){
        super(name,price, minimumLevel);
        this.damageReduc = damageReduction; 
}
    
    public void display(){
        System.out.println("Armor: "+this.name+"   Damage Reduction:"+ this.damageReduc);
    }
    public String getType(){
        return "Armor";
    }
    public int getDR(){
        return this.damageReduc;
    }
    public String getName(){
        return this.name;
    }
}
