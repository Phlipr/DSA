package algorithms.sorts;

import java.util.Arrays;

public class QuickSort {
    private static void swap(int[] array, int pivotIndex, int swapIndex) {
        int temp = array[swapIndex];
        array[swapIndex] = array[pivotIndex];
        array[pivotIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    public static void main(String... args) {
        System.out.println();
        System.out.println("Testing the quickSort method:");
        System.out.println();

        int[] array = {5, 3, 4, 2, 10, 7};

        System.out.println("Unsorted array = " + Arrays.toString(array));
        System.out.println();

        quickSort(array);

        System.out.println("Sorted array = " + Arrays.toString(array));
    }
}
