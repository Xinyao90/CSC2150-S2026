package lec6Prep;

import lec5Prep.IntList;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    public IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return first.item;
    }

    /** Add an item to the end of the list. */
    public void addLast(int x) {
        IntNode p = first;

        /* Move P until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Returns the size of the list that starts at IntNode p.*/
    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    public int size() {
        return size(first);
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.getFirst());

    }
}
