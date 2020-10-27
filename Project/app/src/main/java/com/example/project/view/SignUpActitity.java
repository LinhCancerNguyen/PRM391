package com.example.project.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project.R;

public class SignUpActitity extends AppCompatActivity {

    private TextView txtSignInSignUp;
    private EditText edName;
    private EditText edEmail;
    private EditText edPass;
    private Button btnShowHide;
    private EditText edPhone;
    private Button btnNext;
    boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtSignInSignUp = findViewById(R.id.txtSignInSignUp);
        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        edPhone = findViewById(R.id.edPhone);
        btnShowHide = findViewById(R.id.btnShowHide);
        btnNext = findViewById(R.id.btnNext);

        txtSignInSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActitity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        btnShowHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int start,end;
                isChecked = !isChecked;
                if(!isChecked){
                    btnShowHide.setText("Hide");
                    start=edPass.getSelectionStart();
                    end=edPass.getSelectionEnd();
                    edPass.setTransformationMethod(new PasswordTransformationMethod());;
                    edPass.setSelection(start,end);
                }else{
                    btnShowHide.setText("Show");
                    start=edPass.getSelectionStart();
                    end=edPass.getSelectionEnd();
                    edPass.setTransformationMethod(null);
                    edPass.setSelection(start,end);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActitity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}