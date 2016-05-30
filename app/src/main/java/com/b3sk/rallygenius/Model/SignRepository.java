package com.b3sk.rallygenius.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopkins on 5/25/16.
 */
public class SignRepository {


    private static final String LOG_TAG = SignRepository.class.getSimpleName();

    public List<Sign> getSigns() {
        List<Sign> signs = new ArrayList<>();
        for(int i = 0; i < 67; i++) {
            Sign sign = new Sign(i, "description");
            signs.add(sign);
        }
        return signs;
    }

    public void addSignToSession(Sign sign) {
        Log.d(LOG_TAG, "Adding sign to session: " + sign.getId());
    }
}
