public class Main {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert(5);
        pq.insert(2);
        pq.insert(9);
        pq.insert(1);

        System.out.println(pq.extractMin()); // Stampa 1
        System.out.println(pq.extractMin()); // Stampa 2
    }
}