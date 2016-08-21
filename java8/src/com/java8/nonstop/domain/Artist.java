package com.java8.nonstop.domain;

/**
 * Created by rco on 8/16/2016.
 */
public class Artist {

    private String name;

    private String country;

    private String field;

    public Artist(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Artist(String name, String country,String field) {
        this.name = name;
        this.country = country;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
