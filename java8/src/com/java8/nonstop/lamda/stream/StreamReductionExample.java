package com.java8.nonstop.lamda.stream;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamReductionExample {


    private static boolean checkIfStartWith1(final String s){
       return  s.startsWith("1");
    }
    public static void main(String[] args) {

        List<String> intStrings = new ArrayList<>();
        intStrings.add("122");
        intStrings.add("11");
        intStrings.add("13243");
        intStrings.add("2");
        intStrings.add("55");
        intStrings.add("23");
        intStrings.add("90");

        //printing the maximum value
       Optional<Integer> max =  intStrings.stream().map(Integer::valueOf).max(Integer::compare);

        if(max.isPresent()){

            System.out.println(max.get());
        }
        Optional<String> max2 = intStrings.stream().filter( StreamReductionExample::checkIfStartWith1).findFirst();
        System.out.println(max2.get());

    }

}
