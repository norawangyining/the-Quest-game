import java.util.Scanner; 
import java.util.*; 

public class Quest implements Setting, TerminalColor{
    //ArrayList<String> teamNames =new ArrayList<String>() ;
    //public ArrayList<Hero> team = new ArrayList<Hero>();
    private HeroTeam team = new HeroTeam();
    private Monster monster;
    private theQuestBoard gameBoard;
    private int numHeroes;
    private int[] currentLocation = new int[]{0,0};
    private int[] tempLocation=new int[]{0,0};
    Scanner scanner = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    String choice;
    boolean checking =true;
   
    
    boolean exit = false;
     //constructor 
    public Quest(){
        this.gameBoard = new theQuestBoard(8);
        gameBoard.getCell(0,0).setContent(Mark.CURRENT);    
    }
    
    //Welcome Message
    public void welcome(){
        
        System.out.println(PURPLE_BOLD+"Welcome to the Quest!"+ANSI_RESET);
        System.out.println();
        //background info(optional)
        System.out.print("Do you want to view the basic infomation for the game? Press [yes] or [no] to start the game immediately."+ANSI_RESET);
        checking =true;
        while(checking){
              choice = input.nextLine();
              if(choice.equals("no")){
                  checking=false;
                  
              }else if(choice.equals("yes")){
                  checking =false;
                  gameInfo();
                  break;
              }else{
                  System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
              }
        } 
        System.out.println();
    }
    
    //basic information of theQuest
    public void gameInfo(){
        //movement instructions 
        System.out.println();
        System.out.println("       "+ANSI_YELLOW+"Basic Infomation"+ANSI_RESET);
        System.out.println("       ==================");
        System.out.println();
        System.out.println();
        System.out.println("       For movement:    "+ANSI_YELLOW+"W"+ANSI_RESET+" - move forward");
        System.out.println("                        "+ANSI_YELLOW+"A"+ANSI_RESET+" - move left");
        System.out.println("                        "+ANSI_YELLOW+"D"+ANSI_RESET+" - move right");
        System.out.println("                        "+ANSI_YELLOW+"S"+ANSI_RESET+" - move backwards");
        System.out.println();
        System.out.println("       You can't move diagonally!");
        System.out.println("       You can buy up to THREE heroes for your adventure");
        System.out.println("       To "+ANSI_PURPLE+"QUIT"+ANSI_RESET+" the game, press q whenever you want to make a move. You cannot exit when you are in market or in a fight.");//quit the game 
        System.out.println();
        //press start whenever you are ready!   
        System.out.println("Press [start] whenever your are ready!");
        checking =true;
        while(checking){
              choice = input.nextLine();
              if(choice.equals("start")){
                  checking=false;
                  break;
              }else if(choice.equals("q")){
                  checking =false;
                  quitGame();
                  break;
              }else{
                  System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
              }
        }       
    }
    
    public void formTeam(){
        System.out.println("                                    "+PURPLE_BOLD+"* Choose your Team *"+ANSI_RESET);
        boolean addTeammates = true;
        //show avaliable Warriors, Sorcerers and Paladins
        System.out.println(ANSI_YELLOW+"Available Warriors"+ANSI_RESET);
        System.out.println("*******************");
        System.out.println();
        System.out.println("Name                   Magic Power         Health Power        Strength        Agility       Dexterity       Experience");
        for(Hero w: warriors){
            w.displayInfo();
           
        }
        System.out.println();
        
        System.out.println(ANSI_YELLOW+"Available Sorcerers"+ANSI_RESET);
        System.out.println("*******************");
        System.out.println();
        System.out.println("Name                   Magic Power         Health Power        Strength        Agility       Dexterity       Experience");
        for(Hero s: sorcerers){
            s.displayInfo();
            
        }
        System.out.println();
        
        System.out.println(ANSI_YELLOW+ "Available Paladins"+ANSI_RESET);
        System.out.println("*******************");
        System.out.println();
        System.out.println("Name                   Magic Power         Health Power        Strength        Agility       Dexterity       Experience");
        for(Hero p: paladins){
            p.displayInfo();
          
        }
        System.out.println();
        
        while(addTeammates==true){          
        //Enter heroe's Name, 
            if(team.getSize()==3){
                break;
            }
            System.out.println("Enter Hero's name(you can choose up to three heroes): ");
            checking =true;
            while(checking){
                String hero= input.nextLine();
                //Either enter the wring name, or the same name before will be asked to enter again. 
                if(team.addMember(hero)){checking=false;
        
                }else if(hero.equals("q")){
                  checking =false;
                  quitGame();
                  break;
              }else{
                    System.out.print(ANSI_RED+ "please enter again(You must enter the wrong name, or entered the name already chosen): "+ANSI_RESET);
                }
            }

            if(team.getSize()==3){
                break;
            }
        //check if they want more teams
            System.out.print("Do you want to add more hero to your team? Press [yes] or [no].");
            checking =true;
            while(checking){
              choice = input.nextLine();
              if(choice.equals("no")){
                  addTeammates=false;
                  checking=false;
              }else if(choice.equals("yes")){
                  checking =false;
                  break;
              }else if(choice.equals("q")){
                  checking =false;
                  quitGame();
                  break;
            }else{
                  System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
              }
        }     
        }   
        //show team members:
        team.teamInfo();
        System.out.println("You can access to "+ANSI_PURPLE+"Team Info"+ANSI_RESET+" any time by press [i]");
    }
   
