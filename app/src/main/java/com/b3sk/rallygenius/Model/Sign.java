package com.b3sk.rallygenius.Model;

/**
 * Created by Joopkins on 5/25/16.
 */
public class Sign {

    private int id;
    private String description;

    public Sign(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }
}
