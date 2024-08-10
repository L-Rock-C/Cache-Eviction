package app;

import model.AVLTree;

public class Main {
    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        tree.inserir(21, "21");
        tree.inserir(20, "20");
        tree.inserir(24, "24");
        tree.inserir(22, "22");
        tree.inserir(25, "25");
        tree.inserir(27, "27");

        tree.ordem();

        tree.remover(24, "24");

        System.out.println();
        tree.ordem();

    }
}
