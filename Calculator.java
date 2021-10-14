import java.util.ArrayList;
public class Calculator{
    public static void main(String[] args){
        Calculator myday = new Calculator();
        Calculator add1 = new Calculator();
        Calculator subtr = new Calculator();
        Calculator mult = new Calculator();
        Calculator remain = new Calculator();

        System.out.println(myday.weekday("blah"));
        System.out.println(add1.add(45,54));
        System.out.println(subtr.subtract(30,20));
        System.out.println(mult.multiply(2,4));
        System.out.println(remain.remainder(55,3));
    }
    public int add(int a, int b){
        return a+b;
    }
	public int subtract(int a, int b){
        return a-b;
    }
	public double multiply(double a, double b){
        return a*b;
    }
	public int remainder(int a, int b){
        return a%b;
    }
	public String weekday(String weekday){
        String [] dayArray = {"monday", "tuesday", "wednesday", "thursday", "friday"};
        String test = "Not a weekday.";
        for (String element : dayArray) {
            if (element == weekday.toLowerCase()) {
                test = "Yes it is a weekday";
                return test;
            }
        }
         return test;
    }
}