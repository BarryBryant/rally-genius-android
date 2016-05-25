package com.b3sk.rallygenius.Model;

/**
 * Created by Joopkins on 5/25/16.
 */
public class Sign {

    private int id;
    private String name;
    private String description;

    public Sign(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
