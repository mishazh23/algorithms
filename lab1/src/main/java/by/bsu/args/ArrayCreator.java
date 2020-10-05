package by.bsu.args;

public class ArrayCreator {
    public static int[] createArray(int size, int p){
        int[] array = new int[size] ;
        for(int i = 0; i < size; i++){
            array[i] =(int)(Math.random() * (p+1));
        }
        return array;
    }
}
