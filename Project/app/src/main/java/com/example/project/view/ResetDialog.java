package com.example.project.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.project.R;

class ResetDialog {
    private Activity activity;
    private AlertDialog alertDialog;

    ResetDialog(Activity myActivity) {
        activity = myActivity;
    }

    public void startResetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.reset_dialog, null);

        Rect displayRectangle = new Rect();
        layout.setMinimumWidth((int)(displayRectangle.width() * 0.9f));
        layout.setMinimumHeight((int)(displayRectangle.height() * 0.9f));

        builder.setView(inflater.inflate(R.layout.reset_dialog, null));
        builder.setCancelable(true);
        alertDialog = builder.create();

        Window window = alertDialog.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.copyFrom(alertDialog.getWindow().getAttributes());
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);

        alertDialog.show();
        alertDialog.getWindow().setAttributes(wlp);
    }

    public void dismissResetDialog() {
        alertDialog.dismiss();
    }
}
