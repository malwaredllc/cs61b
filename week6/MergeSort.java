import java.util.Arrays;

public class MergeSort {

	public static void sort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			sort(arr, lo, mid);
			sort(arr, mid + 1, hi);
			merge(arr, lo, mid, hi);
		}
	}

	public static int[] merge(int[] arr, int lo, int mid, int hi) {
		int i = 0;
		int j = 0;
		int k = lo;

		// Create temporary right and left subarrays
		int[] left = new int[mid - lo + 1];
		int[] right = new int[hi - mid];
		System.arraycopy(arr, lo, left, 0, mid - lo + 1);
		System.arraycopy(arr, mid + 1, right, 0, hi - mid);


		// Merge sorted subarrays
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}

		// Copy remaining items from left subarray, if any
		if (i < left.length) {
			System.arraycopy(left, i, arr, k, left.length - i);
		}

		// Copy remaining items from right subarray, if any
		if (j < right.length) {
			System.arraycopy(right, j, arr, k, right.length - j);
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{4,9,0,1,7,3,8,6,5,2};
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
