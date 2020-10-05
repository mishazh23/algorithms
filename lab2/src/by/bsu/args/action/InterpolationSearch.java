package by.bsu.args.action;

public class InterpolationSearch {
    public static int interpolationSearch(int[] array, int x) {
        int startIndex = 0;
        int lastIndex = (array.length - 1);

        while ((startIndex <= lastIndex) && (x >= array[startIndex]) && (x <= array[lastIndex])) {
            int pos = startIndex + (((lastIndex-startIndex) / (array[lastIndex]-array[startIndex])) * (x - array[startIndex]));
            if (array[pos] == x) {
                return pos;
            }
            if (array[pos] < x) {
                startIndex = pos + 1;
            }
            else {
                lastIndex = pos - 1;
            }
        }
        return -1;
    }
}
