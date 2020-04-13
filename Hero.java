package questoflegends;

import java.util.ArrayList;
import java.util.Scanner;



//import java.util.*;
//package questoflegends;

/**
 *
 * @author norawangyining
 */
public class Hero extends Character implements Moveable, Teleportable,TerminalColor,Setting {
    protected SpellBag spellbag;
    protected Body body; //holds the armor and the weapon data 
    protected Inventory inv;
    protected int level;
    protected int HP; //health power;
    protected int mana;
    protected int strength;
    protected int dexterity;
    protected int agility;
    protected int money;
    protected int experience;
    protected int hand = 2;
    protected int loc;
    protected int lane;
    
    //protected Weapon weapon;
    //protected Armor armor;
    
    public Hero(String name, int mana, int strength, int agility, int dexterity, int start_money, int start_exp){
        super(name,CType.HERO);
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.money = start_money;
        this.experience = start_exp;
        this.level = 1;
        this.HP = 100*this.level;
        this.inv = new Inventory(new ArrayList<Item>());
        this.spellbag = new SpellBag(new ArrayList<Spell>());
        this.body = new Body();
       
    }
    public void respawn(Board b){
        Board.locToTile(loc,b).RemoveHr(this);
        int newLoc = 56;
        newLoc += (lane-1)*3;
        Board.locToTile(newLoc,b).placeHr(this);
        System.out.println("Hero "+ANSI_GREEN_BACKGROUND+name+ANSI_RESET+" is respawned to its Nexus!");
    }
    @Override
    public void displayInfo(){
        //level, hp, mana, current exp, skill levels 
        System.out.println(name+"           "+mana+"                "+HP+"               "+strength+"             "+agility+"             "+dexterity+"             "+experience);
    }
    public void displayInventory(){
        System.out.println();
        System.out.println(ANSI_YELLOW+"***********"+ANSI_RESET);
        System.out.println(ANSI_CYAN+name+"'s inventory: "+ANSI_RESET);
        if(inv.numItms()==0){
            System.out.println("You owned NO items");
        }
        inv.toString(); //display items
        
        //show body armor and weapon, will implement later
        System.out.println(ANSI_YELLOW+"***********"+ANSI_RESET);
        System.out.println();
        
    }
    public void displaySpellBag(){
        System.out.println();
        System.out.println(ANSI_YELLOW+"***********"+ANSI_RESET);
        System.out.println(ANSI_CYAN+name+"'s SpellBag: "+ANSI_RESET);
        if(spellbag.numSpells()==0){
            System.out.println("You owned NO spell");
        }
        spellbag.toString();
    }
    //getters
    public String getName(){
        return this.name;
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
    public Body getBody(){
        return this.body;
    }
    public Inventory getInv() {
        return inv;
    }
    
    public int getLvl() {
        return level;
    }

    public SpellBag getSpellBag() {
        return spellbag;
    }
    public int getLane() {
        return lane;
    }

    public int getHP() {
        return HP;
    }

    public int getMoney() {
        return money;
    }
    //begin setters

    public void setHP(int HP) {
        this.HP = HP;
    }
    
    public void setMoney(int money) {
        this.money = money;
    }
    public void addMana(int w){
        this.mana+=w;
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
   
   public void growHP(double w){//grow by addition
        this.HP+=w;
        if(this.HP<0){
            this.HP=0;
        }
    }
   public void growHPm(double w){//grow by multiplication
        this.HP *= w;
        if(this.HP<1){
            this.HP=0;
        }
    }
   public void growManam(double w){
        this.mana*=w;
    }

    @Override
    public boolean move(Board b, char dir) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean rt = false;
        rt = b.movehr(this, dir);
        return rt;
    }

    @Override
    public boolean teleport(Board b, int newLoc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean rt = false;
        rt = b.tele(this, newLoc);
        return rt;
    }
    
    
    public boolean turn(Board b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //aske the hero for an input
        //awsd - general movement, check monster conditions here
        //x - attack - choose the cell of the monster they want to attack
        //t - ask them to choose a lane, then a location to tp too
        //e (or i) - shows them the inventory allows them to equip or unequip weapons / armor
        //b - send the monster back to the nexus of that lane
        //q game ends
        boolean rt = true;
        boolean checking = true;
        while(checking){
            
            IOController IO = new IOController();
            char inp = IO.readInputChar();
            if(inp == MOVE_UP ||inp == MOVE_LEFT||inp == MOVE_RIGHT||inp ==MOVE_DOWN){
                if(!canfight(b)){
                    this.move(b, inp);
                    checking=false;
                }else{
                    System.out.println("You can't move without killing a monster!");
                }
            }else if(inp == TELE){
                //curently this doesnt handel bad inputs just for testing
            
                System.out.println("Will be smother implemention but for now just put in the new location");
                int ans = IO.readInputInt(0, b.getNumCells());
                this.teleport(b, ans);
                checking = false;
            }else if(inp == RTB){
                b.returnToBase(this);
                checking=false;
            }else if(inp == INV){
                //needs to be polished
                //and also allow for equiping and dequiping armor and weapons
                //basically we need a loop and more than a to string
                System.out.println(this.inv.toString());
            
            }else if(inp == QUIT){
                rt = false;
            }else if(inp == ATTACK){
                if(canfight(b)){
                    //attacking goes here
                    ArrayList<Monster> mAlive = mFight(b);
                    Fight ft;
                    if(mAlive.size()==1){
                        ft = new Fight(this,mAlive.get(0),b);
                    }else{
                        System.out.print("Enter the number for the monster you wanna fight with: ");
                        int size = mAlive.size();
                        int num = 1;
                        for(Monster m:mAlive){
                            System.out.println("["+num+"] "+m.getName());
                        }
                        IOController IO2 = new IOController();
                        int mNo = IO2.readInputInt(1,size);
                        ft = new Fight(this,mAlive.get(mNo-1),b);
                    }
                    ft.play();
                    System.out.println("You attacked");
                    checking=false;
                }else{
                    System.out.println("You cannot fight right now!");
                }
            }else{
                System.out.println("Please enter again");
            }
        }

        return rt;
    }
    
    
    private boolean canfight(Board b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //check monster in same cell
        boolean cur = false;
        int sameLoc = loc;
        if (b.locToRC(sameLoc)[0]>=0){
            if(Board.locToTile(sameLoc,b).containM()){
                cur=true;
            }
        }
        
        //check front cell-check 
        boolean frt = false;
        int frtLoc = loc-8;
        if (b.locToRC(frtLoc)[0]>=0){
            if(Board.locToTile(frtLoc,b).containM()){
                frt=true;
            }
        }
        //check neighbor cell - check accessible - check if on the same row=true
         boolean left =false;
         int lftLoc = loc-1;
         if (b.locToRC(lftLoc)[1]>=0){
             if(Board.locToTile(lftLoc,b).containM()){
                left=true;
            }
         }
          boolean right =false;
         int rgtLoc = loc+1;
         if (b.locToRC(loc)[1]%7!=0){
             if(Board.locToTile(rgtLoc,b).containM()){
                right=true;
            }
         } 
         if (!cur&&!frt&&!left&&!right){
             return false;
         }else{
             return true;
         }
        
    }
    private ArrayList<Monster> mFight(Board b){
        ArrayList<Monster> m = new ArrayList<Monster>();
        int sameLoc = loc;
        if (b.locToRC(sameLoc)[0]>=0){
            if(Board.locToTile(sameLoc,b).containM()){
                m.add(Board.locToTile(sameLoc,b).getMst());
            }
        } 
            
        int frtLoc = loc-8;
        if (b.locToRC(frtLoc)[0]>=0){
            if(Board.locToTile(frtLoc,b).containM()){
                m.add(Board.locToTile(frtLoc,b).getMst());
            }
        }
        boolean left =false;
         int lftLoc = loc-1;
         if (b.locToRC(lftLoc)[1]>=0){
             if(Board.locToTile(lftLoc,b).containM()){
                m.add(Board.locToTile(lftLoc,b).getMst());
            }
         }
        int rgtLoc = loc+1;
         if (b.locToRC(loc)[1]%7!=0){
             if(Board.locToTile(rgtLoc,b).containM()){
                m.add(Board.locToTile(rgtLoc,b).getMst());
            }
         }
        return m;
    }
    

    
}