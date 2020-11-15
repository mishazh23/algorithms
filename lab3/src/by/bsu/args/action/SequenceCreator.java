package by.bsu.args.action;

public class SequenceCreator {
    public static int[] SequenceCreator(int size, int p){
        int[] array = new int[size] ;
        for(int i = 0; i < size; i++){
            array[i] =(int)(Math.random() * (p+1));
            System.out.println(array[i]);
        }
        return array;
    }
}
