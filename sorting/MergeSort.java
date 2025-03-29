/*
 * MERGE SORT
 * 
 * Divide-and-conquer approach: 
 *      DIVIDE the problem into smaller subproblems
 *      CONQUER the subproblems by solving them recursively
 *      COMBINE the solutions of the subproblems to solve the original
 * 
 * 1. Continue to split array in half until it's broken into subarrays with one element or empty
 * 2. Recombine each subarray keeping the sorted order
 * 
 * O(n log n)
 */

package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void mergeSort(int[] A) {
        if (A.length < 2)
            return; // arrays with one element are sorted
        int mid = A.length / 2;
        int[] leftHalf = new int[mid]; // initialize two arrays for left and right half
        int[] rightHalf = new int[A.length - mid];
        for (int i = 0; i < mid; i++) { // populate arrays with the left and right half of input array
            leftHalf[i] = A[i];
        }
        for (int i = mid; i < A.length; i++) {
            rightHalf[i - mid] = A[i];
        }
        mergeSort(leftHalf); // recursively sort left and right halves
        mergeSort(rightHalf);
        merge(A, leftHalf, rightHalf); // combine pieces back together
    }

    public static void merge(int[] A, int[] leftHalf, int[] rightHalf) {
        int i = 0, j = 0, k = 0; // one variable to iterate through each array
        while (i < leftHalf.length && j < rightHalf.length) { // while there is element in each array to compare to
            if (leftHalf[i] <= rightHalf[j]) { // if left val is smaller, add it to array
                A[k] = leftHalf[i];
                i++;
            } else { // otherwise add right val to array
                A[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftHalf.length) { // add remaining values if left or right isn't empty
            A[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightHalf.length) {
            A[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] randomNumbers = new int[30];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(101);
        }
        System.out.println(Arrays.toString(randomNumbers));
        mergeSort(randomNumbers);
        System.out.println(Arrays.toString(randomNumbers));
    }
}
