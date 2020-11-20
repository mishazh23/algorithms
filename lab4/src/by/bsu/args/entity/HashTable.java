package by.bsu.args.entity;

import by.bsu.args.action.Creator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HashTable {

    public static List<int[]> generateKeys(int p, int r, int n){
        List<int[]> keysArrayList = new ArrayList<>();
        Creator create = new Creator();
        for (int i = 0; i < p; i++){
            keysArrayList.add(create.createArray(r,n));
        }
        return keysArrayList;
    }

    public static List<Entry[]> generateHashTable(int p, int m){
        List<Entry[]> hashTable = new ArrayList<>();
        for(int i = 0; i < p; i++){
            hashTable.add(new Entry[m]);
        }
        return hashTable;
    }

    public static int getLength(Entry entry){
        int length = 0;
        while (entry != null) {
            entry = entry.next;
            length++;
        }
        return length;
    }

    public static int findMaxLength(Entry[] arr) {
        ArrayList<Integer> lengthArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            lengthArray.add(getLength(arr[i]));
        }
        return Collections.max(lengthArray);
    }

    public static void toString(Entry entry) {
        if (entry != null) {
            System.out.print("{key:" + entry.key + ", data:" + entry.hash);
            while (entry.next != null) {
                System.out.print(" -> key:" + entry.next.key + ", data:" + entry.next.hash);
                entry = entry.next;
            }
            System.out.print("} ");
        } else {
            System.out.print("{" + null + "} ");
        }
    }
}
