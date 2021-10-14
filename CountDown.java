public class CountDown{
    public static void main(String[] args){
        countdown(-1);
    }
    public static void countdown(int startValue) { 
        if(startValue < 0){
            System.out.println("input must be positive or 0.");
        }
        while(startValue >=0){
            System.out.println(startValue);
            startValue-=1;
        }
    }
}