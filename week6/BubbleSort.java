import java.util.Arrays;

public class BubbleSort {

	public static void sort(int[] arr) {
		boolean done = false;
		while (!done) {
			done = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					done = false;
				}
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
