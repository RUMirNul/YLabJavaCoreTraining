package ru.svistunovaleksei.homework1.task1;

import java.util.Random;

public class Main {
    private static final int ARRAY_SIZE = 7;

    public static void main(String[] args) {
        int[][] array = new int[ARRAY_SIZE][];
        generateRandomArrayValues(array);
        printArray(array);

        try {
            MinMaxAverageDto minMaxAverageDto = getMinMaxAverageArrayValues(array);
            System.out.printf("MIN = %d\nMAX = %d\nAVERAGE = %.5f\n", minMaxAverageDto.min, minMaxAverageDto.max, minMaxAverageDto.average);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //Принял решение объединить все в один метод тк это будет быстрее, чем находить всё по отдельности
    public static MinMaxAverageDto getMinMaxAverageArrayValues(int[][] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double average = 0;
        int elementsCount = 0;

        if (array == null) {
            throw new IllegalArgumentException("Array is null!");
        }
        //Испольую такой поиск количества элементов на случай, если array будет ступенчатым(зубчатым) массивом
        for (int[] ints : array) {
            if (ints == null) continue;
            elementsCount += ints.length;
        }

        if (elementsCount <= 0) {
            throw new IllegalArgumentException("Array is empty!");
        }

        for (int[] ints : array) {
            if (ints == null) continue;
            for (int number : ints) {
                average += number / (double) elementsCount;

                if (number > max) {
                    max = number;
                }

                if (number < min) {
                    min = number;
                }
            }
        }

        return new MinMaxAverageDto(min, max, average);
    }

    public static void generateRandomArrayValues(int[][] array) {
        if (array == null) return;
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; array[i] != null && j < array[i].length; j++) {
                array[i][j] = random.nextInt();
            }
        }
    }

    public static void printArray(int[][] array) {
        if (array == null) return;
        for (int[] ints : array) {
            if (ints == null) continue;
            for (int number : ints) {
                System.out.printf("%13d", number);
            }
            System.out.println();

        }
    }

    record MinMaxAverageDto(int min, int max, double average) {
    }
}
