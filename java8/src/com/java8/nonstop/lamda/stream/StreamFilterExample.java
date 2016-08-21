package com.java8.nonstop.lamda.stream;

import com.java8.nonstop.domain.Artist;

import java.util.*;
import java.util.stream.Collectors;

public class StreamFilterExample {

    public static void main(String[] args) {

        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Phil collins", "England"));
        artists.add(new Artist("Britney Spears", "England"));
        artists.add(new Artist("Rahman", "India"));
        artists.add(new Artist("Micheal jackson", "America"));

        //this is not lazy loading, its eager,Using Predicate functional interface
        artists.stream().filter(artist -> {
            System.out.print(artist.getName());
            return artist.getCountry().equals("England");
        });

        System.out.print(artists.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.getCountry().equals("England");
        }).count());
    }
}
