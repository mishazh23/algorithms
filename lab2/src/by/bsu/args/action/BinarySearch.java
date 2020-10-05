package by.bsu.args.action;

public class BinarySearch {
    public static int findElementInArray(int[] array, int x){
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int counter = 1;
        while(firstIndex <= lastIndex) {
            counter ++;
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] == x) {
                System.out.println("Number of comparison operation: " + counter);
                return middleIndex;
            }else{
                counter++;
                 if (array[middleIndex] < x) {
                     firstIndex = middleIndex + 1;
                  }else{
                     lastIndex = middleIndex - 1;
                 }
            }
        }
        System.out.println("Number of comparison operation" + counter);
        return -1;
    }
}
