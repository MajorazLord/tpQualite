package model;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import view.MainActivity;

/**
 * Created by Alexis on 06/02/2018.
 */

public class Converter {

    public static Double convertCelToFar(Double d, Context a){
        Double res = (d*1.8+32);
        List<String> l = new ArrayList<>();
        l.add(d+"");
        Sharedpref.SaveCelToSharedPref(l, a);
        return res;
    }

    public static Double convertFarToCel(Double d, Context a){
        Double res = (d-32)/1.8;
        List<String> l = new ArrayList<>();
        l.add(d+"");
        Sharedpref.SaveFarToSharedPref(l, a);
        return res;
    }
}
