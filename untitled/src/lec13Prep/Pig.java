package lec13Prep;

public class Pig implements Animal{
    @Override
    public void makeNoise() {
        System.out.println("oink");
    }

    public static void main(String[] args) {
        Animal pig = new Pig();
        pig.makeNoise();
    }
}
