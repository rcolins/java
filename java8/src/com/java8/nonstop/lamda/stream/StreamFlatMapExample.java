package com.java8.nonstop.lamda.stream;

import com.java8.nonstop.domain.Artist;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlatMapExample {

    public static void main(String[] args) {

        Map<String, List<Artist>> countryArtists = new HashMap<>();

        List<Artist> engArtists = new ArrayList<>();
        engArtists.add(new Artist("Phil collins", "England", "rock"));
        engArtists.add(new Artist("Britney Spears", "England", "class"));

        countryArtists.put("England", engArtists);

        List<Artist> indianArtists = new ArrayList<>();
        indianArtists.add(new Artist("Rahman", "India", "rock"));
        indianArtists.add(new Artist("Harish", "India", "jazz"));

        countryArtists.put("India", indianArtists);

        List<Artist> americanArtists = new ArrayList<>();
        americanArtists.add(new Artist("Dre", "America", "soft"));
        americanArtists.add(new Artist("Micheal", "America", "rock"));

        countryArtists.put("America", americanArtists);

        List<Artist> rockArtist = Stream.of(engArtists, indianArtists, americanArtists).flatMap(artists -> artists.stream()).filter(artist -> "rock".equals(artist.getField())).collect(Collectors.toList());

        List<Artist> rockArtist2 = countryArtists.values().stream().flatMap(artists -> artists.stream()).filter(artist -> "rock".equals(artist.getField())).collect(Collectors.toList());

        rockArtist2.forEach(artist -> System.out.println(artist.getName()));

    }
}
