package com.b3sk.rallygenius.View;

import android.support.annotation.NonNull;

import com.b3sk.rallygenius.Model.Sign;

import java.util.List;

/**
 * Created by Joopkins on 5/25/16.
 */
public interface SignListView {
    void ShowSigns(@NonNull List<Sign> signs);
    void ShowSignDetail(@NonNull Sign sign);
}
