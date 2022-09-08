package ru.svistunovaleksei.homework2.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

class Person {
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

public class Main {

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
            null,
            new Person(9, null)
    };

    public static void main(String[] args) {
        try {
            printDuplicateFilteredGroupedByNameSortedByNameAndIdPersonData(RAW_DATA);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printDuplicateFilteredGroupedByNameSortedByNameAndIdPersonData(Person[] data) {
        if (data == null) throw new IllegalArgumentException("Array is null!");

        System.out.println("Raw data:");
        System.out.println();

        for (Person person : data) {
            if (person == null) continue;
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        Arrays.stream(data)
                .filter(Objects::nonNull)
                .filter(obj -> obj.getName() != null)
                .distinct()
                .sorted(Comparator.comparing(Person::getId).thenComparing(Person::getName))
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()))
                .forEach((k, v) -> System.out.printf("Key: %s\nValue:%d\n", k, v));
    }
}
