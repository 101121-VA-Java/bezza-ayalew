public class Test{
  public static void main(String[] args){
      System.out.println("This is test");
  }

	public static int[] order(int[] intArr){
		for (int i = intArr.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
                		if (intArr[j] > intArr[j + 1]) {
                    			int temp = intArr[j];
                    			intArr[j] = intArr[j + 1];
                    			intArr[j + 1] = temp;
               			}		
            		}		
		}		
        return intArr;
	}
}

