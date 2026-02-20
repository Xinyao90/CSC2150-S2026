package lec15Prep.DIY;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LIVE CODING STARTER: ArraySet<T>
 *
 * What we are building:
 *  - A Set backed by an array (no duplicates, no ordering guarantee)
 *
 * Learning goals:
 *  1) Generics: ArraySet<T>
 *  2) Iterable<T> + Iterator<T> (enhanced for-loop support)
 *  3) equals(...) using instanceof pattern matching
 *  4) toString() with StringBuilder
 *
 * Big idea:
 *  - We keep a "used prefix" of the array: items[0 .. size-1]
 *  - items[size .. end] are unused / garbage
 */

public class ArraySet<T> implements Iterable<T>{

    // =========================
    // Fields / Representation
    // =========================

    /**
     * Backing array that stores the set elements.
     *
     * Representation invariant:
     *  - The set elements are exactly in items[0..size-1]
     *  - items[0..size-1] contain NO duplicates
     *  - size is the number of elements in the set
     *  - The next add goes to items[size]
     */
    private T[] items;

    /** Number of valid items currently stored. */
    private int size;

    // =========================
    // Constructor
    // =========================

    /**
     * Create an empty ArraySet.
     */
    public ArraySet() {
        // TODO (Checkpoint 1): allocate items and set size = 0
        // Hint: items = (T[]) new Object[100];
        // Hint: size = 0;
        items = (T[]) new Object[100];
        size = 0;
    }

    // =========================
    // Core Set Operations
    // =========================

    /**
     * Returns true if x is in the set.
     *
     *  - Linear scan: O(size)
     *  - Use equals, NOT == (unless primitives)
     *  - What about x == null? (We can choose policy)
     */
    public boolean contains(T x) {
        // TODO (Checkpoint 2): scan items[0..size-1], return true if found
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

    /**
     * Add x to the set if not already present.
     *
     * Policy decision:
     *  - Disallow null: throw IllegalArgumentException
     *
     *  - "Set" means no duplicates
     *  - When we add: put at items[size], then size++
     */
    public void add(T x) {
        // TODO (Checkpoint 3):
        // 1) if x is null -> throw
        // 2) if already contains -> return
        // 3) otherwise insert into items[size], increment size
        //
        // Optional discussion:
        //  - What happens if array fills up? (resizing; out of scope today)
        if(x == null) {
            throw new NoSuchElementException("Cannot add null to ArraySet.");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /** Return number of elements currently in set. */
    public int size() {
        // TODO (Checkpoint 4): return size
        return size;
    }

    // =========================
    // Iterable / Iterator
    // =========================

    /**
     * Required by Iterable<T>.
     * Makes this work:
     *   for (T x : arraySet) { ... }
     */
    @Override
    public Iterator<T> iterator() {
        // TODO (Checkpoint 5): return a new ArraySetIterator
        return new ArraySetIterator();
    }

    /**
     * Iterator class: "a seer into ME"
     *
     *  - The iterator remembers a position (wizPos)
     *  - hasNext checks wizPos < size
     *  - next returns current item and advances
     */
    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            // TODO: initialize wizPos.
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            // TODO: return wizPos < size
            return wizPos < size;
        }

        @Override
        public T next() {
            // TODO:
            // 1) grab items[wizPos]
            // 2) wizPos++
            // 3) return grabbed item
            //
            // Optional discussion:
            //  - Should we throw if no next? (Iterator spec)
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T currentItem = items[wizPos];
            wizPos += 1;
            return currentItem;
        }
    }
        // =========================
        // toString / equals
        // =========================

        /**
         * Return a string like: {a,b,c}
         *
         *  - Use StringBuilder (avoid O(n^2) concatenation)
         *  - Be careful about size == 0 (edge case!)
         */
        @Override
        public String toString() {
            // TODO (Checkpoint 6):
            // If size == 0 return "{}"
            // Otherwise build "{x,y,z}" with commas between items
            if (size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (T item: this) { // this -> items
                sb.append(item);
                sb.append(",");
            }
            sb.append("}");
            return sb.toString();
        }

        /**
         * Set equality:
         *  - Must be another ArraySet
         *  - Must have same size
         *  - Every element in this must be in the other
         *
         *  - instanceof pattern matching: (o instanceof ArraySet<?> other)
         */
        @Override
        public boolean equals(Object o) {
            // TODO (Checkpoint 7):
            // 1) If o is not an ArraySet -> return false
            // 2) Cast to ArraySet<?> (or ArraySet<T> carefully)
            // 3) If sizes differ -> return false
            // 4) For each element in this, check other.contains(x)
            // 5) Return true
            if ( o instanceof ArraySet otherSet) {
                if (otherSet.size() != this.size()) {
                    return false;
                }
                for (T item : this){
                    if (!otherSet.contains(item)) {
                        return false;
                    }
                }
                return true;
            }
            return false;

        }

    // =========================
    // Quick demo main
    // =========================

    public static void main(String[] args) {
        //  - Run this after each checkpoint to validate behavior incrementally.

        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);
        aset.add(23); // should not duplicate

        // iteration
        for (int x : aset) {
            System.out.println(x);
        }

        System.out.println(aset);

        // equals checks
        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(23);
        aset2.add(5);
        aset2.add(42);

        System.out.println(aset.equals(aset2));   // true
        System.out.println(aset.equals(null));    // false
        System.out.println(aset.equals("fish"));  // false
        System.out.println(aset.equals(aset));    // true
        System.out.println(aset2.toString());     // {23,5,42,} (order may vary depending on adds)
    }
}