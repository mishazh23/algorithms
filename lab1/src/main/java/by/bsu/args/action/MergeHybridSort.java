package by.bsu.args.action;

public class MergeHybridSort {
    public static void mergeSort(int k, int[] array, int start, int end){
        if(end-start  < k){
            insertionSort(array, start, end);
        }else{
            int separator = (end+start)/2;
            mergeSort(k, array, start, separator);
            mergeSort(k, array, separator, end);
            merge(array, start,  separator, end);
        }
    }

    public static void merge(int[] array, int start, int separator, int end){
        int firstIndex = start;
        int secondIndex = separator+1;
        int[] temp = new int[end + 1];
        for(int i = start; i <= end; i++){
            if(firstIndex <= separator && (secondIndex > end || array[firstIndex] <= array[secondIndex])){
                temp[i] = array[firstIndex];
                firstIndex++;
            }else{
                temp[i] = array[secondIndex];
                secondIndex++;
            }
        }
        for(int i = start; i <= end; i++){
            array[i] = temp[i];
        }
    }

    public static void insertionSort(int[] array, int start, int end){
        int value;
        for (int j = start + 1; j <= end; j++) {
            value = array[j];
            int i = j-1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
    }
}
