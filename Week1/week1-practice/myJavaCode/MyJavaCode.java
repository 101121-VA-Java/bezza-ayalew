public class MyJavaCode {
	public static void main (String[] args){
		
		// declaring and initializing variables
		int num = 5;
		char ch = 'A';
		double  dbl = 2.56;

		System.out.println("your first variables is: " + num);

		// control flow statements
		float fl = 1.5f;
		if(fl < dbl){
			System.out.println("why  waste memory space?");
		}else{
			System.out.println("ok");
		}
		for(char ch2 = 'D'; ch2>ch; ch++){
			System.out.println(ch);
		}
	}
}
