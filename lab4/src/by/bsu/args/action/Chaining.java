package by.bsu.args.action;

import by.bsu.args.entity.Entry;
import by.bsu.args.entity.Hash;
import by.bsu.args.entity.HashTable;

import java.util.List;

public class Chaining {
    public static void hashChainingMethod(int key, Entry[] arr, int m, double KNUT) {
        Hash hash = new Hash();
        int h = hash.hash1(key, m, KNUT);
        if (arr[h] == null) {
            arr[h] = new Entry(key, h);
        } else {
            Entry temp = arr[h];
            arr[h] = new Entry(key, h);
            arr[h].next = temp;
        }
    }

    public static void chainingDemonstration(int m, int p, int n, double KNUT, List<int[]> keyArrayList){
        HashTable table = new HashTable();
        List<Entry[]> hashTable = table.generateHashTable(p, m);
        int j = 0;
        for(int[] array : keyArrayList) {
            for (int i = 0; i < n; i++) {
                hashChainingMethod(array[i], hashTable.get(j), m , KNUT);
            }
            j++;
        }
        int counter = 0;
        for (Entry[] entry: hashTable) {
            System.out.print( counter + ") [");
            for (int i = 0; i < m; i++) {
                HashTable.toString(entry[i]);
            }
            System.out.print("]" + "\n");
            counter++;
        }
    }

    public static void chainingLengthDemonstration(int m, int p, int n, double KNUT, List<int[]> keyArrayList){
        HashTable table = new HashTable();
        List<Entry[]> hashTable = table.generateHashTable(p, m);
        int j = 0;
        for(int[] array : keyArrayList) {
            for (int i = 0; i < n; i++) {
                hashChainingMethod(array[i], hashTable.get(j), m , KNUT);
            }
            j++;
        }

        System.out.println("\n" + "Max length: ");
        for (int i = 0; i < p; i++) {
            System.out.print( HashTable.findMaxLength(hashTable.get(i)) + " ");
        }
        System.out.print("\n");
    }

}
