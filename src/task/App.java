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

        app.task4();
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

    /**
     * Task 4:
     * Using Stream.iterate, make an infinite stream of random numbers — not by calling
     * Math.random but by directly implementing a linear congruential generator. In such
     * a generator, you start with x[0] = seed and then produce x[n + 1] = 1 (a x[n] + c) % m, for
     * appropriate values of a, c, and m. You should implement a method with parameters a, c, m, and
     * seed that yields a Stream<Long>. Try out a = 25214903917, c = 11, and m = 2^48.
     */
    private void task4() {
        linearCongruentialGenerator(25214903917L, 11L, (long)Math.pow(2, 48), 1L)
                .forEach(System.out::println);
    }

    private static Stream<Long> linearCongruentialGenerator(Long a, Long c, Long m, Long seed) {
        return Stream.iterate(seed, e -> (a * e + c) % m);
    }




}
