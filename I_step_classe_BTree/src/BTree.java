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
}