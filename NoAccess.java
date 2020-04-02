import java.util.Scanner; 
/*
 * a market class
 * */

public class NoAccess extends Cell{
    //inherited instance: col, row, mark
    private String mark = "&";

    Scanner scanner = new Scanner(System.in);
    
    public NoAccess(int row, int col ){
        super(row, col,Mark.NONACCESS );
    }
    public void play(){
        System.out.println(RED_BOLD+"Y O U    C A N ' T    E N T E R   H E R E !"+ANSI_RESET);
        System.out.println();
    }
    public String getMark(){
        return this.mark;
    }
}