package ru.svistunovaleksei.homework2.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MainTest {
    Random random = new Random();

    @Test
    void shouldNullArrayThrow() {
        int[] array = null;
        assertThrows(IllegalArgumentException.class, () -> Main.searchPairNumbersThatGivesRequiredNumber(array, random.nextInt()));
    }

    @Test
    void shouldNotEnoughElementsArrayThrow() {
        int[] array = {1};
        int[] array2 = {};
        assertThrows(IllegalArgumentException.class, () -> Main.searchPairNumbersThatGivesRequiredNumber(array, random.nextInt()));
        assertThrows(IllegalArgumentException.class, () -> Main.searchPairNumbersThatGivesRequiredNumber(array2, random.nextInt()));
    }

    @ParameterizedTest
    @MethodSource("arrayValuesAndRequiredNumberAndExpectedResponse")
    void shouldCorrectResultArray(int[] arrayNumbers, int requiredNumber, int[] requiredArrayAnswer) {
        int[] resultArray = Main.searchPairNumbersThatGivesRequiredNumber(arrayNumbers, requiredNumber);
        assertArrayEquals(requiredArrayAnswer, resultArray);
    }

    static Stream<Arguments> arrayValuesAndRequiredNumberAndExpectedResponse() {
        return Stream.of(
                arguments(new int[]{3, 4, 2, 7}, 10, new int[]{3, 7}),
                arguments(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 0}, 0, new int[]{0, 0}),
                arguments(new int[]{-20, 1, 3, 4, -10, 10}, -10, new int[]{-20, 10}),
                arguments(new int[]{-20, 1, 3, 4, -10, 10}, -30, new int[]{-20, -10}),
                arguments(new int[]{1, 789, 2, 1545, 483, -123}, -121, new int[]{2, -123}),
                arguments(new int[]{1, 2, 3, 4, 5}, 159, new int[]{})
        );
    }
}

