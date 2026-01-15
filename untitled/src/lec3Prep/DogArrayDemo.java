package lec3Prep;

public class DogArrayDemo {
    static void main(String[] args) {
        Dog[] dogs = new Dog[3];

        dogs[0] = new Dog(5);
        dogs[1] = new Dog(25);
        dogs[2] = new Dog(60);

        for (int i = 0; i < dogs.length; i++) {
            dogs[i].makeNoise();
        }
        System.out.println("Number of dogs:" + dogs.length);
    }
}
