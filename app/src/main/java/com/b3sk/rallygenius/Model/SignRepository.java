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
        Sign signOne = new Sign(0, "description");
        Sign signTwo = new Sign(1, "description");
        Sign signThree = new Sign(2, "description");
        Sign signa = new Sign(3, "description");
        Sign signb = new Sign(4, "description");
        Sign signc = new Sign(5, "description");
        Sign signd = new Sign(6, "description");
        Sign signe = new Sign(7, "description");
        Sign signf = new Sign(8, "description");
        Sign signg = new Sign(9, "description");
        Sign signh = new Sign(10, "description");
        Sign signi = new Sign(11, "description");
        Sign signj = new Sign(12, "description");
        Sign signk = new Sign(13, "description");
        Sign signl = new Sign(14, "description");
        Sign signm = new Sign(15, "description");
        Sign signn = new Sign(16, "description");
        Sign signo = new Sign(17, "description");
        Sign signp = new Sign(18, "description");
        Sign signq = new Sign(19, "description");
        Sign signr = new Sign(20, "description");
        Sign signt = new Sign(21, "description");
        signs.add(signa);
        signs.add(signb);
        signs.add(signc);
        signs.add(signd);
        signs.add(signe);
        signs.add(signf);
        signs.add(signg);
        signs.add(signh);
        signs.add(signi);
        signs.add(signj);
        signs.add(signk);
        signs.add(signl);
        signs.add(signm);
        signs.add(signn);
        signs.add(signo);
        signs.add(signp);
        signs.add(signq);
        signs.add(signr);
        signs.add(signt);
        signs.add(signOne);
        signs.add(signThree);
        signs.add(signTwo);
        return signs;
    }

    public void addSignToSession(Sign sign) {
        Log.d(LOG_TAG, "Adding sign to session: " + sign.getId());
    }
}
