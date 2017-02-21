package com.example.uriel.jsonparser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by uriel on 2/21/2017.
 */

public class ParseJSONObject extends AppCompatActivity {
    private static final String TAG="ParseJSONObject";
    private final String EXTRA_JSON_OBJECT_INDEX = "com.androidtutorialpoint.jsonparser";

    private Mobile mMobile;
    private TextView nameTextView;
    private TextView companyNameTextView;
    private TextView operatingSystemTextView;
    private TextView processorTextView;
    private TextView ramTextView;
    private TextView romTextView;
    private TextView frontCameraTextView;
    private TextView backCameraTextView;
    private TextView screenSizeTextView;
    private TextView batteryTextView;
    private ImageView photoImageView;
    private String photoUrl;

    String url = "https://androidtutorialpoint.com/api/MobileJSONObject.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsejsonobcet);
        //inicializar todos los elementos de la clase
    }
}
