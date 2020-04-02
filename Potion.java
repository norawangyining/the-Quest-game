import java.util.Scanner; 
import java.util.*; 
/**
 * An Potion class
 */
public class Potion extends Property implements Setting{
    private int attributeIncrease;
    Scanner scanner = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    boolean checking = true;
    public Potion(String name,int price, int minimumLevel, int attributeIncrease){
        super(name,price, minimumLevel);
        this.attributeIncrease = attributeIncrease;
    }
    
    public void display(){
        System.out.println("Potion: " +this.name+" Attribute Increase"+ this.attributeIncrease );
    }
    public String getType(){
        return "Potion";
    }
    public void play(Hero h){
        System.out.println("Enter the number of attribute (Strength[1],Agility[2], Dexterity[3] you want to incease: ");
        checking =true;
        while(checking){
            int choice = input.nextInt();
            if(choice ==1){
                h.addStrength(this.attributeIncrease);
                System.out.println("Strength +"+this.attributeIncrease);
                checking=false;
            }else if(choice ==2){
                h.addAgility(this.attributeIncrease);
                System.out.println("Agility +"+this.attributeIncrease);
                checking=false;
            }else if(choice ==3){
                h.addDexterity(this.attributeIncrease); 
                System.out.println("Dexterity +"+this.attributeIncrease);
                checking=false;
            }else{
                System.out.print("please enter again: ");
            }    
        }
    }
    public static void main(String[] args) {
        Potion p = new Potion("Healing_Potion",250, 1,100);
        p.play(Gaerdal_Ironhand);
    }
}