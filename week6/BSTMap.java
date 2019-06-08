import java.util.*;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V> {

	private Node root;
	private int size;

	public BSTMap() {
		root = null;
		size = 0;
	}

   /* Returns the number of key-value mappings in this map. */
   @Override
    public int size() {
    	return size;
    }

    @Override
    public void clear() {
        root = null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
    	return get(key) != null;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. 
     */
    @Override
    public V get(K key) {
    	return get(root, key);
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
    	root = put(root, key, value);
    }
    
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {
    	if (root == null) {
    		System.out.println("None");
    	} else {
    		printInOrder(root);
    	}
    }

	private class Node {
		private K key;
		private V value;
		private Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private V get(Node n, K key) {
		if (n == null) return null;
		int cmp = key.compareTo(n.key);
		if (cmp > 0) {
			return get(n.right, key);
		} else if (cmp < 0) {
			return get(n.left, key);
		} else {
			return n.value;
		}
	}

	private Node put(Node n, K key, V value) {
		if (n == null) return new Node(key, value);
		int cmp = key.compareTo(n.key);
		if (cmp > 0) {
			n.right = put(n.right, key, value);
		} else if (cmp < 0) {
			n.left = put(n.left, key, value);
		} else {
			n.value = value;
		}
		return n;
	}

	private void printInOrder(Node n) {
		if (n.left == null && n.right == null) {
			System.out.println(n.key.toString());
		} else if (n.left != null && n.right == null) {
			printInOrder(n.left);
			System.out.println(n.key.toString());
		} else if (n.left == null && n.right != null) {
			printInOrder(n.right);
			System.out.println(n.key.toString());
		} else {
			printInOrder(n.left);
			System.out.println(n.key.toString());
			printInOrder(n.right);
		}
	}

	public static void main(String[] args) {
		BSTMap<String, Integer> bst = new BSTMap<String, Integer>();
		bst.put("A", 5);
		bst.put("B", 3);
		bst.put("C", 4);
		bst.put("D", 0);
		bst.put("E", 9);
		bst.put("F", 6);
		bst.printInOrder();
	}

}