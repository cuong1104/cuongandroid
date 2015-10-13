package com.cuong.android.view;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by vcuon on 7/23/2015.
 */
public class CoolDialog {
    private ProgressDialog dialog;
    private Context context;

    public CoolDialog(Context context){
        this.context = context;
        dialog = new ProgressDialog(context);
        dialog.setMessage("Saving...");
    }

    public void show() {
        if (dialog != null){
            if (dialog.isShowing()){
                dialog.dismiss();
            }
            dialog.show();
        }
    }

    public void show(String message) {
        if (dialog != null){
            dialog.setMessage(message);
            if (!dialog.isShowing()){
                show();
            }
        }
    }

    public void dismiss() {
        if (dialog != null){
            if (dialog.isShowing()){
                dialog.dismiss();
            }
        }
    }
}
