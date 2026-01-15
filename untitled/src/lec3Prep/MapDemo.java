package lec3Prep;

import java.util.Map;
import java.util.HashMap;

public class MapDemo {
    static void main(String[] args) {
        Map<String, String> L = new HashMap<>();
        L.put("dog", "woof");
        L.put("cat", "meow");
        String sound = L.get("cat");
        System.out.println(sound);
    }
}
