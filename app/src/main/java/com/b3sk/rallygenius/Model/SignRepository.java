package com.b3sk.rallygenius.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopkins on 5/25/16.
 */
public class SignRepository {


    private static final String LOG_TAG = SignRepository.class.getSimpleName();
    private SignSerializer serializer;
    private List<Sign> signs;

    public SignRepository(SignSerializer serializer) {
        this.serializer = serializer;
    }

    public List<Sign> getSigns() {
        if (signs == null) {
            signs = serializer.generateSignsFromJSON();
            return signs;
        } else {
            return signs;
        }
    }

    public void addSignToSession(Sign sign) {
        Log.d(LOG_TAG, "Adding sign to session: " + sign.getId());
    }
}
