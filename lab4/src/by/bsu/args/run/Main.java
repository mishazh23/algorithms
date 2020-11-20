package by.bsu.args.run;

import by.bsu.args.action.Chaining;
import by.bsu.args.entity.HashTable;

import java.util.List;

public class Main {

    private static final double KNUT = (Math.sqrt(5) - 1) / 2;
    private static final double MY_CONSTANT = 0.876876432;

    public static void main(String[] args) {
        int p = 10, n = 100, r = 10000, m = 107;
        List<int[]> keys = HashTable.generateKeys(p, r, n);
        System.out.println("-----------------CHAINING METHOD-----------------");
        Chaining.chainingDemonstration(m, p, n,  MY_CONSTANT, keys);
        System.out.println("\n\n" + "-----------------MY CONSTANT-----------------");
        Chaining.chainingLengthDemonstration(m, p, n, MY_CONSTANT, keys);
        System.out.println("\n\n" + "-----------------KNUT CONSTANT-----------------");
        Chaining.chainingLengthDemonstration(m, p, n, KNUT, keys);



    }
}
