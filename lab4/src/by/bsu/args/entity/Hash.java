package by.bsu.args.entity;

public class Hash {
    public int hash1(int key, int m, double KNUT) {
        return (int) Math.floor(((key * KNUT) % 1) * m);
    }

    public int hash2(int key, int m) {
        return key % (m - 1) + 1;
    }

}
