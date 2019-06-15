import java.util.*;

public class BTree<Key extends Comparable<Key>, Value> {

	private static int M = 4; 	// max children per node = M-1
	private Node root; 		// root of B-Tree
	private int height; 	// height of B-Tree
	private int size; 		// number of key-value pairs

	private static class Node {
		private int m; 		// number of children
		private Entry[] children = new Entry[M];
		private Node(int k) {
			m = k;
		}

	}

	private static class Entry {
		private Comparable key;
		private Object val;
		private Node next;
		public Entry(Comparable key, Object val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public BTree() {
		root = new Node(0);
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	public int height() {
		return height;
	}

	public Value get(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to get() cannot be null");
		return search(root, key, height);
	}

	public Value search(Node x, Key key, int ht) {
		Entry[] children = x.children;

		// external node
		if (ht == 0) {
			for (int j = 0; j < x.m; j++) {
				if (eq(key, x.children[j].key)) return (Value) children[j].val;
			}
		}

		// internal node
		else {
			for (int j = 0; j < x.m; j++) {
				if ((j+1 == x.m) || less(key, children[j+1].key)) {
					return search(children[j].next, key, ht-1);
				}
			}
		}

		return null;
	}

	public void put(Key key, Value val) {
		if (key == null) throw new IllegalArgumentException("argument key to put() cannot be null");
		Node u = insert(root, key, val, height);
		size++;
		if (u == null) return;

		// need to split root
		Node t = new Node(2);
		t.children[0] = new Entry(root.children[0].key, null, root);
		t.children[1] = new Entry(u.children[0].key, null, u);
		root = t;
		height ++;
	}

	public Node insert(Node h, Key key, Value val, int ht) {
		int j;
		Entry t = new Entry(key, val, null);

		// external node
		if (ht == 0) {
			for (j = 0; j < h.m; j++) {
				if (less(key, h.children[j].key)) break;
			}
		}

		// internal node
		else {
			for (j = 0; j < h.m; j++) {
				if ((j+1 == h.m) || (less(key, h.children[j+1].key))) {
					Node u = insert(h.children[j++].next, key, val, ht-1);
					if (u == null) return null;
					t.key = u.children[0].key;
					t.next = u;
					break;
				}
			}
		}

		for (int i = h.m; i > j; i--) {
			h.children[i] = h.children[i-1];
		}
		h.children[j] = t;
		h.m++;
		if (h.m < M) return null;
		return split(h);
	}

	public Node split(Node h) {
		Node t = new Node(M/2);
		h.m = M/2;
		for (int j = 0; j < M/2; j++) {
			t.children[j] = h.children[M/2 + j];
		}
		return t;
	}

    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }

    public String toString() {
    	return toString(root, height, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
    	StringBuilder s = new StringBuilder();
    	Entry[] children = h.children;

    	if (ht == 0) {
    		for (int i = 0; i < h.m; i++) {
    			s.append(indent + children[i].key + " " + children[i].val + "\n");
    		}
    	} else {
    		for (int i = 0; i < h.m; i++) {
    			if (i > 0) {
    				s.append(indent + "(" + children[i].key + ")\n");
    			}
    			s.append(toString(children[i].next, ht-1, "    "));
    		}
    	}
    	return s.toString();
    }

    public static void main(String[] args) {
        BTree<String, String> bt = new BTree<String, String>();

        bt.put("www.malwared.com", "104.18.55.121");
        bt.put("www.github.com", "192.30.255.113");
        bt.put("www.reddit.com", "151.101.1.140");
        bt.put("www.google.com", "216.58.217.46");
        bt.put("www.nytimes.com", "199.239.136.200");
       	bt.put("www.twitter.com", "104.244.42.193");
       	bt.put("www.clearwateranalytics.com", "104.16.68.86");

        System.out.println("size:    " + bt.size());
        System.out.println("height:  " + bt.height());
        System.out.println(bt);
        System.out.println();
    }
}














