package model;

public class AVLTree {

    Node root = null;
    private String nodeList = "";

    public AVLTree() {

    }

    public void inorder() {
        nodeList = "";
        this.inorder(root);
    }

    private void inorder(Node tree) {
        if (tree != null) {
            this.inorder(tree.left);
            nodeList += tree.serviceOrder.toString();
            this.inorder(tree.right);
        }
    }

    public Node searchNode(int id) {
        return this.searchNode(root, id);
    }

    public Node searchNode(Node tree, int id) {
        if(tree == null)
            return null;
        if(id < tree.key)
            return this.searchNode(tree.left, id);
        else if(id > tree.key)
            return this.searchNode(tree.right, id);
        else
            return tree;

    }

    public void showNodeList(){
        this.showNodeList(root);
    }

    private void showNodeList(Node tree){
        if(tree != null){
            this.showNodeList(tree.left);
            tree.serviceOrder.listShow();
            this.showNodeList(tree.right);
        }
    }

    public Node lastNode(Node tree){
        Node lastNodeLeaf = null;

        if(tree != null){
            lastNodeLeaf = this.lastNode(tree.right);
        }

        return lastNodeLeaf;
    }

    public String getNodeList(){
        return nodeList;
    }

    public void insertNode(int key, ServiceOrder serviceOrder) {
        root = insertNode(root, key, serviceOrder);
    }

    private Node insertNode(Node tree, int key, ServiceOrder serviceOrder) {

        if (tree == null)
            return new Node(key, serviceOrder); // Root or new subtree

        if (key < tree.key)
            tree.left = insertNode(tree.left, key, serviceOrder); // New subtree or leaf at left

        else if (key > tree.key)
            tree.right = insertNode(tree.right, key, serviceOrder); // New subtree of leaf at right

        else
            return tree;

        tree.nodeHeight = 1 + bigger(height(tree.left), height(tree.right));// Adjust tree height
        int bf = getBF(tree); // Verify balancing factor
        int leftSubTreeBF = getBF(tree.left);
        int rightSubTreeBF = getBF(tree.right);

        if (bf > 1 && leftSubTreeBF >= 0) {

            return srr(tree); // Simple right rotation

        }

        if (bf < -1 && rightSubTreeBF <= 0) {

            return slr(tree); // Simple left rotation

        }

        if (bf > 1 && leftSubTreeBF < 0) {

            tree.left = slr(tree.left); // Double right rotation
            return srr(tree);

        }

        if (bf < -1 && rightSubTreeBF > 0) {

            tree.right = srr(tree.right); // Double right rotation
            return slr(tree);

        }

        return tree;

    }

    public void removeNode(int key, ServiceOrder serviceOrder) {
        root = removeNode(root, key, serviceOrder);
    }

    private Node removeNode(Node tree, int key, ServiceOrder serviceOrder) {

        if (tree == null)
            return tree;

        if (key < tree.key)
            tree.left = removeNode(tree.left, key, serviceOrder);

        else if (key > tree.key)
            tree.right = removeNode(tree.right, key, serviceOrder);

        else {

            if (tree.left == null && tree.right == null){

                tree = null;
            } else if (tree.left == null) {

                Node temp = tree;
                tree = temp.right;
                temp = null;
            } else if (tree.right == null) {

                Node temp = tree;
                tree = temp.left;
                temp = null;
            } else {

                Node temp = smallerKey(tree.right);
                tree.key = temp.key;
                tree.serviceOrder = temp.serviceOrder;
                temp.key = key;
                temp.serviceOrder = serviceOrder;
                tree.right = removeNode(tree.right, temp.key, temp.serviceOrder);
            }
        }

        if (tree == null)
            return tree;

        tree.nodeHeight = 1 + bigger(height(tree.left), height(tree.right));
        int bf = getBF(tree);
        int leftSubTreeBF = getBF(tree.left);
        int rightSubTreeBF = getBF(tree.right);

        if (bf > 1 && leftSubTreeBF >= 0) {

            return srr(tree);

        }

        if (bf < -1 && rightSubTreeBF <= 0) {

            return slr(tree);

        }

        if (bf > 1 && leftSubTreeBF < 0) {

            tree.left = slr(tree.left);
            return srr(tree);

        }

        if (bf < -1 && rightSubTreeBF > 0) {

            tree.right = srr(tree.right);
            return slr(tree);

        }

        return tree;

    }

    private Node smallerKey(Node tree) {

        Node temp = tree;

        if (temp == null)
            return null;

        while (temp.left != null)
            temp = temp.left;

        return temp;

    }

    private Node srr(Node y) {

        Node x = y.left;
        Node z = x.right;

        x.right = y;
        y.left = z;

        y.nodeHeight = bigger(height(y.left), height(y.right) + 1);
        x.nodeHeight = bigger(height(x.left), height(x.right) + 1);

        return x;

    }

    private Node slr(Node x) {

        Node y = x.right;
        Node z = y.left;

        y.left = x;
        x.right = z;

        x.nodeHeight = bigger(height(x.left), height(x.right) + 1);
        y.nodeHeight = bigger(height(y.left), height(y.right) + 1);

        return y;

    }

    private int getBF(Node tree) {
        if (tree == null)
            return 0;

        return height(tree.left) - height(tree.right);

    }

    private int bigger(int a, int b) {

        return (a > b) ? a : b;

    }

    private int height(Node tree) {

        if (tree == null)
            return -1;

        return tree.nodeHeight;
    }
}
