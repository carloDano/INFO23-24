import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class PrintQueue {
    // Classe nested per rappresentare un nodo nella coda
    private static class Node {
        String content;

        Node(String content) {
            this.content = content;
        }
    }

    private Queue<Node> queue = new LinkedList<>();

    // Metodo per accodare un file di testo
    public void enqueue(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        Node node = new Node(content.toString());
        queue.offer(node);
    }

    // Metodo per stampare il contenuto della coda in un file "Print.txt"
    public void print() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Print.txt"))) {
            writer.write("*****INIZIO*****\n");

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                writer.write(node.content);
            }

            writer.write("***** FINE *****\n");
        }
    }
}