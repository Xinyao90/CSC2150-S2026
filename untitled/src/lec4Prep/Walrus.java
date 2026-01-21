package lec4Prep;

public class Walrus {
    public int weight;
    public double tuskSize;

    public Walrus(int w, double ts) {
        weight = w;
        tuskSize = ts;
    }

    public String toString() {
        return String.format("weight: %d, tusk size: %.2f", weight, tuskSize);
    }
}
