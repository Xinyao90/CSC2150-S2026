package lec14Prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DogLauncher {
    static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Goofy", 200));
        dogs.add(new Dog("Spoopy", 5));
        dogs.add(new Dog("Clifford", 9000));
        Dog maxDog = Collections.max(dogs);
        Dog maxNameDog = Collections.max(dogs, new Dog.NameComparator());
    }
}
