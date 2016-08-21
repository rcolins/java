package com.java8.nonstop.lamda.stream;

import com.java8.nonstop.domain.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample {

    public static void main(String[] args) {


        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Phil collins", "England"));
        artists.add(new Artist("Britney Spears", "England"));
        artists.add(new Artist("Rahman", "India"));
        artists.add(new Artist("Micheal jackson", "America"));

        //Using Function functional interface
        List<Artist> artistsMappedList = artists.stream().map(artist -> {
            artist.setField("Music");
            return artist;
        }).collect(Collectors.toList());

        artistsMappedList.forEach(artist -> System.out.println(artist.getField()));
    }
}
