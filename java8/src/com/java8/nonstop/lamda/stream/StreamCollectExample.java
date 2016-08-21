package com.java8.nonstop.lamda.stream;

import com.java8.nonstop.domain.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create new collection from existing  collection
 */
public class StreamCollectExample {

    public static void main(String[] args) {

        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Phil collins", "England"));
        artists.add(new Artist("Britney Spears", "England"));
        artists.add(new Artist("Rahman", "India"));
        artists.add(new Artist("Micheal jackson", "America"));

        List<Artist> artistsCopiedCollection = artists.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());

        artistsCopiedCollection.forEach( artist -> System.out.println(artist.getName()));

    }
}
