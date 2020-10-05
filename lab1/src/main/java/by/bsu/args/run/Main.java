package by.bsu.args.run;

import by.bsu.args.ArrayCreator;
import by.bsu.args.action.MergeHybridSort;
import by.bsu.args.action.QuickHybridSort;
import by.bsu.args.exception.ArrayException;
import java.util.Collections;
import java.util.LinkedList;



public class Main {
    public static void main(String[] args) throws ArrayException {
        int k = 150;
        int p = 1000;
        int m = 10000;
        int n = 1000;
      /*  System.out.println("Enter the size of array: ");
        InfoReader reader = new InfoReader();
        String str = reader.readString(System.in);

        StringFilter filter = new StringFilter();
        int m = filter.filterInt(str);

        System.out.println("Enter the max value of elements in array: ");
        String str1 = reader.readString(System.in);
        int p = filter.filterInt(str1);

        System.out.println("Enter the number of arrays: ");
        String str2 = reader.readString(System.in);
        int n = filter.filterInt(str2);
*/
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            int[] array = ArrayCreator.createArray(m,p);
            System.arraycopy(array, 0, arr[i], 0, m);
        }
        long start, finish;
        LinkedList<Long> timeArray = new LinkedList<Long>();
        int i = 1;
       while(i <= k) {
            long time = 0;
            for(int j = 0; j < n; j++){
                start = System.nanoTime();
               // QuickHybridSort.quickSort(arr[j],0,arr[j].length-1, k);
                MergeHybridSort.mergeSort(k, arr[j],0,arr[j].length-1);
                finish = System.nanoTime();
                time += finish - start;
            }
            timeArray.add(time);
            System.out.println("k="+ i + " time=" + timeArray.getLast());
            i++;
        }
       int r = timeArray.indexOf(findMinTime(timeArray)) + 1;
       System.out.println("min time=" + findMinTime(timeArray) + "  when k=" + r);
    }

    public static long findMinTime(LinkedList<Long> timeArray){
        Long min = Collections.min(timeArray);
        return min;
    }
}
