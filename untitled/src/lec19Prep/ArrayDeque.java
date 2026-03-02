package lec19Prep;

import java.util.Deque;

public class ArrayDeque {
    private int[] items;
    private int size;
    private int front; // index of first element
    private int back; // index one past the last element

    public ArrayDeque() {
        items = new int[8]; // initial capacity
        size = 0;
        front = 0;
        back = 0;
    }
    /* ==========================
       Resize Helper
       ========================== */
    private void resize(int capacity) {
        int[] newItems = new int[capacity];

        //Copy elements in logical order
        for(int i = 0; i < size; i++) {
            newItems[i] = items[(front + i) % items.length];
        }
        items = newItems;
        front = 0;
        back = size;
    }
      /* ==========================
       Add First
       ========================== */
    public void addFirst(int x) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        // Move front backward (circularly)
        front = (front - 1 + items.length) % items.length;
        items[front] = x;
        size++;
    }
    /* ==========================
       Add Last
       ========================== */
    public void addLast(int x) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[back] = x;
        back = (back + 1) % items.length;
        size++;
    }
    /* ==========================
       Remove First
       ========================== */
    public Integer removeFirst() {
        if (size == 0) return null;

        int value = items[front];
        front = (front + 1) % items.length;
        size--;

        return value;
    }
    /* ==========================
       Remove Last
       ========================== */
    public Integer removeLast(){
        if (size == 0) return null;

        back = (back - 1 + items.length) % items.length;
        int value = items[back];
        size--;

        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(items[(front + i) % items.length]);
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    static void main(String[] args) {
        ArrayDeque d = new ArrayDeque();
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        System.out.println(d); // [ 1 2 3 ]

        d.addFirst(0);
        System.out.println(d); // [ 0 1 2 3 ]

        d.removeFirst();
        System.out.println(d); // [ 1 2 3 ]

        d.removeLast();
        System.out.println(d); // [ 1 2 ]
    }

}
