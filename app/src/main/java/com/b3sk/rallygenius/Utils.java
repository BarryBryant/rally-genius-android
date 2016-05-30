package com.b3sk.rallygenius;

/**
 * Created by Joopkins on 5/29/16.
 */
public class Utils {
    public static String getSignNumber(int pos) {
        if(pos>64){
            return Integer.toString(pos + 298-65);
        }else if(pos > 53){
            return Integer.toString(pos + (201-54));
        }else if(pos > 35){
            return Integer.toString(pos + (101-36));
        }else return Integer.toString(pos+1);
    }
}
