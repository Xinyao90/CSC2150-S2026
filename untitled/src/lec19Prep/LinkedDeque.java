package lec19Prep;

public class LinkedDeque<T> {

    private class Node {
        T item;
        Node prev;
        Node next;

        Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    // We want sentinel <-> newNode <-> oldFirst
    public void addFirst(T x) {
        Node first = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size++;
    }

    public void addLast(T x) {
        Node last = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return first.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size--;
        return last.item;
    }

    private void checkInvariants() {
        if(sentinel.next.prev != sentinel){
            throw new RuntimeException("Broken forward link");
        }
        if (sentinel.prev.next != sentinel) {
            throw new RuntimeException("Broken backward link");
        }
    }

    @Override
    public String toString() {
        Node p = sentinel.next;
        StringBuilder sb = new StringBuilder();
        while(p != sentinel) {
            sb.append(p.item).append(" ");
            p = p.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedDeque<Integer> d = new LinkedDeque<>();

        d.addFirst(10);
        d.addLast(20);
        d.addFirst(5);

        System.out.println(d);;  // expect: 5 10 20

        d.removeFirst();
        System.out.println(d);  // expect: 10 20

        d.removeLast();
        System.out.println(d); // expect: 10
    }
}
