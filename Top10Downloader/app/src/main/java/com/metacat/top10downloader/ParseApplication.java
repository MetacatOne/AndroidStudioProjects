package com.metacat.top10downloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by gbarzu on 05.05.2017.
 */

public class ParseApplication {
    private String xmlData;
    private ArrayList<Application> applications;

    public ParseApplication(String data) {
        this.xmlData = data;
        applications = new ArrayList<Application>();
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public boolean process() {
        boolean opStatus = true;
        Application currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
//                        Log.d("ParseApplication", "Start tag for " + tagName);
                        if (tagName.equalsIgnoreCase("entry")) {
                            inEntry = true;
                            currentRecord = new Application();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
//                        Log.d("ParseApplication", "Ending tag for " + tagName);
                        if (inEntry){
                            if (tagName.equalsIgnoreCase("entry")) {
                                applications.add(currentRecord);
                                inEntry = false;
                            } else if (tagName.equalsIgnoreCase("name")) {
                                currentRecord.setName(textValue);
                            } else if (tagName.equalsIgnoreCase("artist")) {
                                currentRecord.setArtist(textValue);
                            } else if (tagName.equalsIgnoreCase("releaseDate")) {
                                currentRecord.setReleaseDate(textValue);
                            }


                        }
                        break;
                    default:
                        // Nothing else to do
                }
                eventType = xpp.next();
            }



        } catch (Exception e) {
            opStatus = false;
            e.printStackTrace();
        }

        for (Application app : applications) {
            Log.d("ParseApplication", "**************");
            Log.d("ParseApplication", "Name: " + app.getName());
            Log.d("ParseApplication", "Artist: " + app.getArtist());
            Log.d("ParseApplication", "Release Date: " + app.getReleaseDate());
        }
        return true;
    }
}
