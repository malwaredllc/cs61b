/* Weighted Union Find (Disjoint Sets) */
public class DisjointSets {
	public int[] nodes;
	
	/* Constructor */
	public DisjointSets() {
		nodes = new int[]{-6, 0, 0, 0, 0, 0, -4, 6, 6, 8};
	}

	/* Throws exception if index v1 is invalid */
	public void validate(int v1) {
		if (v1 >= nodes.length) {
			throw new IndexOutOfBoundsException(v1 + " is not a valid index");
		}
	}

	/* Returns size of set v1 belongs to */
	public int sizeOf(int v1) {
		return nodes[find(v1)] * -1;
	}

	/* Returns parent of v1. */
	public int parent(int v1) {
		return nodes[v1];
	}

	/*  Returns true if nodes v1 and v2 are connected. */
	public boolean connected(int v1, int v2) {
		return find(v1) == find(v2);
	}

	/* Connects two elements v1 and v2 together. */
	public void union(int v1, int v2) {
		// Validate v1 and v2 are valid indexes
		validate(v1);
		validate(v2);

		// Get size of trees v1 and v2 belong to
		int size1 = sizeOf(v1);
		int size2 = sizeOf(v2);

		// Find roots of trees v1 and v2 belong to
		int root1 = find(v1);
		int root2 = find(v2);

		// Connect root of smaller tree to root of larger tree and update size of tree
		if (size1 < size2) {
			nodes[root1] = root2;
			nodes[root2] -= size1;
		} else {
			nodes[root2] = root1;
			nodes[root1] -= size1;
		}
	}

	/* Returns root of set v1 belongs to */
	public int find(int v1) {
		int p = parent(v1);
		if (p < 0) {
			return v1;
		}
		return find(p);
	}

	public static void main(String[] args) {
		// Get arguments from command line
		if (args.length != 2) {
			throw new IllegalArgumentException("2 integers required as arguments");
		}
		DisjointSets ds = new DisjointSets();
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);

		ds.union(m, n);

		if (ds.connected(m, n)) {
			System.out.println("Element " + m + " is connected to element " + n);
		} else {
			System.out.println("Element " + m + " is not connected to element " + n);
		}
	}

}

