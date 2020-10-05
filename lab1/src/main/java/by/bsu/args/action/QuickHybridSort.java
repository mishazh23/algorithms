package by.bsu.args.action;


public class QuickHybridSort {
    public static void quickSort(int[] array, int start, int end, int k){
        if(end-start < k){
           insertionSort(array, start, end);
        }else{
            int separator = separation(array, start, end);
            quickSort(array, start, separator-1, k);
            quickSort(array, separator, end, k);
        }
    }
    public static int separation(int[] array, int start, int end){
        int random = (int)(Math.random()* (end-start)) + start;
        int separator = array[random];
        int left = start;
        int right = end;

        while (left <= right){

            while (array[left] < separator){
                left++;
            }
            while (array[right] > separator){
                right--;
            }

            if(left <= right){
                swap(array, right, left);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array [b];
        array[b] = tmp;
    }
    public static void insertionSort(int[] array, int start, int end){
        for (int j = start; j <= end; j++) { //5
            int value = array[j]; //2
            int i = j-1; //2
            for (; i >= 0; i--) { //3
                if (value < array[i]) { //2
                    array[i + 1] = array[i]; //4
                } else {
                    break;
                }
            }
            array[i + 1] = value;//3
        }
    }
}
