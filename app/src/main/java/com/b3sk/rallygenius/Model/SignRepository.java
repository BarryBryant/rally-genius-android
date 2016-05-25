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
        Sign signOne = new Sign(0, "sign_one", "description");
        Sign signTwo = new Sign(1, "sign_two", "description");
        Sign signThree = new Sign(2, "sign_three", "description");
        signs.add(signOne);
        signs.add(signTwo);
        signs.add(signThree);
        return signs;
    }

    public void addSignToSession(Sign sign) {
        Log.d(LOG_TAG, "Adding sign to session: " + sign.getTitle());
    }
}
