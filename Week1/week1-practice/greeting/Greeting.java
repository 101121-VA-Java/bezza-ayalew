import java.util.Scanner; 
public class Greeting{

    public static void main(String[] args){
        greeting();
    }
    public static void greeting(){
        Scanner friend = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = friend.nextLine();
        System.out.println( "Hello "+ name +".");
    }
}