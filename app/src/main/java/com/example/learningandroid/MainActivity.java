package com.example.learningandroid;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learningandroid.api_service.RetrofitApi;
import com.example.learningandroid.home.HomeActivity;
import com.example.learningandroid.models.DataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText emailField;
    EditText passwordField;
    Button login;
    Button signUp;

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    public void setViews() {
        emailField = findViewById(R.id.email_address);
        passwordField = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signUp = findViewById(R.id.sign_up);
        textView1 = findViewById(R.id.text1);
        textView1.setOnClickListener(v -> {
           showAlert(MainActivity.this);
        });
        login.setOnClickListener(v -> {
            emailField.getText();
            passwordField.getText();
            if(emailField.getText().length()<3) {
                Toast toast = Toast.makeText(getBaseContext(),  "Please Enter Valid Email/Username", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            if((passwordField.getText().length() < 8)) {
                Toast toast = Toast.makeText(getBaseContext(),  "Password must contains at least 8 characters", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            postData(emailField.getText().toString(), passwordField.getText().toString());
            Toast successMessage = Toast.makeText(getBaseContext(), "Login Successfully", Toast.LENGTH_LONG);
            successMessage.show();
//            Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
//            MainActivity.this.startActivity(homeIntent);
//            MainActivity.this.finish();
        });

        signUp.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, SignUpScreen.class);//Optional parameters
            MainActivity.this.startActivity(myIntent);
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
    private void postData(String name, String job) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitAPI = retrofit.create(RetrofitApi.class);
        DataModel modal = new DataModel(name, job);

        Call<DataModel> call = retrofitAPI.createPost(modal);

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(@NonNull Call<DataModel> call, @NonNull Response<DataModel> response) {
                Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();

                DataModel responseFromAPI = response.body();
                assert responseFromAPI != null;
                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "lastName : " + responseFromAPI.getJob();
            }
            @Override
            public void onFailure(@NonNull Call<DataModel> call, @NonNull Throwable t) {

            }
        });
    }
}