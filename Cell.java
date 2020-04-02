import java.util.*; 
/**
 * Auto Generated Java Language Level Class.
 */
public class Cell implements TerminalColor{
    private Mark content;
    private Mark originalContent;
    private int col,row;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.content = Mark.EMPTY; 
    }
    public Cell(int row, int col, Mark content) {
        this.row = row;
        this.col = col;
        this.content = content; 
    }
    
    
    public void clearCell(){
        content = Mark.COMMON;
    }
    public Mark getContent(){
        return content;
    }
    public void setContent(Mark m){
        this.originalContent = this.content;
        this.content = m;
    }
    public void printCell(){
        switch(content){
            case EMPTY:
                System.out.print(" "); 
                break;
            case COMMON: 
                System.out.print(" "); 
                break;
            case CURRENT:
                //blue
                System.out.print(ANSI_BLUE +"X"+ ANSI_RESET);
                
                break;
            case NONACCESS:
                //red
                System.out.print(ANSI_RED+"&"+ANSI_RESET);
                break;
            case MARKET:
                
                System.out.print(ANSI_YELLOW+"M"+ANSI_RESET);
        }
       
    }
    public void setContentBack(){
        this.content = this.originalContent;
        
    }
    public static void main(String[] args) {
        Cell cell = new Cell(2,3,Mark.MARKET);
        cell.printCell();
    }
    public void play(HeroTeam team){}
      
}

    
  
    
    

