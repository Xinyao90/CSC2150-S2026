package lec14Prep;

import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String name, int size){
        this.name = name;
        this.size = size;
    }
    @Override
    public int compareTo(Dog other){
        return size - other.size;
    }

    public static class NameComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }

    }
}
