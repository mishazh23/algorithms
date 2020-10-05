package by.bsu.tests;
import by.bsu.args.action.QuickHybridSort;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class QuickHybridSortTest {
    @Test
    public void insertionSortTest(){
        int[] array = {3, 5, 1, 0, 9, 8, 6, 4, 2, 7, 10, 1};
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        QuickHybridSort.insertionSort(array,0,array.length-1);
        int[] actual = array;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void quickHybridSortTest(){
      int[] array = {3, 5, 1, 0, 9, 8, 6, 4, 2, 7, 10, 5, 1, 3, 2, 4};
      int[] expected = {0 , 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10};
        QuickHybridSort.quickSort(array,0,array.length-1,3);
      int[] actual = array;
        Assert.assertEquals(actual, expected);
    }
}
