package com.b3sk.rallygenius;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;


/**
 * Created by Joopk on 3/23/2016.
 */
public class MyApplication extends Application {


    private Tracker tracker;

    @Override
    public void onCreate(){
        super.onCreate();
    }

    synchronized public Tracker getDefaultTracker() {
        if (tracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            tracker = analytics.newTracker(R.xml.global_tracker);
        }
        return tracker;
    }

}
