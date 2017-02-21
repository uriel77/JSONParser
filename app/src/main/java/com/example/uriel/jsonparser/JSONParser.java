package com.example.uriel.jsonparser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by uriel on 2/21/2017.
 */

public class JSONParser {

    public static ArrayList<Mobile> mMobiles = new ArrayList<>();
    public static Mobile parseFeed(JSONObject obj){
        try{
            Mobile mobile = new Mobile();
            mobile.setmName(obj.getString("name"));
            mobile.setmCompanyName(obj.getString("companyName"));
            mobile.setmOperatingSystem(obj.getString("operatingSystem"));
            mobile.setmProcessor(obj.getString("processor"));
            mobile.setmBackCamera(obj.getString("backCamera"));
            mobile.setmFrontCamera(obj.getString("frontCamera"));
            mobile.setmRam(obj.getString("ram"));
            mobile.setmRom(obj.getString("rom"));
            mobile.setmScreenSize(obj.getString("screenSize"));
            mobile.setmUrl(obj.getString("url"));
            mobile.setmBattery(obj.getString("battery"));
            return mobile;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<Mobile> parseArrayFeed(JSONArray arr) {
        JSONObject obj = null;
        Mobile mobile=null;
        mMobiles.clear();

        try {
            for (int i = 0; i < arr.length(); i++) {
                obj = arr.getJSONObject(i);
                mobile = new Mobile();
                mobile.setmName(obj.getString("name"));
                mobile.setmCompanyName(obj.getString("companyName"));
                mobile.setmOperatingSystem(obj.getString("opertingSystem"));
                mobile.setmProcessor(obj.getString("processor"));
                mobile.setmBackCamera(obj.getString("backCamera"));
                mobile.setmFrontCamera(obj.getString("frontCamera"));
                mobile.setmRam(obj.getString("ram"));
                mobile.setmRom(obj.getString("rom"));
                mobile.setmScreenSize(obj.getString("screenSize"));
                mobile.setmUrl(obj.getString("url"));
                mobile.setmBattery(obj.getString("battery"));
                mMobiles.add(mobile);
            }
            return mMobiles;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
