package lec3Prep;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListDemo {
    public static void main(String[] args) {
        List<String> L = new LinkedList<>();
        L.add("a");
        L.add("b");
        L.add("c");
        System.out.println(L);

        String x = L.get(0);
//        L.add(3); //Syntax error. Won’t compile.
    }
}
