public class SelectionSort {
  
  /* Sorts array of strings using selection sorting algorithm */
  public static void sort(String[] x) {
  	for (int i = 0; i < x.length; i++) {
  		int smallest = findSmallest(x, i, x.length);
  		swap(x, i, smallest);
  	}
  }
  
  /* Swaps two elements in an array of strings */
  private static void swap(String[] x, int a, int b) {
  	String temp = x[b];
  	x[b] = x[a];
  	x[a] = temp;
  }

  /* Returns index of lexicographically smallest string in a subarray of strings */
  private static int findSmallest(String[] x, int a, int b) {
  	int smallest = a;
  	for (int i = a; i < b; i++) {
  		if (x[i].compareTo(x[smallest]) < 0) {
  			smallest = i;
  		}
  	}
  	return smallest;
  }
  
  /* Test selection sort */
  public static void main(String[] args) {
	String[] input = {"i","have","an","egg"};
	String[] expected = {"an","egg","have","i"};

	SelectionSort.sort(input);

	for (int i = 0; i < expected.length; i++) {
		if (!input[i].equals(expected[i])) {
			System.out.println("Error: mismatch in position " + i + ", expected: " + expected[i] + ", but got: " + input[i]);
			return;
		}
	}
  }
}
