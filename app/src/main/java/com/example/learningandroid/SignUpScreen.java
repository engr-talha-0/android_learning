package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpScreen extends AppCompatActivity {

    EditText email;
    EditText userName;
    EditText password;
    Button create_account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        setViews();
    }
    public void setViews() {
        email = findViewById(R.id.sign_up_email);
        password = findViewById(R.id.sign_up_password);
        userName = findViewById(R.id.sign_up_username);
        create_account = findViewById(R.id.sign_up_create_account);
        create_account.setOnClickListener(v -> {
            if(email.getText().length()<3) {
                Toast toast = Toast.makeText(getBaseContext(),  "Please Enter Valid Email", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            if(userName.getText().length()<3) {
                Toast toast = Toast.makeText(getBaseContext(),  "Please Enter Valid Username", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            if((password.getText().length() < 8)) {
                Toast toast = Toast.makeText(getBaseContext(),  "Password must contains at least 8 characters", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            Toast successMessage = Toast.makeText(getBaseContext(), "Account Created Successfully", Toast.LENGTH_LONG);
            successMessage.show();
        });
    }
}