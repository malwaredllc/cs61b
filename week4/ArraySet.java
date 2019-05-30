import java.util.Iterator;

/* Array-based set data structure */
public class ArraySet<T> implements Iterable<T> {
	
	private T[] items;
	private int size;

	/* Array set iterator */
	private class ArraySetIterator<T> implements Iterator<T> {
		private int position;

		/* Constructor */
		public ArraySetIterator() {
			position = 0;
		}

		/* Returns true if iterator has not reached end of array set */
		public boolean hasNext() {
			return position < size;
		}

		/* Returns element from array set at index position */
		public T next() {
			T item = (T) items[position];
			position++;
			return item;
		}

		public void remove() {
			return;
		}
	}

	/* Constructor */
	public ArraySet() {
		items = (T[]) new Object[100];
		size = 0;
	}

	/* Returns true if this map contains a mapping for the specified key */
	public boolean contains(T x) {
		for (int i = 0; i < size; i++) {
			if (items[i].equals(x)) {
				return true;
			}
		}
		return false;
	}

	/* Associates the specified value with the specified key */
	public void add(T x) {
		if ((x == null) || contains(x)) {
			return;
		}
		items[size] = x;
		size++;
	}

	/* Returns the number of key-value mappings */
	public int size() {
		return size;
	}

	/* Returns an iterator */
	public Iterator<T> iterator() {
		return new ArraySetIterator();
	}

	public static void main(String[] args) {
		ArraySet<String> s = new ArraySet<String>();
		s.add("i");
		s.add("am");
		s.add("a");
		s.add("moose");
		s.add("i");
		s.add("am");
		s.add("a");
		s.add("moose");
		for (String i : s) {
			System.out.println(i);
		}
	}
}
