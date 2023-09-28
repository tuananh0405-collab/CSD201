package Tree;

import org.w3c.dom.Node;

public class TreeSearch {

    public Node root;

    static class Node {
        int key;
        Node left, right;

        Node(int data) {
            this.key = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int key) {
        root = insert_Recursive(root, key);
    }

    Node insert_Recursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)
            root.right = insert_Recursive(root.right, key);
        return root;
    }


    public boolean search(int key) {
        root = search_Recursive(root, key);
        if (root != null)
            return true;
        else
            return false;
    }

    Node search_Recursive(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        if (root.key > key)
            return search_Recursive(root.left, key);
        return search_Recursive(root.right, key);
    }
    public Node getRoot(){
        return  this.root;
    }
    public void printInorder(Node node)
    {
        if (node == null)
            return;

        printInorder(node.left);

        System.out.print(node.key + " ");

        printInorder(node.right);
    }
    public void printPreorder(Node node)
    {
        if (node == null)
            return;

        System.out.print(node.key + " ");

        printPreorder(node.left);

        // Now recur on right subtree
        printPreorder(node.right);
    }
    public void printPostorder(Node node)
    {
        if (node == null)
            return;

        printPostorder(node.left);

        printPostorder(node.right);

        System.out.print(node.key + " ");
    }

}
