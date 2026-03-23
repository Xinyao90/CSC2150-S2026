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
            items = new int[16]; // what is the items looks like? [0, 0, 0 ,0 ...0] 16 of 0s.
            size = 0;
        }

        /**
         * Creates a PQ from an existing array.
         * TODO: copy data and call heapify()
         */
        public IntMinPQ(int[] data) {
            items = new int[Math.max(16, data.length)];
            size = data.length;

            // TODO: copy data into items
            System.arraycopy(data, 0, items, 0, data.length);

            // TODO: call heapify()
            heapify();
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getSmallest() {
            if (size == 0) {
                throw new IllegalStateException("PQ is empty.");
            }
            return items[0];
        }

        public void add(int x) {
            if (size == items.length) {
                resize(items.length * 2);
            }

            // TODO: place new item at the end
            // TODO: call swim on the correct index
            // TODO: increase size
            items[size] = x;
            swim(size);
            size++;
        }

        public int removeSmallest() {
            if (size == 0) {
                throw new IllegalStateException("PQ is empty.");
            }

            int smallest = items[0];

            // TODO: move last item to root
            items[size - 1] = smallest;
            // TODO: decrease size
            size--;
            // TODO: if needed, sink from root
            sink(0);

            return smallest;
        }

        /**
         * Bottom-up heap construction
         * Only non-leaf nodes need sink()
         */
        public void heapify() {
            // TODO:
            // for i from size/2 - 1 down to 0:
            //     sink(i)
            for (int i = size/2 - 1; i >= 0; i--) {
                sink(i);
            }
        }

        private void swim(int k) {
            // TODO:
            // while k > 0 and items[k] < items[parent(k)]
            // swap and move upward
            while(k > 0 && items[k] < items[parent(k)]) {
                swap(k, parent(k));
                k = parent(k);
            }
        }

        private void sink(int k) {
            // TODO:
            // while left child exists
            // choose smaller child
            // if heap property already holds, stop
            // otherwise swap and continue downward
            while(leftChild(k) < size) {
                int smallerChild = leftChild(k);
                if(rightChild(k) < size && items[rightChild(k)] < items[leftChild(k)]) {
                    smallerChild = rightChild(k);
                }
                if (items[k] <= items[smallerChild]) {
                    break;
                }
                swap(k, smallerChild);
                k = smallerChild;
            }
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

//        System.out.println("=== Heapify Demo ===");
//        int[] data = {7, 3, 10, 1, 5};
//
//        IntMinPQ pq = new IntMinPQ(data);
//
//        System.out.println("After heapify:");
//        pq.printHeapArray();
    }
}