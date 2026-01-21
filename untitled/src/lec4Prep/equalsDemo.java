package lec4Prep;

public class equalsDemo {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        System.out.println(a == b);

        Walrus walrus1 = new Walrus(3500, 10);
        Walrus walrus2 = new Walrus(3500, 10);
        System.out.println(walrus1 == walrus2);

        int[] x = new int[]{1, 2, 3};
        int[] y = new int[]{1, 2, 3};
        System.out.println(x == y);
    }
}
