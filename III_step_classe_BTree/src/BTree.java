import java.util.ArrayList;
import java.util.Stack;

public class BTree {

    private ArrayList<Integer> tree;

    public BTree() {
        tree = new ArrayList<>();
    }


    public void insert(int val) {
        tree.add(val);
    }

    public int search(int val) {
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i) == val) {
                return i;
            }
        }
        return -1;
    }

    public int leftChild(int val) {
        int app = search(val);
        if (app == -1 || 2 * app + 1 >= tree.size()) {
            return -1;
        }
        return 2 * app + 1;
    }

    public int rightChild(int val) {
        int app = search(val);
        if (app == -1 || 2 * app + 2 >= tree.size()) {
            return -1;
        }
        return 2 * app + 2;
    }

    public int[] preOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Inizia dalla radice (indice 0)

        while (!stack.isEmpty()) {
            int current = stack.pop(); // Estrai l'indice corrente

            if (current != -1) {
                // Aggiungi il valore al risultato
                result.add(tree.get(current));
                // Pusha i figli destro e sinistro, se esistono
                stack.push(rightChild(current));
                stack.push(leftChild(current));
            }
        }

        int[] preOrderArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            preOrderArray[i] = result.get(i);
        }

        return preOrderArray;
    }
}