package com.insightfullogic.java8.examples.chapter2;

import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.text.DateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class LambdaExercises {

    @Test
    public void _1a() {
        assertTrue("Shown in the next chapter", true);
    }

    @Test
    public void _1b() {
        // If you were to model each operation on a calculator as a function.
        Function<Double, Double> negate = (x) -> -1 * x;
        Function<Double, Double> square = (x) -> x * x;
        Function<Double, Double> percent = (x) -> 100 * x;
    }

    @Test
    public void _1c() {
        Function<Integer, Integer> one = x -> x + 1;
        // 2 isn't
        Function<Integer, Boolean> three = x -> x == 1;
    }

    @Test
    public void _2a() {
        assertTrue("ThreadLocal.withInitial", true);
    }

    @Test
    public void _2b() {
        ThreadLocal<DateFormat> threadSafeFormatter = ThreadLocal.withInitial(() -> DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK));
        DateFormat formatter = threadSafeFormatter.get();
        assertEquals("01-Jan-1970", formatter.format(new Date(0)));
    }

    @Test
    public void _3a() {
        // yes
        Runnable helloWorld = () -> System.out.println("hello world");
    }

    @Test
    public void _3b() {
        // Yes
        JButton button = new JButton();
        button.addActionListener(event -> System.out.println(event.getActionCommand()));
    }

    @Test
    public void _3c() {
        // No
        // check(x -> x > 5);
    }

    private boolean check(Predicate<Integer> predicate) {
        System.out.println("wat?");
        return true;
    }

    interface IntPred {
        boolean test(Integer value);
    }

    private boolean check(IntPred predicate) {
        return true;
    }

    @Test
    public void _3d() {
        // No
        // check(x -> x > 5);
        List<Integer> list1 = new ArrayList<>();
        final Stream<List<Integer>> list11 = Stream.of(list1);
        final List<Integer> list = Stream.of(1, 2, 3).collect(Collectors.toList());


    }

    @Test
    public void _3e() {
        double a = 1000.0 / 3;
        System.out.printf("%,.2f", a);
        System.out.println();
        String name = "liuwenke";
        int age = 38;
        String message = String.format("Hello,%s. Next year,you'll be %d", name, age);
        System.out.println(message);
        Date now = new Date();
        System.out.printf("%tc", now);
        System.out.println();
        System.out.printf("%tr", now);
    }

    @Test
    public void _3f() {
        final Map<String, String> env = System.getenv();
        final Properties properties = System.getProperties();
        String path = new StringBuilder()
                .append(System.getenv("HOME"))
                .append(File.separator)
                .append("app")
                .append(File.separator)
                .append("jdk8")
                .append(File.separator)
                .append("abc.txt")
                .toString();
        //new Scanner(Path.of())
        System.out.println();
    }


}
