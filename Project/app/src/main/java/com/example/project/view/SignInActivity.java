package com.example.project.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.data.db.AccountDAO;
import com.example.project.data.db.DBConnection;
import com.example.project.data.db.PetDAO;
import com.example.project.data.db.SyncData;
import com.example.project.data.model.Account;
import com.example.project.data.model.Pet;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class SignInActivity extends AppCompatActivity {

    private TextView txtSignUpSignIn;
    private EditText edEmailSignIn;
    private EditText edPassSignIn;
    private Button btnShowHideSignIn;
    private Button btnSignInSignIn;
    private TextView txtForgot;
    private boolean isChecked;
    private SyncData syncData;
    private Account acc;

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
                String email = edEmailSignIn.getText().toString();
                String pass = edPassSignIn.getText().toString();
                acc = new Account(email, pass);
                (new LoginThread()).start();
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

    private synchronized void setAcc(Account a){
        acc = a;
    }

    class LoginThread extends Thread {
        @Override
        public void run() {
            SyncData syncData = new SyncData(SignInActivity.this);
            acc = syncData.Login(acc);
            if (acc.getId() != "0") {
                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }
    }
}