public class SLList {
  
  private class Node {
    private int value;
    private Node next;
    
    public Node(int x, Node n) {
      this.value = x;
      this.next = n;
    }
  }
  
  private int size;
  private Node sentinel;

  /* Constructor to initialize empty list */
  public SLList() {
    this.sentinel = new Node(0, null);
    this.size = 0;
  }
  
  /* Constructor to initialize list with 1 node */
  public SLList(int x) {
    this.sentinel = new Node(0, null);
    this.sentinel.next = new Node(x, null);
    this.size = 1;
  }    
  
  /* Add node to front of list */
  public void addFirst(int x) {
    this.sentinel.next = new Node(x, this.sentinel.next);
    size++;
  }
  
  /* Add node to end of list */
  public void addLast(int x) {
    Node p = this.sentinel;
    while (p.next != null) {
      p = p.next;
    }
    p.next = new Node(x, null);
    size++;
  }
  
  /* Get first value from list */
  public int getFirst() {
    return this.sentinel.next.value;
  }

  /* Get last value from list */
  public int getLast() {
    Node p = this.sentinel;
    while (p.next != null) {
      p = p.next;
    }
    return p.value;
  }
  
  /* Remove first item from list */
  public int removeFirst() {
    if (this.size > 0) {
      this.sentinel.next = this.sentinel.next.next;
      this.size--;
    }
  }
  
  /* Get size of list */
  public int size() {
    return this.size;
  }
  
  public static void main(String[] args) {
    SLList s = new SLList();
    s.addLast(1);
    s.addLast(2);
    s.addLast(3);
    s.addFirst(4);
    System.out.println(s.size());
  }
}
