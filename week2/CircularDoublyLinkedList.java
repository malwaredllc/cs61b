public class DLList {
  
  private class Node {
    private int value;
    private Node next;
    private Node prev;
    
    public Node(int x, Node p, Node n) {
      this.value = x;
      this.prev = p;
      this.next = n;      
    }
  }
  
  private int size;
  private Node sentinel;

  /* Constructor to initialize empty list */
  public DLList() {
    this.sentinel = new Node(0, null, null);
    this.sentinel.next = this.sentinel;
    this.sentinel.prev = this.sentinel;
    this.size = 0;
  }
  
  /* Add node to front of list */
  public void addFirst(int x) {
    this.sentinel.next = new Node(x, this.sentinel, this.sentinel.next);
    this.sentinel.next.next.prev = this.sentinel.next;
    if (this.size == 0) {
      this.sentinel.prev = this.sentinel.next;
    }
    size++;
  }
  
  /* Add node to end of list */
  public void addLast(int x) {
    this.sentinel.prev = new Node(x, this.sentinel.prev, this.sentinel);
    this.sentinel.prev.prev.next = this.sentinel.prev;
    if (this.size == 0) {
      this.sentinel.next = this.sentinel.prev;
    }
    size++;
  }
  
  /* Get first value from list */
  public int getFirst() {
    return this.sentinel.next.value;
  }

  /* Get last value from list */
  public int getLast() {
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
    DLList d = new DLList();
    d.addLast(9);
    d.addLast(8);
    d.addLast(7);
    d.addFirst(6);
    d.removeLast();
    d.removeFirst();
    System.out.println(d.size());
  }
}
