package by.bsu.args.entity;

public class Entry {
    public Entry next;
    public int key;
    public int hash;

    public Entry(int key, int hash) {
        this.key = key;
        this.hash = hash;
        this.next = null;
    }


}
