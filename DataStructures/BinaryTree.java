package DataStructures;
import java.util.*;
public class BinaryTree {
    Node root;
    public BinaryTree(Node root) {
        this.root = root;
    }
    private static class Node{
        int data;
        Node left = null;
        Node right = null;
        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void insert(int target){
        add(this.root, target);
    }
    public void add(Node root, int input){
        if(root == null){
            this.root = new Node(input);
        }else if(root.left == null && root.data > input){
            root.left = new Node(input, null, null);
        }else if(root.right == null && root.data < input){
            root.right = new Node(input, null, null);
        }else if(root.data < input){
            add(root.right, input);
        }else if(root.data > input){
            add(root.left, input);
        }
    }

    //Time Complexity: O(n) where n is the number of nodes in the binary tree
    public void breadthFirstSearch(int target){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.println("Traversed "+tempNode.data);
            if(tempNode.data == target) {
                System.out.println("Node data: " + tempNode.data + " found to equal target: " + target);
                break;
            }
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    //Time Complexity: O(n)
    public Node depthFirstSearch(int target, String order){
        switch(order){
            case "postorder":
                postOrder(this.root, target);
                break;
            case "inorder":
                inOrder(this.root, target);
                break;
            case "preorder":
                preOrder(this.root, target);
                break;
            default:
                System.out.println("Invalid search option");
        }
        return null;
    }

    static void postOrder(Node node, int target) {
        if (node == null)
            return;
        postOrder(node.left, target);
        postOrder(node.right, target);
        System.out.println(node.data + " ");
        if(node.data == target) {
            System.out.println("Node data: "+node.data+" found to equal target: "+target);
        }

    }

    static void inOrder(Node node, int target) {
        if (node == null)
            return;
        inOrder(node.left, target);
        System.out.println(node.data + " ");
        //Should if statement be at bottom of function?
        if(node.data == target) {
            System.out.println("Node data: "+node.data+" found to equal target: "+target);
        }
        inOrder(node.right, target);
    }

    static void preOrder(Node node, int target) {
        if (node == null)
            return;
        System.out.println(node.data + " ");
        if(node.data == target) {
            System.out.println("Node data: "+node.data+" found to equal target: "+target);
            return;
        }
        preOrder(node.left, target);
        if(node.data == target) {
            System.out.println("Node data: "+node.data+" found to equal target: "+target);
            return;
        }
        preOrder(node.right, target);
    }

    public void delete(int data){
        removeNode(this.root, data);
    }

    static Node removeNode(Node root, int data) {

        if (root == null)
            return root;

        if (data < root.data) {
            root.left = removeNode(root.left, data);
        }
        else if (data > root.data) {
            root.right = removeNode(root.right, data);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = removeNode(root.right, root.data);
        }

        return root;
    }

    static int minValue(Node root) {
        int minVal = root.data;
        while (root.left != null)
        {
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

    public void invert(){

    }
}
