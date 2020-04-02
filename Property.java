/**
 * propertoes heores can but on the Market
 */
public class Property {
    
    protected String name;
    protected int price;
    protected int minimumLevel;
    
    public Property(String name, int price, int minimunLevel){
        this.name = name;
        this.price=price;
        this.minimumLevel = minimunLevel;
    }
    public void display(){
        System.out.println("Not this");
    };
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
    public String getType(){return "";};
    public int getDamage(){return 0;};
        
  
}
