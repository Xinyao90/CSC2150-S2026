package lec19Prep.Demo;

public class LinkedDeque<T> {

    private class Node {
        T item;
        Node prev;
        Node next;

        Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedDeque() {
        // TODO: create circular sentinel
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // sentinel -> 2
    //          <-
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
        if (size == 0) return null;
        Node first = sentinel.next;
        first.prev = sentinel;
        sentinel.next = first.next;
        size--;
        return first.item;
    }

    public T removeLast() {
        //TODO
        return null;
    }

    //TODO
    @Override
    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        lec19Prep.LinkedDeque<Integer> d = new lec19Prep.LinkedDeque<>();

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

