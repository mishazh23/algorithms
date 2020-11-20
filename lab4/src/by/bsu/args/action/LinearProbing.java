package by.bsu.args.action;

import by.bsu.args.entity.Entry;
import by.bsu.args.entity.Hash;

public class LinearProbing {
    public void hashLinearMethod(int key, Entry[] arr, int m, double KNUT) {
        Hash hash = new Hash();
        int h = hash.hash1(key, m, KNUT);

        for (int i = 0; arr[h] != null && i < m; i++) {
            h = (h + i) % m;
        }
        arr[h] = new Entry(key, h);
    }
}
