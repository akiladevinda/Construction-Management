package com.example.praba.ipfire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AppMainActivity extends AppCompatActivity {

    private Button mlogin , mReg;

    private FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);

        mlogin = (Button)findViewById(R.id.provider_login_button);
        mReg = (Button)findViewById(R.id.register_button);


        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        }


        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent loginIntent = new Intent(AppMainActivity.this,LoginActivity.class);
                startActivity(loginIntent);

            }
        });

        mReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent regInten = new Intent(AppMainActivity.this,MainActivity.class);
                startActivity(regInten);


            }
        });
    }
}
