package ru.svistunovaleksei.homework1.task2;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MainTest {

    private final Random random = new Random();

    @RepeatedTest(10)
    void shouldCorrectlySortedArray() {
        int[] array = new int[(int)(Math.random() * 500)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        System.out.println(Arrays.toString(array));

        int[] copiedArray = new int[array.length];
        System.arraycopy(array,0,copiedArray,0,array.length);

        Main.sortArray(array);
        Arrays.sort(copiedArray);

        System.out.println(Arrays.toString(array));

        assertArrayEquals(array, copiedArray);
    }
}