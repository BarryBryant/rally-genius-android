package com.b3sk.rallygenius.View;

import com.b3sk.rallygenius.Model.Sign;

import java.util.List;

/**
 * Created by Joopkins on 5/25/16.
 */
public interface SignListView {
    void ShowSigns(List<Sign> signs);
    void ShowSignDetail(Sign sign);
    void ShowSignSession();
}
