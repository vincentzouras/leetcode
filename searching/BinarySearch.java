package searching;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while (lowIndex <= highIndex) {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;
            int midValue = array[midIndex];
            if (midValue == target)
                return midIndex;
            else if (target < midValue)
                highIndex = midIndex - 1;
            else if (target > midValue)
                lowIndex = midIndex + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] randomNumbers = new int[30];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(101);
        }
        Arrays.sort(randomNumbers);
        System.out.println(Arrays.toString(randomNumbers));
        Scanner input = new Scanner(System.in);
        System.out.println(binarySearch(randomNumbers, input.nextInt()));
        input.close();
    }
}
