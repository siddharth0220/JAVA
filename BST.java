public class BST {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root = null;

    public void crateBST(int arr[]) {
        if (arr.length <= 0)
            return;
        root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            Node currentNode = new Node(arr[i]);
            insert(root, currentNode);
        }
    }

    public void insert(Node root, Node currentNode) {
        if (root.data <= currentNode.data) {
            if (root.right == null) {
                root.right = currentNode;
            } else {
                insert(root.right, currentNode);
            }
        } else {
            if (root.left == null) {
                root.left = currentNode;
            } else {
                insert(root.left, currentNode);
            }
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int arr[] = { 7, 3, 1, 21, 34 };
        bst.crateBST(arr);
        bst.inOrder(bst.root);
    }
}
