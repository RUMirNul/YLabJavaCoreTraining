package ru.svistunovaleksei.homework2.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static Person[] RAW_DATA = new Person[]{
            null,
            new Person(0, null),
            null,
            new Person(1, null)
    };

    @Test
    void shouldNullArrayThrow() {
        Person[] array = null;
        assertThrows(IllegalArgumentException.class, () -> Main.printDuplicateFilteredGroupedByNameSortedByNameAndIdPersonData(array));
    }

    @Test
    void shouldCorrectWorking() {
        assertDoesNotThrow(() -> Main.printDuplicateFilteredGroupedByNameSortedByNameAndIdPersonData(RAW_DATA));
    }


}