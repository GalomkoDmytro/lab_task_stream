package task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        App app = new App();
//        app.task1();
//        app.task2();
    }

    /**
     * Task 1:
     * The method takes a list of names. Returns a string
     * of the form "1. Ivan, 3. Peter ...", only with names on
     * odd indices, respectively.
     */
    private void task1() {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Peter");
        names.add("Rodric");
        names.add("Archebalt");
        names.add("Joau");
        names.add("Tom");

        String res = IntStream.range(0, names.size())
                .filter(x -> (x + 1) % 2 == 1)
                .mapToObj(x -> x + "." + names.get(x))
                .collect(Collectors.toList())
                .toString();

        System.out.println(res);
    }

    /**
     * Task 2:
     * The method map list of string to uppercase and then sort descending
     */
    private void task2() {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Peter");
        names.add("Rodric");
        names.add("Archebalt");
        names.add("Joau");
        names.add("Tom");

        names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }


}
