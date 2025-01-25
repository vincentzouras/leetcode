import java.util.Arrays;
import java.util.Random;

public class Algorithms{
    public static void main(String[]args){
        int[] array = {4, 2, 6, 8, 5, 9, 6, 1, 2, 7};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int binarySearch(int[] inputArray, int targetValue){ //   O(log n)
        // needs to be sorted
        int lowIndex = 0;
        int highIndex = inputArray.length - 1;

        while (lowIndex <= highIndex){
            int midIndex = lowIndex + (highIndex - lowIndex)/ 2;
            int midValue = inputArray[midIndex];
            if (midValue < targetValue) lowIndex = midIndex + 1;
            else if (midValue > targetValue) highIndex = midIndex - 1;
            else return midIndex;
        }        
        return -1;
    }

    public static void quickSort(int[] inputArray, int lowIndex, int highIndex){
        // choose pivot -> partition -> recursive calls

        // choose pivot 

        if (lowIndex >= highIndex){
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = inputArray[pivotIndex];
        swap(inputArray, pivotIndex, highIndex);

        // partitioning

        int left = lowIndex;
        int right = highIndex;

        while (left < right){
            while (inputArray[left] <= pivot && left < right){ // move left pointer until value > pivot
                left++;
            }
            while (inputArray[right] >= pivot && left < right){ // move right pointer until value < pivot
                right--;    
            }
            // swap left and right elements
            swap(inputArray, left, right);
        }
        // swap pivot and element theyre pointing to
        swap(inputArray, left, highIndex);

        // recursive calls

        quickSort(inputArray, lowIndex, left - 1);
        quickSort(inputArray, left + 1, highIndex);
    }
    public static void quickSort(int[] inputArray){ // overloading lol
        quickSort(inputArray, 0, inputArray.length - 1);
    }

    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void mergeSort(int[] inputArray){ //      O(n log n)
        int inputLength = inputArray.length;

        if (inputLength < 2) { 
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++){
            leftHalf[i] = inputArray[i]; 
        }
        for (int i = midIndex; i < inputLength; i++){
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // now merge them  
        
        int leftLength = leftHalf.length;
        int rightLength = rightHalf.length;
        
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength){
            if (leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftLength){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightLength){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
        return;
    }
}