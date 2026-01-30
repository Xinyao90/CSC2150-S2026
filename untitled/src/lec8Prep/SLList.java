package lec8Prep;

public class SLList<LochNess>{
    private class StuffNode{
        private LochNess item;
        private StuffNode next;

        private StuffNode(LochNess i, StuffNode n) {
            this.item = i;
            this.next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    public SLList(LochNess x) {
        sentinel = new StuffNode(null, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    public SLList() {
        sentinel = new StuffNode(null, null);
        size = 0;
    }

    public void addFirst(LochNess x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
    }

    public LochNess getFirst() {
        return sentinel.next.item;
    }

    public void addLast(LochNess x) {
        size += 1;
        StuffNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null);
    }

    static void main(String[] args) {
        SLList<Integer> s1 = new SLList<>(5);
        s1.addFirst(10);

        SLList<String> s2 = new SLList<>("hi");
        s2.addFirst("apple");
    }


}
