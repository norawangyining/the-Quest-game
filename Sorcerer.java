
public class Sorcerer extends Hero{
 
    //facvored on dexterity and Agility
    public Sorcerer(String name, int mana, int strength, int agility, int dexterity, int start_money, int start_exp){
        super(name,mana,strength,agility,dexterity,start_money,start_exp);
    }
    //overwrite
    public void upgradelevel(){
            this.level++;
            this.dexterity *= 1.1;
            this.agility *= 1.1;
            this.strength *=1.05;

    }
}