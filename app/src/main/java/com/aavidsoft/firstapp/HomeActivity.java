package com.aavidsoft.firstapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txt = new TextView(this);
        txt.setText("Hello World!");
        txt.setTextSize(40);
        txt.setTextColor(Color.RED);
        setContentView(txt);
    }
}
