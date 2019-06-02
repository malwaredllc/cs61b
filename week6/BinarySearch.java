public class BinarySearch {

	public static int search(String[] sorts, String x, int lo, int hi) {
		if (lo > hi) return -1;
		int mid = (lo + hi) / 2;
		int cmp = x.compareTo(sorts[mid]);
		if (cmp < 0) return search(sorts, x, lo, mid);
		else if (cmp > 0) return search(sorts, x, mid, hi);
		else return mid;
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Enter a letter of the alphabet as an argument");
			return;
		}
		String letter = args[0];
		String[] test = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		int index = search(test, letter, 0, test.length);
		System.out.println(letter + " is at index " + index);
	}
}
