package lec21Prep;

public class PriorityQueuePractice {

    /**
     * A simple Min Priority Queue for integers, backed by a binary heap.
     * Heap is stored in a 0-based array.
     */
    public static class IntMinPQ {
        private int[] items;
        private int size;

        public IntMinPQ() {
            items = new int[16];
            size = 0;
        }

        /** Returns number of items currently in the PQ. */
        public int size() {
            return size;
        }

        /** Returns true if PQ is empty. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Returns the smallest item without removing it. */
        public int getSmallest() {
            if (size == 0) {
                throw new IllegalStateException("PQ is empty.");
            }
            return items[0];
        }

        /** Adds x into the priority queue. */
        public void add(int x) {
            if (size == items.length) {
                resize(items.length * 2);
            }

            // Step 1: place new item at the end
            items[size] = x;

            // Step 2: restore heap property
            swim(size);

            // Step 3: increase size
            size++;
        }

        /** Removes and returns the smallest item. */
        public int removeSmallest() {
            if (size == 0) {
                throw new IllegalStateException("PQ is empty.");
            }

            int smallest = items[0];

            // Move last item to root
            items[0] = items[size - 1];
            size--;

            // Restore heap property if not empty
            if (size > 0) {
                sink(0);
            }

            return smallest;
        }

        /** Moves item at index k upward until heap property is restored. */
        private void swim(int k) {
            while (k > 0 && items[k] < items[parent(k)]) {
                swap(k, parent(k));
                k = parent(k);
            }
        }

        /** Moves item at index k downward until heap property is restored. */
        private void sink(int k) {
            while (leftChild(k) < size) {
                int smaller = leftChild(k);

                if (rightChild(k) < size && items[rightChild(k)] < items[leftChild(k)]) {
                    smaller = rightChild(k);
                }

                if (items[k] <= items[smaller]) {
                    break;
                }

                swap(k, smaller);
                k = smaller;
            }
        }

        /** Returns parent index of k. */
        private int parent(int k) {
            return (k - 1) / 2;
        }

        /** Returns left child index of k. */
        private int leftChild(int k) {
            return 2 * k + 1;
        }

        /** Returns right child index of k. */
        private int rightChild(int k) {
            return 2 * k + 2;
        }

        /** Swaps items at indices i and j. */
        private void swap(int i, int j) {
            int temp = items[i];
            items[i] = items[j];
            items[j] = temp;
        }

        /** Resizes the underlying array. */
        private void resize(int capacity) {
            int[] a = new int[capacity];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }

        /** Prints heap array contents in logical order. */
        public void printHeapArray() {
            System.out.print("[ ");
            for (int i = 0; i < size; i++) {
                System.out.print(items[i] + " ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        IntMinPQ pq = new IntMinPQ();

        System.out.println("=== Add Demo ===");
        pq.add(7);
        pq.printHeapArray();

        pq.add(3);
        pq.printHeapArray();

        pq.add(10);
        pq.printHeapArray();

        pq.add(1);
        pq.printHeapArray();

        pq.add(5);
        pq.printHeapArray();

        System.out.println("Smallest = " + pq.getSmallest()); // should be 1

        System.out.println("\n=== Remove Demo ===");
        while (!pq.isEmpty()) {
            int removed = pq.removeSmallest();
            System.out.println("Removed: " + removed);
            pq.printHeapArray();
        }

        System.out.println("\n=== Top 3 Largest Demo ===");
        int[] scores = {88, 91, 72, 99, 85, 93};
        IntMinPQ top3 = new IntMinPQ();

        for (int x : scores) {
            top3.add(x);
            if (top3.size() > 3) {
                top3.removeSmallest();
            }
        }

        System.out.println("Heap storing the 3 largest values:");
        top3.printHeapArray();
        System.out.println("Current cutoff (smallest among top 3): " + top3.getSmallest());
    }
}
