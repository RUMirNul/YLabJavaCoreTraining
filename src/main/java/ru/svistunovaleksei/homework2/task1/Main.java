package ru.svistunovaleksei.homework2.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        printDuplicateFilteredGroupedByNameSortedByNameAndIdPersonData(RAW_DATA);
    }

    public static void printDuplicateFilteredGroupedByNameSortedByNameAndIdPersonData(Person[] data) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : data) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        Arrays.stream(data)
                .distinct()
                .sorted(Comparator.comparing(Person::getId).thenComparing(Person::getName))
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()))
                .forEach((k,v) -> System.out.printf("Key: %s\nValue:%d\n", k, v));
    }
}
