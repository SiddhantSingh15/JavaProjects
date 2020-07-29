package com.company;

class Node{
    int data;
    Node left;
    Node right;
}

class BST{
    public Node createNewNode(int k){
        Node a = new Node();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }

    public Node insert(Node node, int val){
        if (node == null){
            return createNewNode(val);
        }

        if(val < node.data){
            node.left = insert(node.left, val);
        } else if(val > node.data){
            node.right = insert(node.right, val);
        }

        return node;
    }

    public void preOrder(Node root){
        if(root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
}

public class BinaryTree {

    public static void main(String[] args) {
	    BST tree = new BST();
	    Node root;

	    root = tree.insert(null, 8);
	    root = tree.insert(root, 3);
	    root = tree.insert(root, 6);
	    root = tree.insert(root, 10);
        root = tree.insert(root, 4);
        root = tree.insert(root, 7);
        root = tree.insert(root, 1);
        root = tree.insert(root, 14);
        root = tree.insert(root, 13);

        tree.preOrder(root);
        System.out.println("------");
        tree.inOrder(root);
        System.out.println("------");
        tree.postOrder(root);
        System.out.println("------");

    }
}
