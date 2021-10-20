
import java.util.Scanner;

public class ScannerDriver {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		System.out.println("Hello World!");
//		System.out.println("What's your name?");
//		
//		String name = sc.nextLine();
//		
//		System.out.println("Hello " + name);
//		System.out.println("Pick a number:");
//		
//		int num = sc.nextInt();
//		sc.nextLine(); // this sc.nextLine() flushes/grabs the leftovers from the previous input capture
//		String number = sc.nextLine();
		// some validation
//		int num = Integer.parseInt(number);
		
//		System.out.println("You picked " + num);
//		
//		ScannerDriver.loginScreen();
		
		// Please close your resources people
//		sc.close();
		
		/*
		 * Create a menu that gives a user multiple options:
		 * 		- 1: get a random number
		 * 		- 2: Using StringBuffer, reverse a word of the user's choice
		 * 		- 3: exit the program
		 * This menu should repeat until the user decides to exit.
		 */
		printMegaBytesAndKiloBytes(2500);

//		menu();
//		boolean playing = true;
//		while(playing) {
//			String userInput = sc.nextLine();
//			switch(userInput){
//				case "1":
//					int yourNumber = (int)(Math.random()*100);
//					System.out.println(yourNumber);
//					break;
//				case "2":
//					System.out.println("give me a word");
//					StringBuffer newStr = new StringBuffer(sc.nextLine());
//					System.out.println(newStr.reverse());
//					break;
//					
//				default:
//					System.out.println("Good bye!");
//					playing = false;
//			}
//		}
	}
	public static String printMegaBytesAndKiloBytes(int kiloBytes) {
		// TODO Write an implementation for this method declaration
		float mb = (float)(kiloBytes/1024);
		System.out.println(mb);
		int partMb = (int)mb;
		float decimalPart = kiloBytes - partMb;
		System.out.println(decimalPart);
//		int kb = (int)(1000 * ((kiloBytes * 0.0009765625) - mb));
		int kb = (int)(100 * decimalPart);
		System.out.println(kb);
		if(kiloBytes < 0) {
			return "Invalid Value";
		}else {
			return String.format("%d KB = %d MB and %d KB", kiloBytes, partMb, kb);
			
		}
	}
	
	public static void menu() {
		System.out.println("1: get a random number\n2: reverse a word\n3: exit the program\n");

	}
		

	
	
//	public static void loginScreen() {
//		String uname = "admin";
//		String pass = "pass";
//		
//		System.out.println("Please enter your username:");
//		String username = sc.nextLine();
//		System.out.println("Please enter your password:");
//		String password = sc.nextLine();
//		if(uname.equals(username) && pass.equals(password)) {
//			System.out.println("You're logged in.");
//		} else {
//			System.out.println("Not quite.");
//		}
//	}
}
