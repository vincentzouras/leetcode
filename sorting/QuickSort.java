package sorting;

import java.util.Arrays;
import java.util.Random;

/*
 * 1. Choose a pivot
 * 2. Move all numbers less than to the left, greater than to the right of pivot
 * 3. Recursively sort left and right
 * 
 * Time:    O(n log n)
 * Space:   O(log n)
 * 
 * Worst case can become quadratic 
 */

public class QuickSort {
    public static void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    public static void quickSort(int[] A, int left, int right) {
        int index = partition(A, left, right); // returns new index of pivot, with < on left, > on right
        if (left < index - 1) { // sort left subarray, IF has >1 element
            quickSort(A, left, index - 1);
        }
        if (index < right) { // sort right subarray, IF has >1 element
            quickSort(A, index, right);
        }
    }

    public static int partition(int[] A, int left, int right) {
        int pivotIndex = (left + right) / 2; // pick pivot

        // can be smarter about pivot selection
        // int pivotIndex = medianOfThree(A, left, right);
        // int pivotIndex = left + rand.nextInt(right - left + 1);

        int pivot = A[pivotIndex];
        while (left <= right) {
            while (A[left] < pivot) // find element on left that SHOULD be on right
                left++;
            while (A[right] > pivot) // find element on right that SHOULD be on left
                right--;
            if (left <= right) {
                swap(A, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static int medianOfThree(int[] A, int left, int right) {
        int mid = left + (right - left) / 2;

        if (A[left] > A[mid])
            swap(A, left, mid);
        if (A[left] > A[right])
            swap(A, left, right);
        if (A[mid] > A[right])
            swap(A, mid, right);

        return mid;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int iterations = 1000;

        // Perform 1000 iterations
        for (int i = 0; i < iterations; i++) {
            int[] randomNumbers = new int[30];

            // Fill the array with random numbers
            for (int j = 0; j < randomNumbers.length; j++) {
                randomNumbers[j] = random.nextInt(101);
            }

            // Create a copy of the array for comparison
            int[] quickSortArray = Arrays.copyOf(randomNumbers, randomNumbers.length);

            // Sort the array using QuickSort
            quickSort(quickSortArray);

            // Sort the array using the built-in Arrays.sort()
            int[] builtInSortedArray = Arrays.copyOf(randomNumbers, randomNumbers.length);
            Arrays.sort(builtInSortedArray);

            // Cross-reference the two arrays
            if (!Arrays.equals(quickSortArray, builtInSortedArray)) {
                System.out.println("Discrepancy found on iteration " + (i + 1));
                System.out.println("Original: " + Arrays.toString(randomNumbers));
                System.out.println("QuickSort result: " + Arrays.toString(quickSortArray));
                System.out.println("Arrays.sort result: " + Arrays.toString(builtInSortedArray));
                break; // Exit if there's a discrepancy
            }
        }

        System.out.println("All tests passed! The arrays match in all 1000 iterations.");
    }

}
