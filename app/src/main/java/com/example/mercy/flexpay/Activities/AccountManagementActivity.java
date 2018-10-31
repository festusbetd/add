package com.example.mercy.flexpay.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mercy.flexpay.R;

public class AccountManagementActivity extends AppCompatActivity {
private Button accountlogin;
private Button accountregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);

        accountlogin = findViewById(R.id.accountlogin);
        accountregister = findViewById(R.id.accountregister);

        accountlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(AccountManagementActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        accountregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(AccountManagementActivity.this,SignUpActivity.class);
                startActivity(registerIntent);
            }
        });
    }
}
