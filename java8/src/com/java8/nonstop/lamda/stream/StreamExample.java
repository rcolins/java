package com.java8.nonstop.lamda.stream;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        Stream<String> stringStream = list.stream();

        String[] strings = new String[10];
        Stream<String> arrayStream = Arrays.stream(strings);
        Stream<String> arrayStream2 = Stream.of(strings);

        //The Stream interface has two static methods for making infinite streams.
        Stream<Double> randoms = Stream.generate(() -> Math.random());
        Stream<Double> randoms1 = Stream.generate(Math::random);

        //Sequesnce integers
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

        //integers.limit(10).forEach(System.out::println);


        //sorting unique string
        List<String> uniqueStrings = new ArrayList<>();
        uniqueStrings.add("davind");
        uniqueStrings.add("john");
        uniqueStrings.add("markas");
        uniqueStrings.add("brad");
        uniqueStrings.add("zen");
        uniqueStrings.add("markas");
        uniqueStrings.add("davind");

        uniqueStrings.stream().distinct().sorted(Comparator.comparing(String::length)).forEach(System.out::println);


    }
}
