import java.util.Arrays;

public class QuickSort {

	public static void sort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			int index = partition(arr, lo, hi);
			sort(arr, lo, index - 1);
			sort(arr, index + 1, hi);
		}
	}

	public static int partition(int [] arr, int lo, int hi) {
		int pivot = arr[hi];
		int index = lo;
		for (int i = lo; i < hi; i++) {
			if (arr[i] <= pivot) {
				int tmp = arr[index];
				arr[index] = arr[i];
				arr[i] = tmp;
				index++;
			}
		}

		int tmp = arr[index];
		arr[index] = arr[hi];
		arr[hi] = tmp;

		return index;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{4,9,0,1,7,3,8,6,5,2};
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
