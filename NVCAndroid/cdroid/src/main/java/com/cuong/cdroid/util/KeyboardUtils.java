package com.cuong.cdroid.util;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Clover on 5/10/2016.
 * Open Source: This source has been wrote by CuongNguyen
 * Contact: vcuong11s@gmail.com or unme.rf@gmail.com
 */
public final class KeyboardUtils {

    public static void showKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void showKeyBoardOnClick(EditText editText) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showKeyboard(v);
                }
            }
        });
    }

    public static void hiddenKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public static void hiddenKeyboard(Activity activity) {
        try {
            View view = activity.getCurrentFocus();
            if (view != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hiddenKeyboardWhenTouchOutSide(final Activity activity, View view) {

        //Set up touch listener for non-text box views to hide keyboard.
        boolean andBool = true;
        if (!(view instanceof EditText)
                && !(view instanceof Button)
                && !(view instanceof TextView)
                && !(view instanceof ImageView)
                && !(view instanceof Spinner)) {
            view.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    hiddenKeyboard(activity);
                    return true;
                }

            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {

            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

                View innerView = ((ViewGroup) view).getChildAt(i);

                hiddenKeyboardWhenTouchOutSide(activity, innerView);
            }
        }
    }
}
