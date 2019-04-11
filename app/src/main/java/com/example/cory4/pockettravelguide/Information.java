package com.example.cory4.pockettravelguide;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }

    public void backOnClick(View v){
        Intent intent = new Intent(v.getContext(), MapActivity.class);
        startActivityForResult(intent, 0);
    }
    public void soundOnClick(View v){
        /*EditText write;
        ttobj=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
            }
        });
        ttobj.setLanguage(Locale.getDefault());
        ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);*/
    }
}
