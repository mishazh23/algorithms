package by.bsu.args.action;

import by.bsu.args.entity.Entry;
import by.bsu.args.entity.Hash;

public class DoubleHash {
    public void hashDoubleMethod(int key, Entry[] arr, int m, double KNUT) {
        Hash hash = new Hash();
        int h;

        for (int i = 0; i < m; i++) {
            h = (hash.hash1(key, m, KNUT) + i * hash.hash2(key, m)) % m;
            if (arr[h] == null) {
                arr[h] = new Entry(key, h);
                break;
            }
        }
    }
}
