package ru.svistunovaleksei.homework1.task2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {5,6,3,2,5,1,4,9};
        sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int[] arrayA = new int[array.length / 2];
        System.arraycopy(array, 0, arrayA, 0, array.length / 2);

        int[] arrayB = new int[array.length - arrayA.length];
        System.arraycopy(array, arrayA.length, arrayB, 0, array.length - arrayA.length);

        sortArray(arrayA);
        sortArray(arrayB);

        mergeArray(array, arrayA, arrayB);
    }

    private static void mergeArray(int[] mainArray, int[] arrayA, int[] arrayB) {

        int positionA = 0;
        int positionB = 0;

        for (int i = 0; i < mainArray.length; i++) {
            if (positionA == arrayA.length) {
                mainArray[i] = arrayB[positionB];
                positionB++;

            } else if (positionB == arrayB.length) {
                mainArray[i] = arrayA[positionA];
                positionA++;

            } else if (arrayA[positionA] < arrayB[positionB]) {
                mainArray[i] = arrayA[positionA];
                positionA++;

            } else {
                mainArray[i] = arrayB[positionB];
                positionB++;
            }
        }
    }
}
