package com.example.cory4.pockettravelguide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);
        //limba
        android.support.v7.app.ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        Button en = findViewById(R.id.button7);
        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("en-us");
                recreate();
            }
        });

        Button ro = findViewById(R.id.button6);
        ro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("ro");
                recreate();
            }
        });

    }
    public void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }
    public void loadLocale(){
        SharedPreferences prefs=getSharedPreferences("Settings",Activity.MODE_PRIVATE);
        String language=prefs.getString("My_Lang","");
        setLocale(language);
    }
    public boolean googleServicesAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable=api.isGooglePlayServicesAvailable(this);
        if(isAvailable==ConnectionResult.SUCCESS){
            return true;
        } else if (api.isUserResolvableError(isAvailable)){
            Dialog dialog=api.getErrorDialog(this,isAvailable,0);
            dialog.show();
        } else{
            Toast.makeText(this,"Can't connect to play services",Toast.LENGTH_LONG).show();
        }
        return false;
    }
    public void mapOnClick(View v) {
        if(googleServicesAvailable()){
            Intent intent = new Intent(v.getContext(), MapActivity.class);
            startActivityForResult(intent, 0);
        }
    }
    public void despreOnClick(View v) {
        if(googleServicesAvailable()){
            Intent intent = new Intent(v.getContext(), AboutActivity.class);
            startActivityForResult(intent, 0);
        }
    }
}
