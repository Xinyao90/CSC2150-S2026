package lec7Prep;

import lec5Prep.IntList;

public class SLList {
    private static class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /** The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Add x to the end of the list.*/
    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;

        /* Move p until it reaches the end of the list.*/
        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    private int size(IntNode p) {
        if(p.next == null) {
            return 0;
        }
        return 1 + size(p.next);
    }

    public int size() {
        return size(sentinel);
    }

    public static void main(String[] args) {
        SLList L = new SLList();
        L.addLast(20);
        System.out.println(L.size());
    }
}
