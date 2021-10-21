public class ArrayExcercise{
    public static void main(String[] args){
        String[] letters = {"A","B","C","D"};
        String[] reversed = reverse(letters);
        for (int i = 0; i < reversed.length; i++){
	        System.out.println(reversed[i]);
        }
    }
    public static String[] reverse(String[] arr){
	    for (int i = 0; i < arr.length/2; i++){
            String temp = arr[i];
	        arr[i] = arr[arr.length-1 - i];
	        arr[arr.length-1-i] = temp;
	    }

        return arr;
    }

}

	    