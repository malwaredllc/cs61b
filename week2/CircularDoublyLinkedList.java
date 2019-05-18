public class DLList<E> {
  
  private class Node {
    private E value;
    private Node next;
    private Node prev;
    
    public Node(E x, Node p, Node n) {
      this.value = x;
      this.prev = p;
      this.next = n;      
    }
  }
  
  private int size;
  private Node sentinel;

  /* Constructor to initialize empty list */
  public DLList() {
    this.sentinel = new Node(null, null, null);
    this.sentinel.next = this.sentinel;
    this.sentinel.prev = this.sentinel;
    this.size = 0;
  }
  
  /* Add node to front of list */
  public void addFirst(E x) {
    this.sentinel.next = new Node(x, this.sentinel, this.sentinel.next);
    this.sentinel.next.next.prev = this.sentinel.next;
    if (this.size == 0) {
      this.sentinel.prev = this.sentinel.next;
    }
    size++;
  }
  
  /* Add node to end of list */
  public void addLast(E x) {
    this.sentinel.prev = new Node(x, this.sentinel.prev, this.sentinel);
    this.sentinel.prev.prev.next = this.sentinel.prev;
    if (this.size == 0) {
      this.sentinel.next = this.sentinel.prev;
    }
    size++;
  }
  
  /* Get first value from list */
  public E getFirst() {
    return this.sentinel.next.value;
  }

  /* Get last value from list */
  public E getLast() {
    return this.sentinel.prev.value;
  }
  
  /* Remove first item from list */
  public void removeFirst() {
    if (this.size > 0) {
      this.sentinel.next = this.sentinel.next.next;
      this.sentinel.next.prev = this.sentinel;
      this.size--;
    }
  }
  
  /* Remove last item from list */
  public void removeLast() {
    if (this.size > 0) {
      this.sentinel.prev = this.sentinel.prev.prev;
      this.sentinel.prev.next = this.sentinel;
      this.size--;
    }
  }
  
  /* Get size of list */
  public int size() {
    return this.size;
  }
  
  public static void main(String[] args) {
    /* List of integers */
    DLList<Integer> d1 = new DLList<>();
    d1.addLast(1);
    d1.addLast(2);
    d1.addLast(3);
    d1.addFirst(0);
    d1.removeLast();
    d1.removeFirst();
    
    /* List of strings */
    DLList<String> d2 = new DLList<>();
    d2.addFirst("test1");
    d2.addFirst("test0");
    d2.addLast("test2");
    d2.addLast("test3");
    d2.removeFirst();
    d2.removeLast();
    System.out.println(d2.size());
  }
}
