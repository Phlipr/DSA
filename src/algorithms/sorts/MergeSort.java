package algorithms.sorts;

import java.util.Arrays;

public class MergeSort {
    private static int[] merge(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];

        int index = 0;
        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                mergedArray[index] = array1[i];
                i++;
            } else {
                mergedArray[index] = array2[j];
                j++;
            }
            index++;
        }

        while (i < array1.length) {
            mergedArray[index] = array1[i];
            i++;
            index++;
        }

        while (j < array2.length) {
            mergedArray[index] = array2[j];
            j++;
            index++;
        }

        return mergedArray;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int mid = array.length / 2;

        int[] left = Arrays.copyOfRange(array,0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public static void main(String... args) {
        System.out.println();
        System.out.println("Testing merge helper function:");
        System.out.println();

        int[] array1 = {2, 3, 6, 8};
        int[] array2 = {1, 4, 5, 7};

        System.out.println("Sorted array 1 = " + Arrays.toString(array1));
        System.out.println("Sorted array 2 = " + Arrays.toString(array2));
        System.out.println("Merged array = " + Arrays.toString(merge(array1, array2)));

        System.out.println();
        System.out.println("Testing mergeSort function:");
        System.out.println();

        int[] array = {4, 5, 2, 3, 6, 7, 8};

        System.out.println("Unsorted array = " + Arrays.toString(array));

        System.out.println();
        System.out.println("Merged array = " + Arrays.toString(mergeSort(array)));
    }
}
