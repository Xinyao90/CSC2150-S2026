package lec5Prep;

public class IntList {
    public int first;
    public IntList next;

    public IntList(int val, IntList list) {
        this.first = val;
        this.next = list;
    }

    public int size() {
        if (next == null) {
            return 1;
        }
        return 1 + this.next.size();
    }

    public int get(int i) {
        IntList cur = this;
        while (i != 0) {
            cur = cur.next;
            i--;
        }
        return cur.first;
    }

//    public int get(int i) {
//        if (i == 0){
//            return this.first;
//        }
//        return this.next.get(i - 1);
//    }

    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.next;
        }
        return totalSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntList p = this;
        while (p != null) {
            sb.append(p.first);
            if (p.next != null) sb.append(" -> ");
            p = p.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.get(1));
    }
}
