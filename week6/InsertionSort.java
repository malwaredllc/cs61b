import java.util.Arrays;

public class InsertionSort {

	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && key < arr[j]) {
				int tmp = arr[j];
				arr[j] = arr[j + 1];;
				arr[j + 1] = tmp;
				j--;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{4,9,0,1,7,3,8,6,5,2};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