    public void displayGrid(){
        gameBoard.display();
        System.out.println(ANSI_BLUE +"X"+ ANSI_RESET+": Current Location    "+ANSI_YELLOW+"M"+ANSI_RESET+": Market      "+ANSI_RED+"&"+ANSI_RESET+": NonAccessible");
        System.out.println();    
    }
    
    public void currentLocation(){
        System.out.println("Your current location is at "+ ANSI_RED+currentLocation[0] + "x" + currentLocation[1]+ANSI_RESET);
        System.out.println();
    }
    /*
    public void teamInfo(){
        System.out.println();
        System.out.println("                                    "+PURPLE_BOLD+"* Your Team Member(s) *"+ANSI_RESET);
        System.out.println();
        System.out.println("Name                   Magic Power         Health Power        Strength        Agility       Dexterity       Experience");
        for(Hero h: team){
            h.displayInfo();
        }
        System.out.println(); 
        System.out.println();
        System.out.println();
    }*/
    public void move(){
        displayGrid();
        currentLocation();
        System.out.println("Enter your move: "+ANSI_YELLOW+"W"+ANSI_RESET+" - move forward");
        System.out.println("                 "+ANSI_YELLOW+"A"+ANSI_RESET+" - move left");
        System.out.println("                 "+ANSI_YELLOW+"D"+ANSI_RESET+" - move right");
        System.out.println("                 "+ANSI_YELLOW+"S"+ANSI_RESET+" - move backwards");
        checking =true;
        while(checking){
              choice = input.nextLine();
              if(choice.equals("W")){
                  if(currentLocation[0]!=0){
                      checking=false;
                      tempLocation[0] = currentLocation[0]-1;
                      tempLocation[1] = currentLocation[1];
                  }else{System.out.print(ANSI_RED +"Wrong Move! please enter again: "+ANSI_RESET);}
              }else if(choice.equals("A")){
                  if(currentLocation[1]!=0){
                      checking=false;
                      tempLocation[0] = currentLocation[0];
                      tempLocation[1] = currentLocation[1]-1;
                      
                  }else{System.out.print(ANSI_RED +"Wrong Move! please enter again: "+ANSI_RESET);}
              }else if (choice.equals("D")){
                 if(currentLocation[1]!=7){
                      checking=false;
                      tempLocation[0] = currentLocation[0];
                      tempLocation[1] = currentLocation[1]+1;
                  }else{System.out.print(ANSI_RED +"Wrong Move! please enter again: "+ANSI_RESET);}
              }else if (choice.equals("S")){
                  if(currentLocation[0]!=7){
                      checking=false;
                      //currentLocation[0]++;
                      tempLocation[0] = currentLocation[0]+1;
                      tempLocation[1] = currentLocation[1];
                  }else{System.out.print(ANSI_RED +"Wrong Move! please enter again: "+ANSI_RESET);}
              }else if (choice.equals("q")){
                  checking =false;
                  quitGame();
                  break;
              }else if (choice.equals("i")){
                  team.teamInfo();
              }else{
                  System.out.print(ANSI_RED +"Wrong Move! please enter again: "+ANSI_RESET);}
        }
        //Cell templocation = gameBoard.getCell(tempLocation[0],tempLocation[1]);
        System.out.println(gameBoard.getCell(tempLocation[0],tempLocation[1]).getContent() == Mark.NONACCESS);
        if(gameBoard.getCell(tempLocation[0],tempLocation[1]).getContent() == Mark.NONACCESS){
            System.out.println(RED_BOLD+"Y O U    C A N ' T    E N T E R   H E R E !"+ANSI_RESET+" Please enter agian.");
            System.out.println();
  
        }else{
            gameBoard.getCell(currentLocation[0],currentLocation[1]).setContentBack();
            currentLocation[0] = tempLocation[0];
            currentLocation[1]= tempLocation[1];
            gameBoard.getCell(currentLocation[0],currentLocation[1]).setContent(Mark.CURRENT);
            if(gameBoard.getCell(tempLocation[0],tempLocation[1]).getContent() == Mark.COMMON){
                Common cell = (Common)gameBoard.getCell(currentLocation[0],currentLocation[1]);
                cell.play(team);
                
            }else{
                gameBoard.getCell(currentLocation[0],currentLocation[1]).play(team);}
        }
    } 
    
    public void quitGame(){
        System.out.println();
        System.out.println();
        System.out.println(PURPLE_BOLD+"You've exited the game successfully."+ANSI_RESET);
        System.out.println();
        System.exit(0);
    }
    
    public void startGame(){
        welcome(); //internally calls gameInfo 
        formTeam();
        //currentLocation();
        System.out.println(PURPLE_BOLD+"Now, take a deep breath, and enter your move!"+ANSI_RESET);
        System.out.println();
        while(exit==false){
            move();}
        System.out.println(PURPLE_BOLD+"You've exited the game successfully."+ANSI_RESET);
    }
    
    public static void main(String[] args){
        Quest q = new Quest();
        q.startGame();
     
    }
}


