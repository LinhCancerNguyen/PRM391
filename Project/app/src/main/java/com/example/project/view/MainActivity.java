package com.example.project.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project.R;
import com.example.project.data.db.SyncData;

public class MainActivity extends AppCompatActivity {

    private Button btnSignUp;
    private Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SyncThread syncThread = new SyncThread();
        syncThread.start();

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActitity.class);
                startActivity(intent);
            }
        });
    }

    class SyncThread extends Thread {
        @Override
        public void run() {
            SyncData syncData = new SyncData(MainActivity.this);
            syncData.Synchronize();
        }
    }
}

