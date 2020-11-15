package by.bsu.args.entity;

public class Node {
    public int value;
    public Node left;
    public Node right;
    public int lCount;
    public int rCount;

    public Node(int value){
        this.value = value;
        this.lCount = 0;
        this.rCount = 0;
    }

    public boolean hasDirectChild(Node node){
        return this.left == node || this.right == node;
    }

    public boolean hasNoChild(){
        return this.left == null && this.right == null;
    }
}
