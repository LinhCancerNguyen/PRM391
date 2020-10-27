package com.example.project.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText edEmailForgot;
    private Button btnReset;
    private TextView txtResetMgs;
    private Button btnReturnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edEmailForgot = findViewById(R.id.edEmailForgot);
        btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ForgotPasswordActivity.this);
                dialog.setContentView(R.layout.reset_dialog);

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.reset_dialog, null);

                Rect displayRectangle = new Rect();
                layout.setMinimumWidth((int)(displayRectangle.width() * 0.9f));
                layout.setMinimumHeight((int)(displayRectangle.height() * 0.9f));

                Window window = dialog.getWindow();
                window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.gravity = Gravity.BOTTOM;
                wlp.copyFrom(dialog.getWindow().getAttributes());
                wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
                wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                window.setAttributes(wlp);

                dialog.getWindow().setAttributes(wlp);
                dialog.show();

                btnReturnSignIn = dialog.findViewById(R.id.btnReturnSignIn);
                txtResetMgs = dialog.findViewById(R.id.txtResetMgs);

                txtResetMgs.setText("Please reset your password with the link sent to\nlinhnttse05291@fpt.edu.vn and proceed to login");
                btnReturnSignIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ForgotPasswordActivity.this, SignInActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
}