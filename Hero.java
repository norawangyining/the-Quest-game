
import java.util.*;
/**
 * Auto Generated Java Language Level Class.
 */
class Hero implements TerminalColor, Setting{
    protected String name;
    protected int level;
    protected int HP; //health power;
    protected int mana;
    protected int strength;
    protected int dexterity;
    protected int agility;
    protected int money;
    protected int experience;
    protected ArrayList<Property> inventory = new ArrayList<Property>();
    protected ArrayList<String> inventoryNames = new ArrayList<String>();
    protected int hand = 2;
    protected Weapon weapon;
    protected Armor armor;
   
    public Hero(String name, int mana, int strength, int agility, int dexterity, int start_money, int start_exp){
       
        this.name = name; 
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.money = start_money;
        this.experience = start_exp;
        this.level = 1;
        this.HP = 100*this.level;     
    }

    public void displayInfo(){
        //level, hp, mana, current exp, skill levels 
        System.out.println(name+"           "+mana+"                "+HP+"               "+strength+"             "+agility+"             "+dexterity+"             "+experience);
    }
    
    public int getLevel(){
        return this.level;
    }
    public String getName(){
        return this.name;
    }
    public int getMana(){
        return this.mana;
    }
    public void addMana(int w){
        this.mana+=w;
    }
    public void growManam(double w){
        this.mana*=w;
    }
    public int gethand(){
        return this.hand;
    }
    
    public int getStrength(){
        return this.strength;
    }
    public int getAgility(){
        return this.agility;
    }
    public int getDexterity(){
        return this.dexterity;
    }
    public void addStrength(int w){
        this.strength+=w;
    }
    public void addAgility(int w){
        this.agility+=w;
    }
    public void addDexterity(int w){
        this.dexterity+=w;
    }
    
    public int getMoney(){
        return this.money;
    }
    public int getExp(){
        return this.experience;
    }
    public void addExp(int e){
        this.experience+=e;
    }
    public int getHP(){
        return this.HP;
    }
    public void growHP(double w){
        this.HP+=w;
        if(this.HP<0){
            this.HP=0;
        }
    }
    public void growHPm(double w){
        this.HP *= w;
        if(this.HP<1){
            this.HP=0;
        }
    }
    public void addProp(Property p){
        inventory.add(p);
        inventoryNames.add(p.getName());
        
    }
    public void addMoney(int m){
        this.money = this.money+m;
        
    }
    public void removeProp(int index){
        int refund = inventory.get(index).getPrice();
        String name = inventory.get(index).getName();
        if(weapon!=null){
            if(name.equals(weapon.getName())){
                weapon=null;}
        }
        if(armor!=null){
            if(name.equals(armor.getName())){
                armor=null;}
        }
        addMoney(refund);
        System.out.println(ANSI_CYAN+ this.name +ANSI_RESET+ " now have "+ANSI_YELLOW +this.money+"$. "+ANSI_RESET);
        System.out.println();
        inventory.remove(index);
        inventoryNames.remove(index);
    }
    public void displayInventory(){
        System.out.println();
        System.out.println(ANSI_YELLOW+"***********"+ANSI_RESET);
        System.out.println(ANSI_CYAN+name+"'s inventory: "+ANSI_RESET);
        if(inventory.size()==0){
            System.out.println("Your inventory is empty!");
        }
        for(Property p: inventory){
            p.display();
        }
        if(getWeapon()!=null){
            System.out.println("Your current Weapon: ["+ weapon.getName()+"]");}
        if(getArmor()!=null){
            System.out.println("Your current Armor: ["+ armor.getName()+"]");}
        System.out.println(ANSI_YELLOW+"***********"+ANSI_RESET);
        System.out.println();
        
    }
    public ArrayList<Property> getInventory(){
        return this.inventory;
    }
    public ArrayList<String> getInventoryNames(){
        return this.inventoryNames;
    }
    public void checkLevel(){
        int levelsUp = 0;
        if (this.HP/100>this.level && this.experience>10*this.level ){
            levelsUp = this.HP/100 - this.level;
            this.level = this.HP/100;
         
        }
        levelup(levelsUp);
    }
    public void levelup(int l){
        while(l>0){
            this.mana *= 1.1;
            upgradelevel();
        }
        System.out.println("Congradulations! Your hero upgraded to LEVEL "+this.level+"!");
    }
    public void upgradelevel(){};
    
    public void weaponWear(Weapon w){
        this.weapon = w;
    };
    public Weapon getWeapon(){
            return this.weapon;
    }
    public void armorWear(Armor a){
        this.armor = a;
    };
    public Armor getArmor(){
        return this.armor;
    }
    public boolean affordable(int price){
        if(this.money >= price){
            this.money -=price;
            System.out.println();
            System.out.println(ANSI_YELLOW+"Thank you for purchasing :)"+ANSI_RESET);
            System.out.println(ANSI_CYAN+ this.name +ANSI_RESET+ " now have "+ANSI_YELLOW +this.money+"$. "+ANSI_RESET);
            System.out.println();
            return true;
        }else{
            System.out.println(ANSI_RED +"You can't afford it, man."+ANSI_RESET);
            return false;
        }
    }
    public boolean levelRequire(int l){
        if(this.level >=l){
            return true;
        }else{
            System.out.println(ANSI_RED +"You are not good enough to purchase this, man. Try to level up."+ANSI_RESET);
            return false;
        }
    }
    public static void main(String[] args) {
        Market cell = new Market(2,3);
        Gaerdal_Ironhand.weaponWear(sword);
        Gaerdal_Ironhand.addProp(sword);
        Gaerdal_Ironhand.weaponWear(sword);
        Gaerdal_Ironhand.removeProp(0);
   
    }
    

    
}
