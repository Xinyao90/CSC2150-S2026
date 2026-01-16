package lec3Prep;

import java.util.Map;
import java.util.HashMap;

public class AnimalSoundDemo {
    public static void main(String[] args) {

        Map<String, String> sounds = new HashMap<>();

        sounds.put("dog", "woof");
        sounds.put("cat", "meow");
        sounds.put("cow", "moo");

        System.out.println(sounds.get("cat"));

        if (!sounds.containsKey("sheep")) {
            System.out.println("Unknown animal");
        }
    }
}

