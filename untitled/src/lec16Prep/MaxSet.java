package lec16Prep;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MaxSet: a simple array-backed Set that can also return its maximum element.
 * - Uniqueness enforced via contains()
 * - Iterable (supports enhanced for-loop)
 * - max() requires T extends Comparable<T>
 */

public class MaxSet<T extends Comparable<T>> implements Iterable<T> {
    private T[] items;
    private int size;

    public MaxSet() {
        items = (T[]) new Comparable[100];
        size = 0;
    }

    /** Returns true if this set contains x. */
    public boolean contains(T x) {
        if (x == null) {
            throw new IllegalArgumentException("x cannot be null.");
        }
        for (int i = 0; i < size; i++) {
            if (x.equals(items[i])) {
                return true;
            }
        }
        return false;
    }

    /** Adds x if not already present. Throws IllegalArgumentException if x is null. */
    public void add(T x) {
        if(x == null) {
            throw new IllegalArgumentException("Cannot add null.");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size++;
    }

    /** Returns number of items in the set. */
    public int size() {
        return size;
    }

    /** Returns the maximum element.*/
    public T max(){
        if(size == 0) {
            throw new NoSuchElementException("max called on empty MaxSet");
        }
        T max = items[0];
        for(T item: this){
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    /** Returns the maximum element in the set. Throws NoSuchElementException if empty. */
    @Override
    public Iterator<T> iterator() {
        return new MaxSetIterator();
    }

    private class MaxSetIterator implements Iterator<T> {
        private int pos;

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("No more items");
            return items[pos++];
        }
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if(other instanceof MaxSet otherSet) {
            if (otherSet.size != this.size){
                return false;
            }
            for (T x: this) {
                if (!otherSet.contains(x)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (T x : this) {
            sb.append(x + ",");
        }
        sb.append("}");
        return sb.toString();
    }

    static void main(String[] args) {
        MaxSet<Integer> t = new MaxSet<>();
        t.add(42);
        t.add(5);
        t.add(23);
        System.out.println(t);            // {5, 23, 42} (order depends on insertion)
        System.out.println(t.max());      // 42

        for (Integer x : t) {
            System.out.println("iter: " + x);
        }

        MaxSet<Integer> s = new MaxSet<>();
        s.add(5);
        s.add(42);
        s.add(23);
        System.out.println(t.equals(s)); // true (set equality, order-independent)

    }
}
