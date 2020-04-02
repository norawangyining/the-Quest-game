import java.util.Scanner; 
import java.util.*; 

/*
 * A market class
 */

public class Market extends Cell implements Setting,TerminalColor{
    //inherited instance: col, row, mark
    private String mark = "M";
    Scanner scanner = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    boolean checking = true;
    String choice;
    Hero actingHero;
    
    public Market(int row, int col ){
        super(row, col,Mark.MARKET );
    }

    
    public void welcome(){
        System.out.println();
        System.out.println(YELLOW_BOLD+"W E L C O M E   T O   T H E   M A R K E T !"+ANSI_RESET);
        System.out.println();
    }
    public void printMenu(int kind){
        if (kind==2){
            //Spell
            System.out.println(ANSI_CYAN+"* Avaliable Ice Spells *"+ANSI_RESET);
            for (final Object[] row : iceSpell) {
            System.out.format("%15s%15s%15s%15s%15s%15s\n", row);
            }
            System.out.println();
            System.out.println(ANSI_CYAN+"* Avaliable Fire Spells *"+ANSI_RESET);
            for (final Object[] row : fireSpell) {
            System.out.format("%15s%15s%15s%15s%15s%15s\n", row);
            }
            System.out.println();
            System.out.println(ANSI_CYAN+"* Avaliable Lightening Spells *"+ANSI_RESET);
            for (final Object[] row : lighteningSpell) {
            System.out.format("%15s%15s%15s%15s%15s%15s\n", row);
            }    
        
        }else if(kind==1){
            //Item
            System.out.println(ANSI_CYAN+"* Avaliable Weapons *"+ANSI_RESET);
            for (final Object[] row : weapon) {
            System.out.format("%15s%15s%15s%15s%15s%15s\n", row);
            }
            System.out.println();
            System.out.println(ANSI_CYAN+"* Avaliable Armor *"+ANSI_RESET);
            for (final Object[] row : armor) {
            System.out.format("%15s%15s%15s%15s%15s\n", row);
            }
            System.out.println();
            System.out.println(ANSI_CYAN+"* Avaliable Potions *"+ANSI_RESET);
            for (final Object[] row : potion) {
            System.out.format("%15s%15s%15s%15s%15s\n", row);
            }
          
        }
        
        
    }

    
    public void buy(HeroTeam team){
        //choose category: Items or Spells
        System.out.print("Choose Category: Items[1] or Spells[2]");
        checking =true;
        int kind=0;
        while(checking){
              kind = input.nextInt();
              if(kind==1 || kind==2){
                      //choose the hero who will us the Item/spell(if one hero, skip)
                      if(team.getSize()>1){
                          System.out.println("Choose the hero who will us the Item/spell");
                          team.printName();
                          boolean checking2= true;
                          while(checking2){
                              String hero = input.nextLine();
                              if(team.containHero(hero)){
                                  actingHero=team.getHero(hero);
                                  System.out.println("You choosed: "+actingHero.getName());
                                  checking2=false;
                              }
                              else if(hero == "i"){
                                  team.teamInfo();
                              }
                              else{
                                  System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
                              }
                          }
        
                      }else{
                          actingHero = team.getTeam().get(0);
                      }
                      printMenu(kind);
                      checking =false;
              }else{
                  System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
              }
        }
        //enter the name of Item/ spell you want to buy, put into heores's pocket
        System.out.print("Enter the Number of Item/ spell you want to buy:");
        checking =true;
        while(checking){
            //add to hero's inventory
              int number = input.nextInt();
              if(kind==2 && number>=1 && number<=12){
                  Object[] s;
                  if(number<5){
                     s = iceSpell[number];
                     //check hero's level eligibility
                     if (actingHero.levelRequire((int)s[3])&&actingHero.affordable((int)s[2])){
                         actingHero.addProp(new Spell((String)s[1],(int)s[2],(int)s[3],(int)s[4], (int)s[5]));
                         checking =false; 
                     }
                  }else if(number<9){
                     s =fireSpell[number-4];
                     if (actingHero.levelRequire((int)s[3])&&actingHero.affordable((int)s[2])){
                         actingHero.addProp(new Spell((String)s[1],(int)s[2],(int)s[3],(int)s[4], (int)s[5]));
                         checking =false; 
                     }
                  }else{
                     s = lighteningSpell[number-8];
                     if (actingHero.levelRequire((int)s[3])&&actingHero.affordable((int)s[2])){
                         actingHero.addProp(new Spell((String)s[1],(int)s[2],(int)s[3],(int)s[4], (int)s[5]));
                         checking =false; 
                     }
                     
                  }
                     
              }else if (kind==1&& number>=1 && number<=18){
                  if(number<8){
                      Object[] w = weapon[number];
                      if (actingHero.levelRequire((int)w[3])&&actingHero.affordable((int)w[2])){
                          Weapon w1 = new Weapon((String)w[1],(int)w[2],(int)w[3],(int)w[4],(int)w[5]);
                          actingHero.weaponWear(w1);
                          actingHero.addProp(w1);
                          checking =false; 
                      }
                  }else if(number<13){
                      Object[] a = armor[number-7];
                      if (actingHero.levelRequire((int)a[3])&&actingHero.affordable((int)a[2])){
                          Armor a1 = new Armor((String)a[1],(int)a[2],(int)a[3],(int)a[4]);
                          actingHero.armorWear(a1);
                          actingHero.addProp(a1);
                          checking =false; 
                      }
                  }else{
                      Object[] p = potion[number-12];
                      if (actingHero.levelRequire((int)p[3])&&actingHero.affordable((int)p[2])){
                          actingHero.addProp(new Potion((String)p[1],(int)p[2],(int)p[3],(int)p[4]));
                          checking =false; 
                      }
                  }
                 
              }else{
                  System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
              }
        }
        //show Inventory;
        actingHero.displayInventory();
    }
    
