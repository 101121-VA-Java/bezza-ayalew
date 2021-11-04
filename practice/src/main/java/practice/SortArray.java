package practice;

public class SortArray {

	public static void main(String[] args) {
		int[] toSort = { 28, 22, 25, 26};
		SortArray testSort = new SortArray();
		System.out.println(testSort.sortArray(toSort));
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
	
	public int sortArray(int[] arr) {

		int z = 0;
		if (arr.length < 2) {
			return 1;
		}
		int[] newArray = arr.clone();
		for (int x = 0; x < arr.length - 1; x++) {
			int y = x + 1;
			while (y < arr.length) {
				if (arr[y] < arr[x]) {
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
				y++;
			}
		}
		for (int i = 0; i < newArray.length; i++) {
			if (arr[i] == newArray[i]) {
				z++;
			}
		}
		return z;
	}
}
