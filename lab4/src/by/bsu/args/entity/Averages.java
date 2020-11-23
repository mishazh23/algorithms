package by.bsu.args.entity;

import by.bsu.args.action.SortByLenght;
import by.bsu.args.entry.Entry;

import java.util.Arrays;
import java.util.LinkedList;

public class Averages {
    public static double getAverageChainLength(HashChain map) {
        LinkedList<Entry>[] lists = map.lists;
        double elems = 0;
        int count = 0;
        for (LinkedList<Entry> list: lists) {
            if (list != null) {
                elems += list.size();
                if (list.size() > 0) {
                    count++;
                }
            }
        }
        return elems / count;
    }

    public static double getMediumChainLength(HashChain map) {
        LinkedList<Entry>[] lists = map.lists;
        Arrays.sort(lists, new SortByLenght());
        return lists[lists.length / 2].size();
    }
}
