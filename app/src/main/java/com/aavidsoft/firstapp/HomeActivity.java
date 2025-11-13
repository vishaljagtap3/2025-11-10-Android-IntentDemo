package com.aavidsoft.firstapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class HomeActivity extends Activity {

    TextView txt;
    EditText edt;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        txt = new TextView(this);
        txt.setText("Hello World!");
        txt.setTextSize(40);
        txt.setTextColor(Color.RED);
        container.addView(txt);
        txt.setBackgroundColor(Color.GRAY);
        /*txt.setLayoutParams(
                new LinearLayout.LayoutParams(
                        600,150
                )
        );*/
        txt.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );
        //setContentView(txt);

        edt = new EditText(this);
        edt.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );
        container.addView(edt);
        //setContentView(edt);

        btn = new Button(this);
        btn.setText("Set Data");
        /*btn.setOnTouchListener(new BtnTouchListener());
        btn.setOnKeyListener(new BtnKeyListener());*/
        btn.setOnClickListener(new BtnClickListener());

        btn.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );
        container.addView(btn);

        setContentView(container);
    }

    class BtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            txt.setText(edt.getText().toString());
        }
    }

    /*class BtnTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            txt.setText(edt.getText());
            return false;
        }
    }

    class BtnKeyListener implements View.OnKeyListener {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            txt.setText(edt.getText());
            return false;
        }
    }*/
}
