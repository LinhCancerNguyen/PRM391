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
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class SignInActivity extends AppCompatActivity {

    private TextView txtSignUpSignIn;
    private EditText edEmailSignIn;
    private EditText edPassSignIn;
    private Button btnShowHideSignIn;
    private Button btnSignInSignIn;
    private TextView txtForgot;
    private boolean isChecked;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtSignUpSignIn = findViewById(R.id.txtSignUpSignIn);
        edEmailSignIn = findViewById(R.id.edEmailSignIn);
        edPassSignIn = findViewById(R.id.edPassSignIn);
        btnShowHideSignIn = findViewById(R.id.btnShowHideSignIn);
        btnSignInSignIn = findViewById(R.id.btnSignInSignIn);
        txtForgot = findViewById(R.id.txtForgot);

        btnShowHideSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int start,end;
                isChecked = !isChecked;
                if(!isChecked){
                    btnShowHideSignIn.setText("Hide");
                    start=edPassSignIn.getSelectionStart();
                    end=edPassSignIn.getSelectionEnd();
                    edPassSignIn.setTransformationMethod(new PasswordTransformationMethod());;
                    edPassSignIn.setSelection(start,end);
                }else{
                    btnShowHideSignIn.setText("Show");
                    start=edPassSignIn.getSelectionStart();
                    end=edPassSignIn.getSelectionEnd();
                    edPassSignIn.setTransformationMethod(null);
                    edPassSignIn.setSelection(start,end);
                }
            }
        });

        txtSignUpSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActitity.class);
                startActivity(intent);
            }
        });

        btnSignInSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = FirebaseFirestore.getInstance();
                Task<QuerySnapshot> task = db.collection("account").get();
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        edEmailSignIn.setText("ID = " + document.getId() +"\nData = " + document.getData());
                    }
                } else {
                    edEmailSignIn.setText("nnn");
                }
//                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
//                startActivity(intent);
            }
        });

        txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}