package lec3Prep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> L = new LinkedList<>();
        L.add("a");
        L.add("b");
        L.add("c");
//        L.add(3);

        System.out.println(L);
        String x = L.get(0);
    }
}
