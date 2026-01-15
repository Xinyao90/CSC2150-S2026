package lec3Prep;

import java.util.List;
import java.util.ArrayList;

public class DogListDemo {
    public static void main(String[] args) {

        // TODO 1: create a List<Dog> named dogs
         List<Dog> dogs = new ArrayList<>();

        // TODO 2: add at least 3 Dog objects with different weights
        dogs.add(new Dog(2));
        dogs.add(new Dog(20));
        dogs.add(new Dog(31));

        // TODO 3: loop through dogs and call makeNoise() on each Dog
        for (int i = 0; i < dogs.size(); i++) {
            dogs.get(i).makeNoise();
        }

        // TODO 4: print the size of the list
         System.out.println("Number of dogs: " + dogs.size());
    }
}
