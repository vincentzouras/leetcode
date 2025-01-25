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
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
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
