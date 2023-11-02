public class Main {
    public static void main(String[] args) {
        BTree bTree = new BTree();

        bTree.insert(1);
        bTree.insert(2);
        bTree.insert(3);
        bTree.insert(4);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(7);

        System.out.println("Posizione di 3: " + bTree.search(3));            //Mi stampa la posizione di 3: 2
        System.out.println("Figlio sinistro di 2: " + bTree.leftChild(2));   //Stampa li figlio sinistro di 2: 5
        System.out.println("Figlio destro di 4: " + bTree.rightChild(4));    //Stampa il figlio destro di 4: -1(perche non esiste

        int[] preOrderTraversal = bTree.preOrder();
        for (int val : preOrderTraversal) {
            System.out.print(val + " ");
        }

    }
}