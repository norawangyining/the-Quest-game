import java.util.Scanner; 
import java.util.*;

public class PlayGame implements TerminalColor{
    boolean playAgain = false;
    boolean checking;
    Scanner scanner = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    
    
    public void playAgain(){
        System.out.println("Do you want to play it again? Press [yes] or [no]");
        checking =true;
        while(checking){
              String choice = input.nextLine();
              if(choice.equals("no")){
                  playAgain = false;
                  
              }else if(choice.equals("yes")){
                  playAgain =true;
                  checking =false;

              }else{
                  System.out.print(ANSI_RED +"please enter again: "+ANSI_RESET);
              }
        } 

    }
    public void start(){
       do{
           Quest q = new Quest();
            q.startGame();
            playAgain();
        }while(playAgain); 
    }
    
    public static void main(String[] args){
        PlayGame g= new PlayGame();
        g.start();
    
    }
}