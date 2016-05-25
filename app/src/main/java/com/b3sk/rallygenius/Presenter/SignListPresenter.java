package com.b3sk.rallygenius.Presenter;

import android.support.annotation.NonNull;

/**
 * Created by Joopkins on 5/25/16.
 */
public interface SignListPresenter {
    void loadSigns();
    void openSignInfo(@NonNull Sign sign);
    void addSignToSession(@NonNull Sign sign);
}
