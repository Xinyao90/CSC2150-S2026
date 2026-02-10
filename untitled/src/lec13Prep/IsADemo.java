package lec13Prep;

public class IsADemo {
    public static void main(String[] args) {
        SpartensList<String> someList = new SLList<>();
        someList.addFirst("elk");
        someList.addLast("dwell");
        someList.addLast("on");
        someList.addLast("existential");
        someList.addLast("crises");
        someList.print();
    }
}
