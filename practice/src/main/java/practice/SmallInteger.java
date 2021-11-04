package practice;

public class SmallInteger {

	public static void main(String[] args) {
		int[] arr = {6,6,7, 5, 4, 2, 1, 8};
		SmallInteger test = new SmallInteger();
		System.out.println(test.smallInteger(8, 6, arr));

	}
	public int smallInteger(int N, int X, int A[]) {
		int[] temp = SortArray.sortArray(A);
		int num = 0;
		for(int i = 0; i < N; i++) {
			if(temp[i] <= X) {
				continue;
			}
			num = temp[i];
			break;
		}
		return num;
	}
//	public static int[] sortArray(int[] arr) {
//		if (arr.length < 2) {
//			return arr;
//		}
//		int[] sorted = arr.clone();
//		for (int x = 0; x < sorted.length - 1; x++) {
//			int y = x + 1;
//			while (y < sorted.length) {
//				if (sorted[y] < sorted[x]) {
//					int temp = sorted[x];
//					sorted[x] = sorted[y];
//					sorted[y] = temp;
//				}
//				y++;
//			}
//		}
//		
//		return sorted;
//	}
}
