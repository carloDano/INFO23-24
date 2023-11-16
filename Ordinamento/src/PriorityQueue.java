import java.util.LinkedList;

class PriorityQueue {
    private LinkedList<Integer> list;

    public PriorityQueue() {
        list = new LinkedList<>();
    }

    public void insert(int value) {
        // Trova la posizione corretta in cui inserire il valore
        int i = 0;
        while (i < list.size() && list.get(i) < value) {
            i++;
        }
        list.add(i, value);
    }

    public int extractMin() {
        if (!isEmpty()) {
            return list.removeFirst();
        } else {
            throw new IllegalStateException("La coda con priorità è vuota");
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
