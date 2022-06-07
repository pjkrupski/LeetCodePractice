package DataStructures;

//Driver for testing datastructures
public class Main {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree(null);
        bt.add(bt.root, 100);
        bt.add(bt.root, 50);
        bt.add(bt.root, 80);
        bt.add(bt.root, 40);
        bt.add(bt.root, 70);
        bt.add(bt.root, 20);
        bt.add(bt.root, 30);
        bt.add(bt.root, 60);
        bt.add(bt.root, 10);
        bt.add(bt.root, 90);
        bt.add(bt.root, 89);
        bt.add(bt.root, 91);
        bt.add(bt.root, 150);
        bt.add(bt.root, 180);
        bt.add(bt.root, 140);
        bt.add(bt.root, 170);
        bt.add(bt.root, 120);
        bt.add(bt.root, 130);
        bt.add(bt.root, 160);
        bt.add(bt.root, 110);
        bt.add(bt.root, 190);
        bt.breadthFirstSearch(40);

        //bt.depthFirstSearch(90, "preorder");
        //bt.search(89);

    }
}
