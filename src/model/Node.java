package model;

public class Node {

    int key;
    String value;
    int nodeHeight;
    Node left, right;

    public Node(int k, String v) {
        key = k;
        value = v;
    }
}