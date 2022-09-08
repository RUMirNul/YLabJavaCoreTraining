package ru.svistunovaleksei.homework2.task3;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
            System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
            System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
            System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
            System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
            System.out.println(fuzzySearch("lw", "cartwheel")); // false

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public static boolean fuzzySearch(String substring, String string) {
        if (substring == null || string == null) throw new IllegalArgumentException("Substring is null!");

        int substringLength = substring.length();
        int stringLength = string.length();

        if (substringLength == 0 || stringLength == 0) {
            throw new IllegalArgumentException("The length of the string is 0. It is not known what answer you expected");
        }

        if (substringLength > stringLength) return false;

        int substringIndex = 0;

        for (int i = 0; i < string.length(); i++) {
            // Если оставшихся символов в строке меньше, чем в подстроке, то сравнение останавливается
            if (substringLength - substringIndex > stringLength - i) return false;

            if (Character.toLowerCase(string.charAt(i)) == Character.toLowerCase(substring.charAt(substringIndex))) {
                substringIndex++;
            }
            if (substringIndex == substringLength) return true;
        }
        return false;
    }
}
