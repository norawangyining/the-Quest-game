/**
 * Auto Generated Java Language Level Class.
 */
public class Monster {
    private String name;
    private int HP;
    private int level;
    private int damage;
    private int defense;
    private int dodgeChance;
    private String type;
    
    public Monster(String name, int level, int damage, int defense, int dodgeChance){
        //this.type = 
        this.name = name;
        this.level = level;
        this.HP = 100*level;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance; 
        
    }
    public String getName(){
        return this.name;
    }
    public int getHP(){
        return this.HP;
    }
    public int getLevel(){
        return this.level;
    }
    public void displayInfo(){
        //level, hp, mana, current exp, skill levels 
        System.out.println(name+"              "+ level+"              "+damage+"             "+defense+"            "+dodgeChance);
    }
    public int getDamage(){
        return this.damage;
    }
    public int getDefense(){
        return this.defense;
    }
    public double getDodgeChance(){
        return this.dodgeChance*0.01;
    }
    public void growHP(double w){
        this.HP +=w;
        if(this.HP<0){
            this.HP=0;
        }
    }
    
    
}
