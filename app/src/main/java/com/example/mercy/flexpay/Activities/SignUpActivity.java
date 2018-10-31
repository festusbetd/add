package com.example.mercy.flexpay.Activities;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mercy.flexpay.Api.APIService;
import com.example.mercy.flexpay.Api.APIUrl;
import com.example.mercy.flexpay.Model.Result;
import com.example.mercy.flexpay.Model.User;
import com.example.mercy.flexpay.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail, editTextPhone,editTextUsername, editTextFirst,editTextLast,editTextPassword,editTextConfirm_password;
    private TextView textViewSignUp;
    private Button buttonSignup;
    private CheckBox terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextFirst = (EditText) findViewById(R.id.editTextFirst);
        editTextLast = (EditText) findViewById(R.id.editTextLast);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirm_password = (EditText) findViewById(R.id.editTextConfirm_password);

        buttonSignup = (Button) findViewById(R.id.buttonSignup);
      // Font path
        String fontPath = "font/JosefinSans-Light.ttf";
        String sansPath = "font/OpenSans-Regular.ttf";
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface sf = Typeface.createFromAsset(getAssets(), sansPath);
        // Applying font
        editTextPhone.setTypeface(tf);
        editTextEmail.setTypeface(tf);
        editTextUsername.setTypeface(tf);
        editTextFirst.setTypeface(tf);
        editTextLast.setTypeface(tf);
        editTextEmail.setTypeface(tf);
        editTextPassword.setTypeface(tf);
        editTextConfirm_password.setTypeface(tf);
        terms = findViewById(R.id.termsCheck);
        buttonSignup.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == buttonSignup) {
            userSignUp();
        }
    }
    private void userSignUp() {

        //defining a progress dialog to show while signing up
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        String email = editTextEmail.getText().toString().trim();
        String  phone_number_1 = editTextPhone.getText().toString().trim();
        String  username = editTextUsername.getText().toString().trim();
        String first_name = editTextFirst.getText().toString().trim();
        String last_name = editTextLast.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirm_password = editTextConfirm_password.getText().toString().trim();

        if (phone_number_1.matches("")) {
            editTextPhone.setError("Phone Number");
            progressDialog.dismiss();
            return;
        }
        if(phone_number_1.length()<10){
            editTextPhone.setError("Incorrect Phone Number");
            progressDialog.dismiss();
            return;
        }
        if (email.matches("")) {
            editTextEmail.setError("Enter Email");
            progressDialog.dismiss();
            return;
        }
        if (username.matches("")) {
            editTextUsername.setError("Enter Username");
            progressDialog.dismiss();
            return;
        }
        if (!isValidEmail(email)) {
            editTextEmail.setError("Invalid Email");
            return;
        }
        if (first_name.matches("")) {
            editTextFirst.setError("Enter First Name");
            progressDialog.dismiss();
            return;
        }
        if (last_name.matches("")) {
            editTextLast.setError("Enter Last Name");
            progressDialog.dismiss();
            return;
        }
        if (password.matches("")) {
            editTextPassword.setError("Enter Pin");
            progressDialog.dismiss();
            return;
        }

        if(phone_number_1.length()<10){
            editTextPhone.setError("Incorrect Phone Number");
            progressDialog.dismiss();
            return;
        }
        if(terms.isChecked()){
            //building retrofit object
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIUrl.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            //Defining retrofit api service
            APIService service = retrofit.create(APIService.class);
            //Defining the user object as we need to pass it with the call
            User user = new User(username, email,confirm_password,password, first_name, last_name,phone_number_1);
            //defining the call
            Call call = service.createUser(
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getConfirm_password(),
                    user.getFirst_name(),
                    user.getLast_name(),
                    user.getPhone_number_1()
            );
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    //hiding progress dialog

                    /*if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "server returned so many repositories: " + response.body(), Toast.LENGTH_SHORT).show();
                        // todo display the data instead of just a toast
                    } else {
                        // error case
                        switch (response.code()) {
                            case 404:
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "not found", Toast.LENGTH_SHORT).show();
                                break;
                            case 500:
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "server broken", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "unknown error", Toast.LENGTH_SHORT).show();
                                break;
                        }*/


                        //displaying the message from the response as toast
                        Log.e("response",response.message()+response.errorBody());

                  if(response.isSuccessful()) {

                        Log.e("response:",response.body().toString());
                    }
                        //Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                        //onSignupSuccess();


                      //  Log.d("onResponse", "" + response.errorBody());

                  /*  Log.i("Response", response.body());
                    //Toast.makeText()
                    if (response.isSuccessful()){
                        if (response.body() != null){
                            Log.i("onSuccess", response.body());
                        }else{
                            Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                        }
                    }*/
                    }


                /*  TextView mResponseTv = (TextView) findViewById(R.id.mResponseTv);

                  public void showResponse(String response) {
                      if(mResponseTv.getVisibility() == View.GONE) {
                          mResponseTv.setVisibility(View.VISIBLE);
                      }
                      mResponseTv.setText(response);
                  }
  */
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    progressDialog.dismiss();
                   // Log.d("onFailure", t.toString());
                   // Log.e("onFailure", t.getMessage());

                   //Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Returned empty response", Toast.LENGTH_SHORT).show();

                }
            });
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error");
            builder.setMessage("Click to Accept");
            builder.setNegativeButton("OK", null);
            AlertDialog dialog = builder.create();
            progressDialog.dismiss();
            dialog.show();
        }
    }
    private void saveData() {

    }
    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
