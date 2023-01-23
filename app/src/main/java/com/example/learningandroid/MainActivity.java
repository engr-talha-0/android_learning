package com.example.learningandroid;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailField;
    EditText passwordField;
    EditText userName;
    Button createAccount;

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    public void setViews() {
        emailField = findViewById(R.id.email_address);
        userName = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);
        createAccount = findViewById(R.id.create_account);
        textView1 = findViewById(R.id.text1);
        textView1.setOnClickListener(v -> {
           showAlert(MainActivity.this);
        });
        createAccount.setOnClickListener(v -> {
            emailField.getText();
            userName.getText();
            passwordField.getText();
            if(emailField.getText().length()<3) {
                Toast toast = Toast.makeText(getBaseContext(),  "Please Enter Valid Email", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            if(userName.getText().length()<3) {
                Toast toast = Toast.makeText(getBaseContext(),  "Please Enter User Name", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            if((passwordField.getText().length() < 8)) {
                Toast toast = Toast.makeText(getBaseContext(),  "Password must contains at least 8 characters", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            Toast successMessage = Toast.makeText(getBaseContext(), "Account Created Successfully", Toast.LENGTH_LONG);
            successMessage.show();
        });
    }

    void showAlert(Context context) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Privacy & Policy");
        alert.setMessage("Privacy & Policy here.....");
        alert.setCancelable(true);
        alert.setPositiveButton("Ok", (dialog, which) -> dialog.cancel());
        alert.show();
    }
}