package task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        App app = new App();
//        app.task1();
//        app.task2();
//        app.task3();
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
                .mapToObj(x -> (x + 1)+ "." + names.get(x))
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

    /**
     * Task 3:
     * Given  and collection = Arrays.asList ("1, 2, 0", "4, 5")
     * From the collection get all the numbers listed, separated by
     * commas from all the elements
     */
    private void task3() {
        Collection<String> collection = Arrays.asList("1, 2, 0", "4, 5");

        collection.stream().flatMap((x) -> Arrays.asList(x.split(",")).stream())
                .map(String::trim)
                .map(Integer::parseInt)
                .forEach(System.out::println);
    }

    


}
