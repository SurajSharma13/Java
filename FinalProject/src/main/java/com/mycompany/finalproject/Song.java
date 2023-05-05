package com.mycompany.finalproject;

public class Song {
    //ftiaxoume tin ontotita song

    private String songName;
    private String artistName;
    private String releaseDate;
    private String duration;
    private String genre;
    private String songId;
    
    // default constructor
    public Song() {
    }

    public Song(String songId, String songName, String artistName, String releaseDate, String duration, String genre) {
        this.songName = songName;
        this.artistName = artistName;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.genre = genre;
        this.songId = songId;
    }
    //getters kai setters

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String dongId) {
        this.songId = songId;
    }

    @Override
    public String toString() {
        return songId + "\t" + songName + "\t" + artistName + "\t" + releaseDate + "\t" + duration + "\t" + genre;
    }

}
