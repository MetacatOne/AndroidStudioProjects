package com.metacat.top10downloader;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by gbarzu on 05.05.2017.
 */

public class Application {

    private String name;
    private String artist;
    private String releaseDate;
    private String outputDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {

        String formatLast = releaseDate.substring(0, releaseDate.lastIndexOf("-"));

        DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        DateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            Date date = inputDateFormat.parse(formatLast);
            outputDate = outputDateFormat.format(date);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        this.releaseDate = outputDate;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
               "Artist: " + getArtist() + "\n" +
                "Release Date: " + getReleaseDate();
    }
}
