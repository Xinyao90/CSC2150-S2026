package lec13Prep;

public class ArrayStack {
    private int[] a = new int[8];
    private int size = 0;

    public void push(int x) {
    //TODO
        if(a.length == size) {
            resize(a.length * 2);
        }
        a[size++] = x;
    }

    public int pop() {
    //TODO
        return a[--size];
    }

    private void resize(int capacity) {
        int[] newArray = new int[capacity];
        System.arraycopy(a, 0, newArray, 0, capacity);
        a = newArray;
    }

    public void print() {
        String output = "";
        for(int i = 0; i < size; i++) {
            output += a[i] + " ";
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
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
