package com.example.mercy.flexpay.Activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mercy.flexpay.Api.APIService;
import com.example.mercy.flexpay.Api.APIUrl;
import com.example.mercy.flexpay.Model.Result;
import com.example.mercy.flexpay.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private TextView textViewText;
    private EditText editTextLoginEmail;
    private EditText editTextLoginPin;
    private Button btnlogin;
    TextView textSign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewText = findViewById(R.id.textViewText2);
        editTextLoginEmail = findViewById(R.id.editTextLoginPhone);
        editTextLoginPin = findViewById(R.id.editTextLoginPin);
        btnlogin = findViewById(R.id.btnlogin);
        textSign = findViewById(R.id.textSign);
        // Font path
        String fontPath = "font/JosefinSans-Light.ttf";
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
        editTextLoginEmail.setTypeface(tf);
        editTextLoginPin.setTypeface(tf);
        textSign.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent signupIntent = new Intent(LoginActivity.this,SignUpActivity.class);
                 startActivity(signupIntent);
             }
         });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userSignIn();
            }
        });
    }

    private void userSignIn() {
        String phone = editTextLoginEmail.getText().toString().trim();
        String pin = editTextLoginPin.getText().toString().trim();
        if (phone.matches("")) {
            editTextLoginEmail.setError("Email");
            return;
        }
        if (pin.matches("")) {
            editTextLoginPin.setError("Enter Pin");
            return;
        }


        else{
            checkUser();
        }
    }
    private void checkUser() {
       /* AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage("Cannot Validate");
        builder.setNegativeButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();*/
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        String email = editTextLoginEmail.getText().toString().trim();
        String password = editTextLoginPin.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);


        Call<Result> call = service.userLogin(email, password);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();

                if (!response.body().getSuccess()) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
