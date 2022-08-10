package algorithms.sorts;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i];
            while (j > -1 && temp < array[j]) {
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

    public static void main(String... args) {
        int[] array = {4, 2, 6, 3, 1, 5};

        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }
}
