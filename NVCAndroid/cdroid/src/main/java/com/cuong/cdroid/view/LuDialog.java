package com.cuong.cdroid.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Window;

import com.cuong.cdroid.R;

/**
 * Created by Clover on 7/18/2016.
 * Contact: vcuong11s@gmail.com or unme.rf@gmail.com
 */
public class LuDialog {
    private Dialog dialog;
    private Context context;

    public LuDialog(Context context) {
        this.context = context;
        dialog = new Dialog(context, android.R.style.Theme_Translucent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //here we set layout of progress dialog
        dialog.setContentView(R.layout.custom_progress_dialog);
    }

    public void show() {
        if (dialog != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            dialog.show();
        }
    }

    public void show(long time){
        show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, time);
    }

    public void dismiss() {
        if (dialog != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }
}
