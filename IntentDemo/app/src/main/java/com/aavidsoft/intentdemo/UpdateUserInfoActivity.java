package com.aavidsoft.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateUserInfoActivity extends AppCompatActivity {

    private EditText edtUsername, edtCountry, edtPoints;
    private Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initListeners();
    }

    private void initListeners() {
        btnSave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("username", edtUsername.getText().toString());
                        resultIntent.putExtra("country", edtCountry.getText().toString());
                        resultIntent.putExtra("points", Integer.parseInt( edtPoints.getText().toString()));

                        setResult(1, resultIntent);
                        finish();
                    }
                }
        );
    }

    private void initViews() {
        setContentView(R.layout.update_user_info_activity);
        edtUsername = findViewById(R.id.edtUsername);
        edtCountry = findViewById(R.id.edtCountry);
        edtPoints = findViewById(R.id.edtPoints);
        btnSave = findViewById(R.id.btnSave);
    }
}
