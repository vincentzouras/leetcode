import java.util.Arrays;

public class mergePractice{
    public static void main(String[]args){
        int[] array = {4, 2, 6, 8, 5, 9, 6, 1, 2, 7};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] inputArray){
        int inputLength = inputArray.length;

        if (inputLength < 2){
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

        // now merge

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
    }
}