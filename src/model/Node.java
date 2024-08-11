package model;

public class Node {

    int key;
    ServiceOrder serviceOrder;
    int nodeHeight;
    Node left, right;

    public Node(int key, ServiceOrder serviceOrder) {
        this.key = key;
        this.serviceOrder = serviceOrder;
    }
}