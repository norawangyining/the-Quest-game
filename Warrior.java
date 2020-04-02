

public class Warrior extends Hero{
 
    //facvored on Strength and Agility
    public Warrior(String name, int mana, int strength, int agility, int dexterity, int start_money, int start_exp){
        super(name,mana,strength,agility,dexterity,start_money,start_exp);
    }
    public void upgradelevel(){
            this.level++;
            this.dexterity *= 1.05;
            this.agility *= 1.1;
            this.strength *=1.1; 
    }
}