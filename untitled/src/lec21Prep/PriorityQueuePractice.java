package lec21Prep;

public class PriorityQueuePractice {

    /**
     * A simple Min Priority Queue for integers, backed by a binary heap.
     * Heap is stored in a 0-based array.
     */
    public static class IntMinPQ {

        public IntMinPQ() {
        }

        public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return false;
        }

        public int getSmallest() {
            if (size == 0) {
                throw new IllegalStateException("PQ is empty.");
            }
            return 0;
        }

        public void add(int x) {
            if (size == items.length) {
                resize(items.length * 2);
            }

            // TODO: place new item at the end
            // TODO: call swim on the correct index
            // TODO: increase size
        }

        public int removeSmallest() {
            if (size == 0) {
                throw new IllegalStateException("PQ is empty.");
            }

            int smallest = items[0];

            // TODO: move last item to root
            // TODO: decrease size
            // TODO: if needed, sink from root

            return smallest;
        }

        private void swim(int k) {
            // TODO:
            // while k > 0 and items[k] < items[parent(k)]
            // swap and move upward
        }

        private void sink(int k) {
            // TODO:
            // while left child exists
            // choose smaller child
            // if heap property already holds, stop
            // otherwise swap and continue downward
        }

        private int parent(int k) {
            return (k - 1) / 2;
        }

        private int leftChild(int k) {
            return 2 * k + 1;
        }

        private int rightChild(int k) {
            return 2 * k + 2;
        }

        private void swap(int i, int j) {
            int temp = items[i];
            items[i] = items[j];
            items[j] = temp;
        }

        private void resize(int capacity) {
            int[] a = new int[capacity];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }

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