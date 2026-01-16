package lec3Prep;


import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> L = new HashMap<>();
        L.put("dog", "woof");
        L.put("cat", "meow");
        String sound = L.get("cat");

        System.out.println(sound);
    }
}
