package com.java8.nonstop.lamda.stream;


import com.java8.nonstop.domain.Track;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReferenceExample {

    public static void main(String[] args) {

        List<String> trackNames = new ArrayList<>();
        trackNames.add("Track1");
        trackNames.add("Track2");
        trackNames.add("Track3");
        trackNames.add("Track4");

        List<Track> tracks = trackNames.stream().map(Track::new).collect(Collectors.toList());


        List<String> numberString = new ArrayList<>();
        numberString.stream().map(Integer::valueOf).collect(Collectors.toList());

    }
}
