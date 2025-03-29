/*
 * SELECTION SORT
 * 
 * For each element, find the smallest value in array and swap it with that element.
 * 
 * O(n^2)
 */

package sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] randomNumbers = new int[30];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(101);
        }
        System.out.println(Arrays.toString(randomNumbers));
        selectionSort(randomNumbers);
        System.out.println(Arrays.toString(randomNumbers));
    }
}
