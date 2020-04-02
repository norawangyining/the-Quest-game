
/**
 * A mark instance could be any symbols. 
 */
public enum Mark {
        
    EMPTY(" "),    
    COMMON(" "),
    MARKET("M"),
    NONACCESS("&"),
    CURRENT("X");

    private final String text;

    private Mark(String text) {
        this.text = text;
    }

    public String toString() {
         return text;
    }
       
    
    
}