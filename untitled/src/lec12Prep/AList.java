package lec12Prep;

import static java.lang.System.*;

public class AList {
    private int[] items;
    private int size;

    private void resize(int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /**
     * addLast using resize-by-1.
     * naive resizing
     */
//    public void addLast(int x) {
//        if (size == items.length) {
//            resize(size + 1);
//        }
//        items[size] = x;
//        size += 1;
//    }

    /**
     * Upgrade to geometric resizing
     * Modify addLast so it doubles capacity when full.
     */
    public void addLast(int x) {
        if (size == items.length) {
            // Double the capacity when full.
            // Special case: if current capacity is 0, start with capacity 1
            int newCap = (items.length == 0) ? 1 : items.length * 2;
            resize(newCap);
        }
        items[size] = x;
        size += 1;
    }

    /**
     * RemoveLast (int version)
     */
    public int removeLast(){
        int x = items[size - 1];
        size -= 1;
        return x;
    }

    /**
     * Shrink the array when it is underutilized.
     * - items.length >= 16: avoid shrinking very small arrays
     * - size < items.length / 4: usage ratio < 25%
     * This prevents wasting memory while avoiding resize thrashing.
     */
    private void mayShrink() {
        if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
    }
}
