package lec13Prep;

public class LinkedStack {
    private static class Node {
        int item;
        Node next;
        Node(int i, Node n){
            item = i;
            next = n;
        }
    }
    private Node sentinel = new Node(0, null);
    int size = 0;

    public void push(int x) {
        //TODO
        sentinel.next = new Node(x, sentinel.next);
        size++;
    }
    public int pop() {
        //TODO
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        int popped = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size--;
        return popped;
    }

    public void print() {
        Node curNode = sentinel;
        String output = "";
        while(curNode.next != null) {
            output += curNode.next.item + " ";
            curNode = curNode.next;
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(1);
        stack.print();
        stack.push(2);
        stack.print();
        stack.push(3);
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
    }
}
