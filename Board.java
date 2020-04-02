
public class Board {
    protected int width ;
    protected int height;
    protected Cell[][] cells;
    //Constructor
    public Board(int w, int h){
        
        setWidth(w);
        setHeight(h);
        cells = new Cell[w][h];
        for( int r = 0; r < w; r++) {
            for (int c = 0; c < h;c++) {
                cells[r][c] = new Cell(r,c);
                cells[r][c].clearCell();
            }
        }  
    } 
    public Board(int side){
        setWidth(side);
        setHeight(side);
        cells = new Cell[side][side];
    }
    public Cell getCell(int r, int c){
        return  this.cells[r][c];
    }
    public void setWidth(int w){
        if(w<=0){
            throw new IllegalArgumentException();
        }
        this.width = w;
    }
    
    public void setHeight(int h){
        if(h<=0){
            throw new IllegalArgumentException();
        }
        this.height = h;
    }
    //A method to prints out the board
    public void display(){
        System.out.print("   ");
        for (int i = 0; i<this.height;i++){
            if(i>=10){
                System.out.print(i+" ");
            }else{
                System.out.print(" "+i+" ");}
        }
        System.out.println();
        for(int r = 0; r<this.width; r++){
            int rowNum = r;
            System.out.print(" "+rowNum+" ");
            for(int c =0; c<this.height;c++){
                System.out.print("[");
                cells[r][c].printCell();
                System.out.print("]");
            }
            System.out.println();
            //int rowNum = r;
            //System.out.println(" "+rowNum+" ");
            //System.out.println();
        }
    }
    public void clearBoard(){
        for( int r = 0; r < width; r++) {
            for (int c = 0; c < height;c++) {
                cells[r][c].clearCell();
            }
        }
    }
    public void markCell(int r, int c,Mark m){
        this.cells[r][c].setContent(m);
    }
    
    
    
    public static void main(String[] args) {
     
        
    }
    

}

