package com.example.uriel.jsonparser;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.lang.reflect.Method;


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
        setContentView(R.layout.activity_parsejsonobject);
        //inicializar todos los elementos de la clase
        nameTextView =(TextView)findViewById(R.id.edit_text_name);
        companyNameTextView =(TextView)findViewById(R.id.edit_text_company_name);
        operatingSystemTextView =(TextView)findViewById(R.id.edit_text_operating_system);
        processorTextView = (TextView)findViewById(R.id.edit_text_processor);
        ramTextView =(TextView)findViewById(R.id.edit_text_ram);
        romTextView =(TextView)findViewById(R.id.edit_text_rom);
        frontCameraTextView=(TextView)findViewById(R.id.edit_text_front_camera);
        backCameraTextView =(TextView)findViewById(R.id.edit_text_back_camera);
        screenSizeTextView =(TextView)findViewById(R.id.edit_text_screen_size);
        batteryTextView = (TextView)findViewById(R.id.edit_text_battery);
        photoImageView = (ImageView)findViewById(R.id.image_view_mobile_picture);

        final ProgressDialog pDialog =new ProgressDialog(ParseJSONObject.this);
        pDialog.setMessage("cargando...");
        pDialog.show();
//revisar el Get
        JsonObjectRequest jsonObjReq= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mMobile = JSONParser.parseFeed(response);

                //segun yo aqui se comienza a trabajar con el json, ya que se concatenan los datos
                nameTextView.setText("Nombre :" + mMobile.getmName());
                companyNameTextView.setText("Nombre de la compañia: " + mMobile.getmCompanyName());
                operatingSystemTextView.setText("SO :" + mMobile.getmOperatingSystem());
                processorTextView.setText("Procesador :" + mMobile.getmProcessor());
                ramTextView.setText("Ram :" + mMobile.getmRam());
                romTextView.setText("ROM : " + mMobile.getmRom());
                frontCameraTextView.setText("Camara frontal : " + mMobile.getmFrontCamera());
                backCameraTextView.setText("Camara trasera : " + mMobile.getmBackCamera());
                screenSizeTextView.setText("Tamaño de la pantalla : " + mMobile.getmScreenSize());
                batteryTextView.setText("Bateria : " + mMobile.getmBattery());
                photoUrl = (mMobile.getmUrl());

                //checar esta parte porque no se que onda
                ImageLoader imageLoader = null;
                //new ImageLoader(Volley.newRequestQueue(getApplicationContext()), new LruBitmapCache());

                imageLoader.get(photoUrl, new ImageLoader.ImageListener() {
                            @Override
                            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {

                                if (response.getBitmap() != null) {
                                    photoImageView.setImageBitmap(response.getBitmap());
                                    pDialog.hide();
                                }
                            }

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e(TAG, "Image Load Error: " + error.getMessage());

                            }
                        }
                );

                Log.d(TAG, response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error :" + error.getMessage());
                pDialog.hide();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(jsonObjReq);
    }
}
