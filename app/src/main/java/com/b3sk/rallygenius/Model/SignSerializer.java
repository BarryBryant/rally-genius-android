package com.b3sk.rallygenius.Model;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by barrybryant on 4/6/17.
 */

public class SignSerializer {

    private Context context;

    public SignSerializer(Context context) {
        this.context = context;
    }

    public List<Sign> generateSignsFromJSON() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray foodArray = obj.getJSONArray("signs");
            ArrayList<Sign> signs = new ArrayList<>();
            for (int i = 0; i < foodArray.length(); i++) {
                JSONObject jsonSigns = foodArray.getJSONObject(i);
                String description = jsonSigns.getString("description");
                int number = jsonSigns.getInt("number");
                signs.add(new Sign(number, description));
            }
            return signs;
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList<Sign>();
        }
    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("rally-genius.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
