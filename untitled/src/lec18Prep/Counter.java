package lec18Prep;

public class Counter {
    public int calls;
    public int comparisons;
    public int writes;

    public void reset() {
        calls = 0;
        comparisons = 0;
        writes = 0;
    }

    @Override
    public String toString() {
        return "calls = " + calls +
                ", comparisons = " + comparisons +
                ", writes = " + writes;
    }
}
