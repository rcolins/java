package com.java8.nonstop.domain;


public class Track {

    private String trackName;

    private double duration;

    public Track(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackName() {
        return trackName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
