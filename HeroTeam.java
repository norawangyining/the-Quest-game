
import java.util.Scanner; 
import java.util.*; 

public class HeroTeam implements Setting, TerminalColor{
    private ArrayList<String> teamNames =new ArrayList<String>() ;
    private ArrayList<Hero> team = new ArrayList<Hero>();
    private int size = 0; 
    private final int  maxSize = 3;
    
    public HeroTeam(){}
        
    public boolean addMember(String hero){
        if(heroNames.contains(hero)&& !teamNames.contains(hero)){
                    
                    int index = heroNames.indexOf(hero);
                    if(index<4){
                        //warrior
                        addHero(warriors.get(index));
                  
                        return true;
                    } else if(index<8){
                        //sorcerer
                        addHero(sorcerers.get(index-4));
                        return true;
                    }else{
                        //palaldins
                        addHero(paladins.get(index-8));
                        return true;
                    }  
                    
        }else{return false;}
    }
    public void addHero(Hero hero){
        team.add(hero);
        teamNames.add(hero.getName());
        size++;
    }
    
    public void teamInfo(){
        System.out.println();
        System.out.println("                                    "+PURPLE_BOLD+"* Your Team Member(s) *"+ANSI_RESET);
        System.out.println();
        System.out.println("Name                   Magic Power         Health Power        Strength        Agility       Dexterity       Experience");
        for(Hero h: this.team){
            h.displayInfo();
        }
        System.out.println(); 
        System.out.println();
        System.out.println();
    }
    public int getSize(){
        return this.size;
    }
    public ArrayList<String> getNames(){
        return this.teamNames;
    }
    public boolean containHero(String hero){
        if (teamNames.contains(hero)){
            return true;
        }else{
            return false;
        }
        
    }
    public Hero getHero(String hero){
        int index = teamNames.indexOf(hero);
        return team.get(index);
    }
    public Hero getHeroN(int index){
        return this.team.get(index);
    }
    public void removeHeroN(int index){
        this.team.remove(index);
        this.teamNames.remove(index);
        this.size--;
    }
    public ArrayList<Hero> getTeam(){
        return this.team;
    }
    public void printName(){
        for(String name: teamNames){
            System.out.println(name);
        }
    }
   
    
        
        
        
        
    
}
