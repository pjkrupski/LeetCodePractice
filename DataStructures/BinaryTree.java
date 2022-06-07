package DataStructures;
import java.util.*;
//Reference for dfs algos
//https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
public class BinaryTree {
    Node root;
    static boolean found = false;
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
    public void depthFirstSearch(int target, String order){
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
        found = false;
    }

    /**
    Global boolean used to end recursive searching for all 3 depth first traversals
    returning the node has no effect, once the correct number is found the algorithm
    would continue to traverse the entire tree otherwise
    Returning the node all the way to main results in trees root being returned
     */

    /**
     *    Algorithm Postorder(tree)
     *    1. Traverse the left subtree, i.e., call Postorder(left-subtree)
     *    2. Traverse the right subtree, i.e., call Postorder(right-subtree)
     *    3. Visit the root.
     */
    static void postOrder(Node node, int target) {
        if (node == null)
            return;
        System.out.println(node.data + " Traversed");

        if(!found){
            postOrder(node.left, target);
        }

        if(!found){
            postOrder(node.right, target);
        }

        System.out.println("Checking "+node.data);
        if(node.data == target) {
            System.out.println("Node data: "+node.data+" found to equal target: "+target);
            found = true;
        }
    }

    /**
     * Algorithm Inorder(tree)
     *    1. Traverse the left subtree, i.e., call Inorder(left-subtree)
     *    2. Visit the root.
     *    3. Traverse the right subtree, i.e., call Inorder(right-subtree)
     */
    static void inOrder(Node node, int target) {
        if (node == null)
            return;
        System.out.println(node.data + " Traversed");

        if(!found){
            inOrder(node.left, target);
        }

        System.out.println("Checking "+node.data);
        if(node.data == target) {
            System.out.println("Node data: "+node.data+" found to equal target: "+target);
            found = true;
        }

        if(!found){
            inOrder(node.right, target);
        }
    }

    /**
     * Algorithm Preorder(tree)
     *    1. Visit the root.
     *    2. Traverse the left subtree, i.e., call Preorder(left-subtree)
     *    3. Traverse the right subtree, i.e., call Preorder(right-subtree)
     */
    static void preOrder(Node node, int target) {
        if (node == null)
            return;
        System.out.println("Traversing and checking "+node.data);
        if(node.data == target) {
            System.out.println("Node data: "+node.data+" found to equal target: "+target);
            found = true;
            return;
        }
        if(!found){
            preOrder(node.left, target);
        }
        if(!found){
            preOrder(node.right, target);
        }
    }

    public void search(int target){
        locate(this.root, target);
    }

    static void locate(Node node, int target){
        if(node == null){
            System.out.println("NULL LEAF");
            return;
        }
        System.out.println(node.data);
        if(node.data == target){
            System.out.println("Node data: "+node.data+" found to equal target: "+target);
        }
        if(node.data > target){
            locate(node.left, target);
        }else if(node.data < target){
            locate(node.right, target);
        }
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
