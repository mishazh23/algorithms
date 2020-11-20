package by.bsu.args.action;

import java.util.ArrayList;
import java.util.List;

public class Creator {
    public int[] createArray(int r, int n) {
        int[] array = new int[n];
        List<Integer> set = new ArrayList<>(n);
        while (set.size() <= n) {
            int value = (int) (Math.random() * r + 1);
            if (!set.contains(value)) {
                set.add(value);
            }
        }
        for (int i = 0; i < n; i++) {
            array[i] = set.get(i);
        }
        return array;
    }
}
