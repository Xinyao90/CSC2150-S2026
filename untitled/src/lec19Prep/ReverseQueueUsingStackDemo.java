package lec19Prep;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ReverseQueueUsingStackDemo {
    /**
     * Reverses the given queue in-place using only:
     * - One stack
     * - The same queue
     *
     * Example:
     * input queue:  1 2 3 4
     * output queue: 4 3 2 1
     *
     */
    public static <T> void reverseQueue(Queue<T> q) {
        Deque<T> stack = new ArrayDeque<>();

        // Mover everything from queue -> stack
        while(!q.isEmpty()) {
            stack.push(q.remove());
        }
        // Move everything from stack -> queue (reversed order)
        while(!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println("Before reverse: " + q);
        reverseQueue(q);
        System.out.println("After reverse:  " + q);

        // Another quick test
        Queue<String> q2 = new ArrayDeque<>();
        q2.add("A");
        q2.add("B");
        q2.add("C");
        System.out.println("Before reverse: " + q2);
        reverseQueue(q2);
        System.out.println("After reverse:  " + q2);
    }
}
