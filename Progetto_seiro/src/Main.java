import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        try {
            // Aggiungi i file alla coda
            printQueue.enqueue("file1.txt");
            printQueue.enqueue("file2.txt");
            printQueue.enqueue("file3.txt");

            // Stampa il contenuto della coda in "Print.txt"
            printQueue.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
