package model;

public class AVLTree {

    Node root = null;

    public AVLTree() {

    }

    public void ordem() {
        this.ordem(root);
    }

    private void ordem(Node arv) {

        if (arv != null) {
            this.ordem(arv.left);
            System.out.print(arv.key + " ");
            this.ordem(arv.right);
        }

    }

    public void inserir(int ch, String v) {
        root = inserir(root, ch, v);
    }

    private Node inserir(Node arv, int ch, String v) {

        if (arv == null)
            return new Node(ch, v); // Root or new subtree

        if (ch < arv.key)
            arv.left = inserir(arv.left, ch, v); // New subtree or leaf at left

        else if (ch > arv.key)
            arv.right = inserir(arv.right, ch, v); // New subtree of leaf at right

        else
            return arv;

        arv.nodeHeight = 1 + maior(altura(arv.left), altura(arv.right));// Adjust tree height
        int fb = obterFB(arv); // Verify balancing factor
        int fbSubArvEsq = obterFB(arv.left);
        int fbSubArvDir = obterFB(arv.right);

        if (fb > 1 && fbSubArvEsq >= 0) {

            return rds(arv); // Simple right rotation

        }

        if (fb < -1 && fbSubArvDir <= 0) {

            return res(arv); // Simple left rotation

        }

        if (fb > 1 && fbSubArvEsq < 0) {

            arv.left = res(arv.left); // Double right rotation
            return rds(arv);

        }

        if (fb < -1 && fbSubArvDir > 0) {

            arv.right = rds(arv.right); // Double right rotation
            return res(arv);

        }

        return arv;

    }

    public void remover(int ch, String v) {
        root = remover(root, ch, v);
    }

    private Node remover(Node arv, int ch, String v) {

        if (arv == null)
            return arv;

        if (ch < arv.key)
            arv.left = remover(arv.left, ch, v);

        else if (ch > arv.key)
            arv.right = remover(arv.right, ch, v);

        else {

            if (arv.left == null && arv.right == null)

                arv = null;

            else if (arv.left == null) {

                Node temp = arv;
                arv = temp.right;
                temp = null;
            }

            else if (arv.right == null) {

                Node temp = arv;
                arv = temp.left;
                temp = null;
            } else {

                Node temp = menorChave(arv.right);
                arv.key = temp.key;
                arv.value = temp.value;
                temp.key = ch;
                temp.value = v;
                arv.right = remover(arv.right, temp.key, temp.value);

            }

        }

        if (arv == null)
            return arv;

        arv.nodeHeight = 1 + maior(altura(arv.left), altura(arv.right));
        int fb = obterFB(arv);
        int fbSubArvEsq = obterFB(arv.left);
        int fbSubArvDir = obterFB(arv.right);

        if (fb > 1 && fbSubArvEsq >= 0) {

            return rds(arv);

        }

        if (fb < -1 && fbSubArvDir <= 0) {

            return res(arv);

        }

        if (fb > 1 && fbSubArvEsq < 0) {

            arv.left = res(arv.left);
            return rds(arv);

        }

        if (fb < -1 && fbSubArvDir > 0) {

            arv.right = rds(arv.right);
            return res(arv);

        }

        return arv;

    }

    private Node menorChave(Node arv) {

        Node temp = arv;

        if (temp == null)
            return null;

        while (temp.left != null)
            temp = temp.left;

        return temp;

    }

    private Node rds(Node y) {

        Node x = y.left;
        Node z = x.right;

        x.right = y;
        y.left = z;

        y.nodeHeight = maior(altura(y.left), altura(y.right) + 1);
        x.nodeHeight = maior(altura(x.left), altura(x.right) + 1);

        return x;

    }

    private Node res(Node x) {

        Node y = x.right;
        Node z = y.left;

        y.left = x;
        x.right = z;

        x.nodeHeight = maior(altura(x.left), altura(x.right) + 1);
        y.nodeHeight = maior(altura(y.left), altura(y.right) + 1);

        return y;

    }

    private int obterFB(Node arv) {
        if (arv == null)
            return 0;

        return altura(arv.left) - altura(arv.right);

    }

    private int maior(int a, int b) {

        return (a > b) ? a : b;

    }

    private int altura(Node arv) {

        if (arv == null)
            return -1;

        return arv.nodeHeight;
    }
}
