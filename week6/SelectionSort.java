import java.util.Arrays;

public class SelectionSort {

	public static void sort(int[] arr, int start) {
		if (start == arr.length - 1) return;
		for (int i = start + 1; i < arr.length; i++) {
			if (arr[i] < arr[start]) {
				int tmp = arr[start];
				arr[start] = arr[i];
				arr[i] = tmp;
			}
		}
		sort(arr, start + 1);
	}

	public static void main(String[] args) {
		int[] arr = new int[]{4,9,0,1,7,3,8,6,5,2};
		System.out.println(Arrays.toString(arr));
		sort(arr, 0);
		System.out.println(Arrays.toString(arr));
	}
}
