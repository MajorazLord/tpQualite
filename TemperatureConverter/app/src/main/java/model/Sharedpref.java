package model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexis on 06/02/2018.
 */

public class Sharedpref {
    public static SharedPreferences mySharedPref;

    public static void SaveCelToSharedPref(List<String> myListToSave, Context c){
        mySharedPref = c.getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPref.edit();


        Set<String> mySet = new HashSet<String>();
        mySet.addAll(myListToSave);
        editor.putStringSet("Celcius", mySet);
        editor.commit();
        Log.d("COUCOU", "Fin du saveCelciusToSharedPref");
    }

    public static List<String> RetrieveCelciusSharedpref(){
        Set<String> mySet = mySharedPref.getStringSet("Celcius", null);
        List<String> res = new ArrayList<>();
        for (String elem: mySet) {
            res.add(elem);
        }
        Log.d("COUCOU", "Fin du RetrieveCelciusSharedPref");
        return res;
    }

    public static void SaveFarToSharedPref(List<String> myListToSave, Context c){
        mySharedPref = c.getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPref.edit();


        Set<String> mySet = new HashSet<String>();
        mySet.addAll(myListToSave);
        editor.putStringSet("Far", mySet);
        editor.commit();
        Log.d("COUCOU", "Fin du saveFarToSharedPref");
    }

    public static List<String> RetrieveFarSharedpref(){
        Set<String> mySet = mySharedPref.getStringSet("Far", null);
        List<String> res = new ArrayList<>();
        for (String elem: mySet) {
            res.add(elem);
        }
        Log.d("COUCOU", "Fin du RetrieveFarSharedPref");
        return res;
    }



}
