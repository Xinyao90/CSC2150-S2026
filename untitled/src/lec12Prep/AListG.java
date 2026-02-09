package lec12Prep;

public class AListG <T>{
    private T[] items;
    private int size;

    /**
     * RemoveLast for generic list to avoid loitering.
     */
    public T removeLast() {
        T returnItem = items[size - 1];
        items[size - 1] = null; // avoid loitering
        size -= 1;
        return returnItem;
    }
}
