public class AList<E> {
  private E[] items;
  private int size;
  
  public AList() {
    this.items = (E[]) new Object[100];
    this.size = 0;
  }
  
  /* Resize array to target capacity */
  private void resize(int x) {  
    E[] a = (E[]) new Object[x];
    System.arraycopy(this.items, 0, a, 0, this.size);
    this.items = a;
  }
  
  /* Append target value to end of list */
  public void addLast(E x) {
    if (this.size == this.items.length) {
      this.resize(this.size * 2);
    }
    this.items[this.size] = x;
    this.size++;
  }
  
  /* Get last value from list */
  public E getLast() {
    return this.items[this.size - 1];
  }
  
  /* Get last value from list and remove it from list */
  public E removeLast() {
    E x = this.getLast();
    this.size--;
    double usage = this.size / this.items.length;
    if (usage < 0.25) {
      this.resize(this.size / 2);
    }
    return x;
  }
  
  /* Get value at target index from list */
  public E get(int x) {
    return this.items[x];
  }
  
  /* Get size of list */
  public int size() {
    return this.size;
  }
  
  public static void main(String[] args) {
    AList<Integer> a = new AList<>();
    for (int i = 0; i < 10; i++) {
      a.addLast(i);
    }
    System.out.println(a.size());    
  }
}
