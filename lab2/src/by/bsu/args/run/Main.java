package by.bsu.args.run;

import by.bsu.args.action.ArrayCreator;
import by.bsu.args.action.BinarySearch;
import by.bsu.args.action.InterpolationSearch;
import by.bsu.args.exception.ArrayException;
import by.bsu.args.filter.StringFilter;
import by.bsu.args.reader.InfoReader;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws ArrayException {
        System.out.println("-----BINARY SORT-----" + "\n");
        System.out.println("Enter element to find: ");
        InfoReader reader = new InfoReader();
        String str = reader.readString(System.in);

        StringFilter filter = new StringFilter();

        int x = filter.filterInt(str);
        int p = 10;
        int n = 100;

        int[] array = ArrayCreator.createArray(n, p);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int indexOfX = BinarySearch.findElementInArray(array, x);

        if(indexOfX == -1){
            System.out.println("There is no such element in the array!");
        }else{
            System.out.println("index of x: " + indexOfX);
        }

        System.out.println("-----INTERPOLATION SORT-----" + "\n");
        System.out.println("Enter element to find: ");
        String str1 = reader.readString(System.in);
        x = filter.filterInt(str1);
        indexOfX = InterpolationSearch.interpolationSearch(array, x);
        if(indexOfX == -1){
            System.out.println("There is no such element in the array!");
        }else{
            System.out.println("index of x: " + indexOfX);
        }
    }
}
