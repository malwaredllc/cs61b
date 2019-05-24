/* Circular Doubly Linked List Deque */
public class LinkedListDeque<E> {
  
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

  /* Constructor to initialize empty deque */
  public LinkedListDeque() {
    this.sentinel = new Node(null, null, null);
    this.sentinel.next = this.sentinel;
    this.sentinel.prev = this.sentinel;
    this.size = 0;
  }
  
  /* Add node to front of deque */
  public void addFirst(E x) {
    this.sentinel.next = new Node(x, this.sentinel, this.sentinel.next);
    this.sentinel.next.next.prev = this.sentinel.next;
    if (this.size == 0) {
      this.sentinel.prev = this.sentinel.next;
    }
    size++;
  }
  
  /* Add node to end of deque */
  public void addLast(E x) {
    this.sentinel.prev = new Node(x, this.sentinel.prev, this.sentinel);
    this.sentinel.prev.prev.next = this.sentinel.prev;
    if (this.size == 0) {
      this.sentinel.next = this.sentinel.prev;
    }
    size++;
  }
  
  /* Get first value from deque */
  public E getFirst() {
    return this.sentinel.next.value;
  }

  /* Get last value from deque */
  public E getLast() {
    return this.sentinel.prev.value;
  }
 
  /* Get element at index i from list */
  public E get(int i) {
      int index = 0;
      Node pointer = this.sentinel.next;
      while (index != i) {
      	pointer = pointer.next;
      	index++;
      }
      return pointer.value;
  }

  /* Remove first item from deque */
  public void removeFirst() {
    if (this.size > 0) {
      this.sentinel.next = this.sentinel.next.next;
      this.sentinel.next.prev = this.sentinel;
      this.size--;
    }
  }
  
  /* Remove last item from deque */
  public void removeLast() {
    if (this.size > 0) {
      this.sentinel.prev = this.sentinel.prev.prev;
      this.sentinel.prev.next = this.sentinel;
      this.size--;
    }
  }
  
  /* Get size of deque */
  public int size() {
    return this.size;
  }

  /* Return true if deque is empty, otherwise return false */
  public boolean isEmpty() {
      return (this.size == 0);
  }

  /* Print elemenets from deque to standard output */
  public void printDeque() {
      System.out.println(this.printList(this.sentinel.next));
  }
  
  /* Recursively return elements from linked list as a space delimited string */
  private String printList(Node n) {
      if (n.value == null) {
          return "";
      }
      return n.value + " " + this.printList(n.next);
  }

  public static void main(String[] args) {
    /* Deque of integers */
    LinkedListDeque<Integer> d1 = new LinkedListDeque<>();
    d1.addLast(1);
    d1.addLast(2);
    d1.addLast(3);
    d1.addFirst(0);
    d1.addFirst(9);
    Integer i = d1.get(0);
    d1.removeLast();
    d1.removeFirst();
    d1.printDeque();
    
    /* Deque of strings */
    LinkedListDeque<String> d2 = new LinkedListDeque<>();
    d2.addFirst("test1");
    d2.addFirst("test0");
    d2.addLast("test2");
    d2.addLast("test3");
    d2.removeFirst();
    d2.removeLast();
    d2.printDeque();
  }
}