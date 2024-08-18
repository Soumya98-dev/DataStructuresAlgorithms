public class Main {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildBST(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = buildBST(root.left, val);
        }
        if (val > root.data) {
            root.right = buildBST(root.right, val);
        }

        return root;

    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean searchRecursive(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.data) {
            System.out.println(root.data);
            return true;
        }

        if (key < root.data) {
            return searchRecursive(root.left, key);
        }

        else {
            return searchRecursive(root.right, key);
        }
    }

    public static boolean searchIterative(Node root, int key) {
        while (root != null) {
            if (key == root.data) {
                return true;
            }
            if (key < root.data) {
                root = root.left;
                continue;
            }
            if (key > root.data) {
                root = root.right;
                continue;
            }
        }

        return false;
    }

    public static int min(Node root) {
        int minVal = 100;
        while (root != null) {
            if (root.data < minVal) {
                minVal = root.data;
            }
            root = root.left;
        }

        return minVal;
    }

    public static int max(Node root) {
        int maxVal = 0;
        while (root != null) {
            if (root.data > maxVal) {
                maxVal = root.data;
            }
            root = root.right;
        }

        return maxVal;
    }

    public static Node inorderSuccessor(Node root, int val) {
        Node successor = null;

        while (root != null) {
            if (val >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;

    }

    public static int inorderPredecessor(Node root, int val) {
        Node pred = null;

        while (root != null) {
            if (val <= root.data) {
                root = root.left;
            } else {
                pred = root;
                root = root.right;
            }
        }

        return pred.data;
    }

    public static void insertNode(Node val, Node root) {
        Node current = root;
        Node prevRoot = null;

        while (current != null) {
            prevRoot = current;
            if (val.data <= current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (val.data <= prevRoot.data) {
            prevRoot.left = val;
        }

        if (val.data > prevRoot.data) {
            prevRoot.right = val;
        }

    }

    public static void deleteLeafNode(Node root) {
        Node current = root;
        Node prevCurrent = null;

        while (current != null) {
            prevCurrent = current;
            if (current.left == null && current.right == null) {
                current = null;
            }
            current = current.left;
        }
    }

    public static void main(String[] args) {
        int[] values = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = buildBST(root, values[i]);
        }

        Node nd = new Node(6);
        insertNode(nd, root);
        inOrder(root);
        System.out.println();

        // System.out.println(searchRecursive(root, 3));
        // System.out.println(searchIterative(root, 3));

        // System.out.println(min(root));
        // System.out.println(max(root));
        // System.out.println(inorderSuccessor(root, 5).data);
        // System.out.println(inorderPredecessor(root, 5));

    }

}