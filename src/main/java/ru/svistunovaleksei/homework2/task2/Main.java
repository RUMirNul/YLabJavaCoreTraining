package ru.svistunovaleksei.homework2.task2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7};
        try {
            int[] resultArray = searchPairNumbersThatGivesRequiredNumber(arr, 10);
            System.out.println(Arrays.toString(resultArray));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] searchPairNumbersThatGivesRequiredNumber(int[] arrayNumbers, int requiredNumber) {
        if (arrayNumbers == null) throw new IllegalArgumentException("Array is null!");
        if (arrayNumbers.length < 2) throw new IllegalArgumentException("There are not enough elements in the array!");

        Map<Integer, Integer> neededNumberAndHaveNumber = new HashMap<>();

        for (int number : arrayNumbers) {
            Integer neededNumber = requiredNumber - number;

            if (neededNumberAndHaveNumber.containsKey(number)) {
                return new int[]{neededNumber, number};
            }

            neededNumberAndHaveNumber.put(neededNumber, number);
        }

        return new int[]{};
    }
}
