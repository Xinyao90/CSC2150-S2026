package lec4Prep;

public class PollQuestions {

//    public static void doStuff(Walrus w, int x) {
//        w.weight = w.weight - 100;
//        x = x - 5;
//    }
    static void main(String[] args) {
        int x = 5;
        int y;
        y = x;
        x = 2;
        System.out.println("x is:" + x);
        System.out.println("y is:" + y);

        Walrus a = new Walrus(1000, 8.3);
        Walrus b;
        b = a;
        b.weight = 5;
        System.out.println(a);
        System.out.println(b);

//        Walrus walrus = new Walrus(3500, 10.5);
//        int x = 9;
//        doStuff(walrus, x);
//        System.out.println(walrus);
//        System.out.println(x);
    }
}
