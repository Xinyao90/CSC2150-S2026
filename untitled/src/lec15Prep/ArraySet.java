package lec15Prep;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<T> implements Iterable<T>{
    private T[] items;
    private  int size; // the next item to be added will be at position size

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        // Policy: null is never "contained"
        if (x == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("Cannot add null to ArraySet.");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size(){
        return size;
    }

    /** returns an iterator (a.k.a. seer) into ME */
    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;
        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(items[i].toString());
            sb.append(",");
        }
        sb.append(items[size - 1]);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o){
        //o is automatically cast to ArraySet and available here
        if (o instanceof ArraySet oas) {
            //check sets are of the same size
            if (oas.size != this.size) {
                return false;
            }
            //check that all of MY items are in the other array set
            for(T x : this) {
                if (!oas.contains(x)) {
                    return false;
                }
            }
            return true;
        }
        // o is not an arrayset, so return false
        return false;
    }

    static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }

        //equals
        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);

        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals(null));
        System.out.println(aset.equals("fish"));
        System.out.println(aset.equals(aset));
    }
}
