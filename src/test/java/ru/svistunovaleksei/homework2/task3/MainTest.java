package ru.svistunovaleksei.homework2.task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MainTest {

    @Test
    void shouldNullArrayThrow() {
        assertThrows(IllegalArgumentException.class, () -> Main.fuzzySearch(null, "asd"));
        assertThrows(IllegalArgumentException.class, () -> Main.fuzzySearch("abc", null));
        assertThrows(IllegalArgumentException.class, () -> Main.fuzzySearch(null, null));
    }

    @Test
    void shouldStringLengthIsZeroTrow() {
        assertThrows(IllegalArgumentException.class, () -> Main.fuzzySearch("", "asd"));
        assertThrows(IllegalArgumentException.class, () -> Main.fuzzySearch("abc", ""));
        assertThrows(IllegalArgumentException.class, () -> Main.fuzzySearch("", ""));
    }

    @ParameterizedTest
    @MethodSource("substringAndStringAndRequiredBooleanAnswer")
    void shouldCorrectResult(String substring, String string, boolean requiredAnswer) {
        boolean answer = Main.fuzzySearch(substring, string);
        assertEquals(requiredAnswer, answer);
    }

    static Stream<Arguments> substringAndStringAndRequiredBooleanAnswer() {
        return Stream.of(
                arguments("car", "ca6$$#_rtwheel", true),
                arguments("cwhl", "cartwheel", true),
                arguments("cwhee", "cartwheel", true),
                arguments("cartwheel", "cartwheel", true),
                arguments("cwheeel", "cartwheel", false),
                arguments("lw", "cartwheel", false),
                arguments("aaaaaaaaaaa", "bbbbabbbbbbbbbbbbbbbbbbbbbbb", false),
                arguments("abcde", "abc", false),
                arguments("aAb", "Aabcde", true)
        );
    }
}