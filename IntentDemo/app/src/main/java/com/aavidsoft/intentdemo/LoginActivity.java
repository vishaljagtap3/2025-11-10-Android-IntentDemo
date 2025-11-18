package com.aavidsoft.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText edtMobileNumber;
    private EditText edtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initViews();
        initListeners();
    }

    private void initListeners() {
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Validate the credentials
                        if(edtMobileNumber.getText().toString().equals("9999999999") && edtPassword.getText().toString().equals("bitcode")) {
                            //start HomeActivity
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            intent.putExtra("username", "Vishal");
                            intent.putExtra("country", "India");
                            intent.putExtra("points", 899);

                            startActivity(intent);
                            finish();
                        }
                        else {
                            //Prompt invalid credentials
                            Toast.makeText(
                                    LoginActivity.this,
                                    "Invalid credentials!",
                                    Toast.LENGTH_LONG
                            ).show();
                        }
                    }
                }
        );
    }

    private void initViews() {
        btnLogin = findViewById(R.id.btnLogin);
        edtMobileNumber = findViewById(R.id.edtMobileNumber);
        edtPassword = findViewById(R.id.edtPassword);
    }
}
