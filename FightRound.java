import java.util.Scanner; 
import java.util.*; 

public class FightRound implements Setting, TerminalColor{
    private Hero hero;
    private Monster monster;
    private int round;
    Scanner scanner = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    boolean checking = true;
    double heroDodge;
    int DRhero = 0; //damage reduction
    double dTOmonster=0;
    double dTohero=0;
    double monsterDodge = 0;
    int monsterDefense = 0;
    Property p;
    Armor a;
    
    public void heroStat(){
        System.out.println(ANSI_GREEN_BACKGROUND+ "Hero's Statistic"+ ANSI_RESET);
        System.out.println("Name                   Magic Power         Health Power        Strength        Agility       Dexterity       Experience");
        hero.displayInfo();
        hero.displayInventory();
    }
    public void monsterStat(){
        System.out.println(ANSI_BLUE_BACKGROUND+"Monster's Statistic"+ ANSI_RESET);
        System.out.println("Name                   level            damage             defense            dodgeChance");
        monster.displayInfo();
    }
    
    
    public FightRound(Hero fightHero, Monster fightMonster , int rounds){
        this.hero= fightHero;
        this.monster = fightMonster;
        this.round = rounds;
        System.out.println(ANSI_CYAN+"* Round "+this.round + ANSI_RESET);
        heroStat();
        System.out.println();
        monsterStat();
   
    }
    public void setZero(){
        dTOmonster=0;
        dTohero=0;
        monsterDodge = 0;
        monsterDefense = 0;
    }
    public void checkItem(String s){
            System.out.println("Enter name of "+s+" you want to use: ");
                boolean checking2 =true;
                while(checking2){
                    String choice = input.nextLine();
                    if(hero.inventoryNames.contains(choice)){
                        int index = hero.inventoryNames.indexOf(choice);
                        p=hero.inventory.get(index);
                        checking2=false;
                    }else{
                        System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
                    } 
                }
        }
    public void checkArmor(){
        System.out.println("Enter name of Armor you want to use: ");
                boolean checking2 =true;
                while(checking2){
                    String choice2 = input.nextLine();
                    if(hero.inventoryNames.contains(choice2)){
                        int index = hero.inventoryNames.indexOf(choice2);
                        a= (Armor)hero.inventory.get(index);
                        if(p.getType()== "Armor"){
                            checking2=false;}
                    }else{
                        System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
                    } 
                }
                System.out.println("You've changed your Armor.");
    }
    
    public Property heroAttack(){        
        //choose [regular] attack, [spell],  or [potion]
        p = hero.getInventory().get(0); 
        //System.out.println("Choose [regular] attack,[spell],[potion],or change[weapon]/[armor]");
        //hero.displayInventory();
        boolean go =true;
        while(go){
            System.out.println();
            System.out.println("Choose [regular] attack,[spell],[potion],or change[weapon]/[armor]");
            hero.displayInventory();
            String choice = input.nextLine();
            if(choice.equals("regular")&&hero.getWeapon()!=null){
                p = hero.getWeapon(); 
                if(hero.getArmor()!=null){
                    a = hero.getArmor();}
                go=false;
                
            }else if(choice.equals("spell")){
                checkItem("Spell"); 
                Spell s = (Spell)p;
                dTOmonster = s.getDamage()*(s.getDamage()+hero.getDexterity()/10000);
                hero.addMana(-s.getManaCost());
                dTohero*=0.9;
                
            }else if(choice.equals("potion")){
                checkItem("Potion");
                Potion po = (Potion)p;
                po.play(hero);
                int index = hero.getInventory().indexOf(p);
                hero.removeProp(index);
                //go=false;
                
            }else if(choice.equals("weapon")){
                checkItem("Weapon");
                System.out.println("You've changed your weapon.");
                hero.displayInventory();
                //go=false;
            }else if(choice.equals("armor")){
                checkArmor();
                hero.displayInventory();
                //go=false;
            }else{
                System.out.print(ANSI_RED +"please enter again(if you choosed regualr and get this, you do not acquire a weapon yet): "+ANSI_RESET);
            }
        }
        return p;
    } 
    
    public void heroTurn(){
        if(hero.getInventory().size()==0 || hero.getWeapon()==null){
                System.out.print("You don't have weapons/spells/potions to do any attack!");
                DRhero = 0;
                dTOmonster=0;
        }else{
                Property attack = heroAttack();
                String type = attack.getType();
                dTOmonster = 0.08*(attack.getDamage()+hero.getStrength());
                System.out.println("Damage to Monster:" + dTOmonster);
                System.out.println("Damage to Hero   :" + dTohero);
                if(a!=null){
                    DRhero = a.getDR();  
                }
        }
    }   
    
    public String play(){
        heroDodge = this.hero.getAgility()*0.02*0.01;
        monsterDodge = this.monster.getDodgeChance();
        do{
            setZero();
            //monster turn 
            dTohero = monster.getDamage();
            
            //hero turn: if monster hp=0, break
            heroTurn();
            monsterDefense = monster.getDefense();
            //finalize dodge chance 
            if( Math.random() < heroDodge ){
                dTohero=0;}
            if( Math.random() < monsterDodge ){
                dTOmonster=0;}  
            //finalize defense and damage        
            if (monsterDefense >= dTOmonster){
                dTOmonster =0;
            }else{
                dTOmonster = dTOmonster-monsterDefense;
            }
            if(DRhero>=dTohero){
                dTohero =0;
            }else{
                dTohero = dTohero - DRhero;
            }
            hero.growHP(-dTohero);
            monster.growHP(-dTOmonster);
            System.out.println("Hero now have HP: "+hero.getHP());
            System.out.println("Monster now have HP: "+monster.getHP());
            System.out.println();
            hero.growHPm(1.05);
            hero.growManam(1.05);
        }while(hero.getHP()!=0 && monster.getHP()!=0);
            
        if(monster.getHP()==0){
            //hero win!
            System.out.println("Hero "+ANSI_GREEN_BACKGROUND+ hero.getName()+ANSI_RESET+" wins this round !");
            return "hero";
        }else {
            //monster wins!
            System.out.println("Monster "+ANSI_BLUE_BACKGROUND+ monster.getName()+ANSI_RESET+" wins this round!");
            return "monster";
        }
      
    }
    public static void main(String[] args) {
        Gaerdal_Ironhand.addProp(sword);
        Gaerdal_Ironhand.addProp(Platinum_Shield);
        Gaerdal_Ironhand.weaponWear(sword);
        Gaerdal_Ironhand.armorWear(Platinum_Shield);
        FightRound r = new FightRound(Gaerdal_Ironhand, monsters.get(3), 1);
        Potion p = new Potion("Healing_Potion",250, 1,100);
        Gaerdal_Ironhand.addProp(p);
        r.play();
       
    }
    
}

