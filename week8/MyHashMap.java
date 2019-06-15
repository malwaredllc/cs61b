import java.util.Set;
import java.util.HashSet;

public class MyHashMap<K extends Comparable<K>,V> implements Map61B<K,V> {
	private int size = 0;
	private int capacity = 16;
	private double loadFactor = 0.75;
	private HashSet<K> keySet = new HashSet<K>();
	private int threshold;
	private Entry<K,V>[] table;

	public MyHashMap() {
		capacity = 16;
		loadFactor = 0.75;
		threshold = (int) loadFactor * capacity;
		table = new Entry[capacity];
	}

	public MyHashMap(int initialSize) {
		capacity = initialSize;
		loadFactor = 0.75;
		threshold = (int) loadFactor * capacity;
		table = new Entry[capacity];
	}

	public MyHashMap(int initialSize, double loadFactor) {
		capacity = initialSize;
		this.loadFactor = loadFactor;
		threshold = (int) loadFactor * capacity;
		table = new Entry[capacity];
	}

    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        size = 0;
        threshold = (int) (capacity*loadFactor);
        table = new Entry[capacity];
    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /* Returns a Set view of the keys contained in this map. Not required for HW6. */
    public Set<K> keySet() {
    	return keySet;
    }

   /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
    	return size;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. 
     */
    @Override
    public V get(K key) {
    	int hashcode = hash(key.hashCode());
    	int index = hashcode % capacity;
    	for (Entry<K,V> e = table[index]; e!= null; e = e.next) {
    		if (e.key.equals(key) && !e.deleted) {
    			return e.val;
    		}
    	}
    	return null;
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
    	int hashcode = hash(key.hashCode());
    	int index = hashcode % capacity;
    	for (Entry<K,V> e = table[index]; e != null; e = e.next) {
    		if (e.key.equals(key) && !e.deleted) {
    			e.val = value;
    			return;
    		}
    	}
    	table[index] = new Entry<K,V>(key, value, table[index]);
    	size++;
    	if (size > threshold) {
    		rehash();
    	}
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for HW6. */
    public V remove(K key) {
    	int hashcode = hash(key.hashCode());
    	int index = hashcode % capacity;
    	if (table[index] == null) return null;
    	for (Entry<K,V> e = table[index]; e != null; e = e.next) {
    		if (e.key.equals(key) && !e.deleted) {
    			e.deleted = true;
    			size--;
    			return e.val;
    		}
    	}
    	return null;
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for HW6a. */
    public V remove(K key, V value) {
    	int hashcode = hash(key.hashCode());
    	int index = hashcode % capacity;
    	if (table[index] == null) return null;
    	for (Entry<K,V> e = table[index]; e != null; e = e.next) {
    		if (e.key.equals(key) && e.val == value && !e.deleted) {
    			e.deleted = true;
    			size--;
    			return e.val;
    		}
    	}
    	return null;
    }

    public void rehash() {
    	int oldCapacity = capacity;
    	capacity = capacity * 2 + 1;
    	Entry[] oldTable = table;
    	clear();
    	for (int i = 0; i < oldCapacity; i++) {
    		for (Entry<K,V> e = oldTable[i]; e != null; e = e.next) {
    			if (e.deleted) continue;
    			int hashcode = hash(e.key.hashCode());
    			int index = hashcode % capacity;
    			table[index] = new Entry<K,V>(e.key, e.val, table[index]);
    			size++;
    		}
    	}
    }

	private static class Entry<K,V> {
		private K key;
		private V val;
		private Entry<K,V> next;
		private boolean deleted;

		public Entry(K k, V v, Entry<K,V> n) {
			key = k;
			val = v;
			next = n;
			deleted = false;
		}

		public Entry(K k, V v, Entry<K,V> n, boolean deleted) {
			key = k;
			val = v;
			next = n;
			this.deleted = deleted;
		}
	}

	/* http://stackoverflow.com/questions/9364134/what-hashing-function-does-java-use-to-implement-hashtable-class */
    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public static void main(String[] args) {
    	MyHashMap<String, Integer> hashmap = new MyHashMap<String, Integer>();
    	hashmap.put("A", 1);
    	hashmap.put("B", 2);
    	hashmap.put("C", 3);
    	System.out.println(hashmap.get("A"));
    }
}
