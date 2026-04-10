package lec22Prep;

import java.util.Objects;
import java.util.HashSet;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //compares name and id
    @Override
    public boolean equals(Object other) {
        //TODO
        if (this == other) return true;
        if (!(other instanceof Student)) return false;
        Student s = (Student) other;
        return this.id == s.id && Objects.equals(name, s.name);
    }
    //compares name and id
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
//        return Objects.hash(id);
    }

//    // Only compare id
//    @Override
//    public boolean equals(Object other) {
//        if (this == other) return true;
//        if (!(other instanceof Student)) return false;
//
//        Student s = (Student) other;
//        return this.id == s.id;
//    }
//
    // MUST match equals → only use id
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();

        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(101, "Alice");

        set.add(s1);
        System.out.println(set.contains(s2)); // true only if equals/hashCode are consistent

        String a = null;
        String b = null;

        System.out.println(Objects.equals(a, b)); // ?
        System.out.println(a.equals(b));
    }
}
