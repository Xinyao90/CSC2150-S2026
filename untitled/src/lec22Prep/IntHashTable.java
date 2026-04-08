package lec22Prep;

import java.util.LinkedList;

public class IntHashTable {
    private LinkedList<Integer>[] buckets;
    private int size;
    private static final double MAX_LOAD_FACTOR = 0.75;

    @SuppressWarnings("unchecked")
    public IntHashTable(int capacity) {
        buckets = (LinkedList<Integer>[]) new LinkedList[capacity];
        // buckets = new LinkedList<Integer>[capacity]; // cannot create generic array
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    private int hash(int key) {
        return Math.floorMod(key, buckets.length);
    }

    public double loadFactor() {
        // TODO
        return (double)size/buckets.length;
    }

    public void insert(int key) {
        // TODO:
        // 1. compute bucket index
        // 2. avoid duplicates
        // 3. add key
        // 4. increment size
        // 5. if load factor too high, resize
        int index = hash(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
            size++;
        }
        if (loadFactor() > MAX_LOAD_FACTOR) {
            resize(buckets.length * 2);
        }

    }

    public boolean contains(int key) {
        // TODO
        int index = hash(key);
        return buckets[index].contains(key);
    }

    public boolean remove(int key) {
        // TODO
        int index = hash(key);
        boolean removed = buckets[index].remove(Integer.valueOf(key));
        if (removed) {
            size--;
        }
        return removed;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        // TODO:
        // 1. save old buckets
        // 2. make new bucket array
        // 3. initialize each bucket
        // 4. rehash every old key into new table
        LinkedList<Integer>[] oldBuckets = buckets;
        buckets = (LinkedList<Integer>[]) new LinkedList[newCapacity];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (LinkedList<Integer> chain : oldBuckets) {
            for(int key: chain) {
                int newIndex = hash(key);
                buckets[newIndex].add(key);
            }
        }
    }

    public void printTable() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print(i + ": ");
            for (int x : buckets[i]) {
                System.out.print(x + " -> ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        IntHashTable ht = new IntHashTable(4);

        int[] values = {50, 700, 76, 85, 92, 73, 101};
        for (int v : values) {
            ht.insert(v);
            System.out.println("Inserted " + v + ", load factor = " + ht.loadFactor());
        }

        ht.printTable();
        System.out.println("Contains 92? " + ht.contains(92));
        System.out.println("Remove 85? " + ht.remove(85));
        ht.printTable();
    }
}