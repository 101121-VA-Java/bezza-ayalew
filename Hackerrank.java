public class Hackerrank{
    public static void main(String[] args){
        int[] testArray = {1,2,3,4};
        System.out.println(simpleArraySum(testArray));
    }
    public static int simpleArraySum(int[] input){
        int sum = 0;
        for (int i:input){
            sum+=i;
        }
        return sum;
    }
}