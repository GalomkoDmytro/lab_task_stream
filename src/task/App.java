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

//        app.task4();
        app.task5();
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
                .filter(index -> (index + 1) % 2 == 1)
                .mapToObj(element -> (element + 1)+ "." + names.get(element))
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

        collection.stream().flatMap((list) -> Arrays.asList(list.split(",")).stream())
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

    /**
     *Task 5:
     * Write a method public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) that alternates elements
     * from the stream first and second, stopping when one of them runs out of elements.
     */
    private void task5() {
        zip(Stream.of(1, 3, 5, 7), Stream.of(2, 4)).forEach(System.out::println);
    }

    private <T> Stream<T> zip(Stream<T> s1, Stream<T> s2) {

        List<T> first = s1.collect(Collectors.toList());
        List<T> second = s2.collect(Collectors.toList());

        return IntStream.range(0, Math.min(first.size(), second.size()) * 2)
                .mapToObj(x ->x % 2 == 0 ? first.get(x / 2) : second.get(x / 2));
    }

}
