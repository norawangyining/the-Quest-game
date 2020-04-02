
import java.util.*; 

public class theQuestBoard extends Board{
    /*Inherited
    public int width ;
    public int height;
    private Cell[][] cells;
    */
    private int numMarkets = 19;
    private int numNonAccess = 13;
    private int numCommon = 32;
    Random ran = new Random();
    
    public theQuestBoard(int w, int h){
        super(w,h);
    }
    public theQuestBoard(int side){
        super(side);
        int index;
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("common");
        choices.add("market");
        choices.add("nonAccess");
     
        for(int r = 0; r < side; r++){
            for(int c = 0; c < side;c++) {
                if (r==0 && c==0){
                    cells[r][c] = new Common(r,c);
                    numCommon--;
                
                }else if (r==0 && c==1){
                    cells[r][c] = new Market(r,c);
                    numMarkets--;
                
                }
                else{
                index= ran.nextInt(choices.size());
             
                if(choices.get(index) == "common"){
                    cells[r][c] = new Common(r,c);
                    numCommon--;
                    if (numCommon==0){
                        choices.remove("common");
                    }
                }else if (choices.get(index) == "market"){
                    cells[r][c] = new Market(r,c);
                    numMarkets--;
                    if (numMarkets==0){
                        choices.remove("market");
                    }
                }else if (choices.get(index) == "nonAccess"){
                    cells[r][c] = new NoAccess(r,c);
                    numNonAccess--;
                    if (numNonAccess==0){
                        choices.remove("nonAccess");
                    }
                }
                }}
        }
    }
    public void setCells(int side){
        int[][] arr =  new int[side][side];
        boolean found = false;
    }
        
    public static void main(String[] args) {
        theQuestBoard b = new theQuestBoard(8);
        b.display();
    }
    
}