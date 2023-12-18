class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(String key, String value) {
        root = insertRec(root, key, value);
    }

    private TreeNode insertRec(TreeNode root, String key, String value) {
        if (root == null) {
            root = new TreeNode(key, value);
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key, value);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key, value);
        }

        return root;
    }

    public String search(String key) {
        return searchRec(root, key);
    }

    private String searchRec(TreeNode root, String key) {
        if (root == null || key.equals(root.key)) {
            return (root != null) ? root.value : "Traduzione non trovata";
        }

        if (key.compareTo(root.key) < 0) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }
}