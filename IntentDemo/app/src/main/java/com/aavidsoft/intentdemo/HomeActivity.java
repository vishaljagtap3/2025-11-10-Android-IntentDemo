package com.aavidsoft.intentdemo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.aavidsoft.intentdemo.databinding.HomeActivityBinding;

public class HomeActivity extends AppCompatActivity {
    private TextView txtUsername, txtCountry, txtPoints;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        processInput();
        setupListeners();
        mt("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mt("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mt("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mt("onRestart");
    }

    @Override
    protected void onPause() {
        mt("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        mt("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy");
        super.onDestroy();
    }

    private void setupListeners() {
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =
                                new Intent(
                                        HomeActivity.this,
                                        UpdateUserInfoActivity.class
                                );
                        //startActivity(intent);
                        startActivityForResult(intent, 1);
                    }
                }
        );
    }

    private void processInput() {
        //Extract the data
        Intent intent = getIntent();
        Bundle input = intent.getExtras();
        String username = input.getString("username");
        String country = input.getString("country");
        int points = input.getInt("points");

        txtUsername.setText(username);
        txtCountry.setText(country);
        txtPoints.setText(points + "");
    }

    private void initViews() {
        setContentView(R.layout.home_activity);

        txtUsername = findViewById(R.id.txtUsername);
        txtCountry = findViewById(R.id.txtCountry);
        txtPoints = findViewById(R.id.txtPoints);
        btnUpdate = findViewById(R.id.btnUpdate);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null) {
            Bundle resultBundle = data.getExtras();

            txtUsername.setText(resultBundle.getString("username"));
            txtUsername.setText(data.getStringExtra("username"));
            txtCountry.setText(data.getStringExtra("country"));
            txtPoints.setText("" + data.getIntExtra("points", 0));
        }
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        Log.e("tag", text);
    }
}