/*
 * INSERTION SORT
 * 
 * Incremental approach:
 *      Start with second element and maintain the front of the list as a sorted porton of the list, inserting the next element after the sorted section into the appropriate spot in the sorted section.
 * 
 * O(n^2)
 */

package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) { // begin with second val because first val already sorted
            int curr = array[i];
            int j = i - 1; // start with prev val
            while (j >= 0 && array[j] > curr) { // walk back to start, stop if reached start or val <= val inserting
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] randomNumbers = new int[30];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(101);
        }
        System.out.println(Arrays.toString(randomNumbers));
        insertionSort(randomNumbers);
        System.out.println(Arrays.toString(randomNumbers));
    }
}
