package ru.svistunovaleksei.homework1.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MainTest {

    @Test
    void shouldNullArrayThrow() {
        int[][] array = null;
        assertThrows(IllegalArgumentException.class, () -> Main.getMinMaxAverageArrayValues(array));
    }

    @Test
    void shouldEmptyArrayThrow() {
        int[][] array = new int[(int) (Math.random() * 100 + 1)][];
        assertThrows(IllegalArgumentException.class, () -> Main.getMinMaxAverageArrayValues(array));
    }

    @ParameterizedTest
    @MethodSource("arraysValuesAndCorrectMinMaxAverageArrayValuesStream")
    void shouldGetCorrectMinMaxAverageArrayValues(int[][] array, int min, int max, double average) {
        Main.MinMaxAverageDto minMaxAverageDto = Main.getMinMaxAverageArrayValues(array);

        assertEquals(min, minMaxAverageDto.min());
        assertEquals(max, minMaxAverageDto.max());
        assertEquals(average, minMaxAverageDto.average(), 0.0005);
    }

    static Stream<Arguments> arraysValuesAndCorrectMinMaxAverageArrayValuesStream() {
        return Stream.of(
                arguments(new int[][]{{1}}, 1, 1, 1.0),
                arguments(new int[][]{{-2, 10, 14, 6}}, -2, 14, 7.0),
                arguments(new int[][]{{1, 3, -20}, {}, {89, 13, 18, -20, -4, 10}, {15, 13, 14}}, -20, 89, 11.0),
                arguments(new int[][]{{}, null, {5, 7}, {13, 11, -15}, {0}}, -15, 13, 3.5),
                arguments(new int[][]{{}, null, {15, 13, 14}, {0}, null, {1, 2, 3, 4}}, 0, 15, 6.5),
                arguments(new int[][]{{}, {1, 1}, null, {1}, {}, null, {1, 1, 1, 1}, null, {}}, 1, 1, 1.0),
                arguments(new int[][]{null, null, null, null, {1}}, 1, 1, 1.0),
                arguments(new int[][]{{}, {}, {}, {}, {1}}, 1, 1, 1.0)
        );
    }
}