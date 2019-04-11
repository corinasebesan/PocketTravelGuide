package com.example.cory4.pockettravelguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView tv= findViewById(R.id.ab);
        Spanned sp = Html.fromHtml( getString(R.string.sibiu));
        tv.setText(sp);
    }
}
