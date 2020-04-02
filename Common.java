import java.util.Scanner; 

import java.util.*;
/*
 * a market class
 * */

public class Common extends Cell implements Setting, TerminalColor{
    //inherited instance: col, row, mark
    private String mark = " ";
    Random ran = new Random();
    ArrayList<Monster> mons = new ArrayList<Monster>();//mos: contains monsters that are still alive
    HeroTeam liveHero = new HeroTeam();//liveHero: contains heores tat are still alive
    
        

    Scanner scanner = new Scanner(System.in);
    
    public Common(int row, int col ){
        super(row, col,Mark.COMMON );
        
    }
    public void welcome(){
        System.out.println();
        System.out.println(CYAN_BOLD+"Y O U    E N T E R ED    A    C O M M O N    C E L L."+ANSI_RESET);
        System.out.println();
    }
    //monsterLevel = highest level of heros
    public int monsterLevel(ArrayList<Hero> team){
        int maxLevel = 0;
        for(Hero h:team){
            if(h.getLevel()>maxLevel ){
                maxLevel = h.getLevel();
            }
        }
        return maxLevel;
    }
    //choose from default monsters by their level    
    public Monster getMonster(int index, int monsterLevel){
       // System.out.println(monsterLevel);
        ArrayList<Monster> eligible =new ArrayList<Monster>();
        for (Monster m :monsters){
            if( m.getLevel() == monsterLevel){
                eligible.add(m);
            }
        }
        return eligible.get(index);
    }

    //get
    public ArrayList<Monster> monsterTeam(int monsterLevel,int teamSize){
        ArrayList<Monster> monsterTeam = new ArrayList<Monster>();
        for(int i=0;i<teamSize;i++){
            Monster m = getMonster(i,monsterLevel);
            monsterTeam.add(m);
        }
        return monsterTeam;
    }
    
    public void fight(HeroTeam team){
        for(Hero h:team.getTeam()){
            liveHero.addHero(h);
        }
        String[] prob = {"fight","not"};
        //teamSize= team.size();
        int index= ran.nextInt(prob.length);
        if(index==1){
            System.out.println(ANSI_CYAN +"Lucky you! No monster here right now" + ANSI_RESET);
            //return true;
        }else{
            System.out.println(ANSI_RED+"Monsters are waiting for you! Be ready to fight!" + ANSI_RESET); 
            int monsterLevel = monsterLevel(team.getTeam());
            mons = monsterTeam(monsterLevel,team.getSize());
            //fights ends only when all heroes are dead or all monsters are dead.
            int numRound = 1;
            while(liveHero.getSize()!=0 && mons.size()!=0){
                Hero h = liveHero.getHeroN(0);
                Monster m = mons.get(0);
                FightRound round = new FightRound(h,m, numRound);
                String result = round.play();
                numRound++;
                if (result == "monster"){
                    liveHero.removeHeroN(0);
                    System.out.println(liveHero.getSize()>0);
                    
                    if(liveHero.getSize()>0){
                        int HPregain = liveHero.getHeroN(0).getHP();
                        h.growHP(HPregain*0.5);
                        liveHero.getHeroN(0).growHPm(0.5);
                        //liveHero.add(h);
                        }
                    }
                
                if(result =="hero"){
                    mons.remove(0);
                }
                if(liveHero.getSize()>0){
                    for(Hero i: liveHero.getTeam()){
                            //if heroes win, they earn money, regains HPs  
                            i.addMoney(150);
                            i.addExp(2);
                            System.out.println(CYAN_BOLD+"Hero"+i.getName()+"earns 150 coins and 2 experience. Keep Moving!"+ANSI_RESET);
                }
            }
            if(liveHero.getSize()==0){
                System.out.println(ANSI_RED+ "All your heros faints. Game end" +ANSI_RESET);
                System.out.println();
                System.out.println();
                System.out.println(PURPLE_BOLD+"You've exited the game successfully."+ANSI_RESET);
                System.out.println();
                System.exit(0);
                //return false;
            }else{
                System.out.println(ANSI_RED + "You beated all the Monsters!! keep moving." +ANSI_RESET);
                
            }
            //return true;
        }
        }  
    }
    public void play(HeroTeam team){
        welcome();
        fight(team);    
    }
    //some tests
    public static void main(String[] args) {
        Common cell = new Common(2,3);
        Potion p = new Potion("Healing_Potion",250, 1,100);
        //Gaerdal_Ironhand.weaponWear(sword);
        Gaerdal_Ironhand.addProp(p);
        //Gaerdal_Ironhand.weaponWear(sword);
        //Gaerdal_Ironhand.removeProp(0);
        //cell.getMonster(0,1);
        HeroTeam team = new HeroTeam();
        //Potion p = new Potion("Healing_Potion",250, 1,100);
        team.addHero(Gaerdal_Ironhand);
        cell.play(team);
        //p.play(Gaerdal_Ironhand);
        //System.out.println(monsters.size());
        
       
    }
}