    public void sell(HeroTeam team){
        if(team.getSize()>1){
            System.out.print("Choose the hero who will sell the Item/spell");
            for(String name: team.getNames()){
                System.out.println(name);
            }
            boolean checking2= true;
            while(checking2){
                String hero = input.nextLine();
                if(team.containHero(hero)){
                    actingHero=team.getHero(hero);
                    System.out.println("You choosed: "+actingHero.getName());
                    checking2=false;
                }else if(hero == "i"){
                    team.teamInfo();
                }
                else{
                    System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
                }
            }
        }else{
            actingHero = team.getTeam().get(0);
        }
        //show Inventory;
        actingHero.displayInventory();
        if (actingHero.getInventory().size()==0){
            System.out.println("Your have nothing can sell!");
        }else{
            System.out.print("Enter the name of item/spell you wanna sell : ");
            boolean checking2= true;
            while(checking2){
                String thing = input.nextLine();
                if(actingHero.getInventoryNames().contains(thing)){
                    int index = actingHero.getInventoryNames().indexOf(thing);
                    actingHero.removeProp(index);
                   actingHero.displayInventory();
                    checking2=false;
                }else{
                    System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
                }
            }
            
        }
    
    }
    public void exit(){
        System.out.println("You have exit the market.");
    }
    
    public void play(HeroTeam team){
        welcome();
        boolean next = true;
        //while they don't wanna exit, continuing doing 
        do{
            System.out.print("Press [buy], [sell], or [exit] according to your purpose : ");
            checking =true;
            while(checking){
                choice = input.nextLine();
                if(choice.equals("buy")){
                    buy(team);
                    checking =false;
                }else if(choice.equals("sell")){
                    sell(team);
                    checking =false;
                }else if(choice.equals("exit")){
                    exit();
                    checking = false;
                    next=false;
                }else{
                    System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
                }
            } 
        }while(next ==true);  
        
    }
    public static void main(String[] args) {
        Market cell = new Market(2,3);

        Gaerdal_Ironhand.addProp(sword);
        Gaerdal_Ironhand.weaponWear(sword);
        Gaerdal_Ironhand.removeProp(0);
        //r.play();
       
    }
    
}