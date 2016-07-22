package com.cuong.cdroid.holder;

import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import static com.cuong.cdroid.util.DataUtils.isNull;

/**
 * Created by Clover on 7/22/2016.
 * Contact: vcuong11s@gmail.com or unme.rf@gmail.com
 */
public abstract class AppCompatHolder {
    protected AppCompatActivity context;
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static float WIDTH_DESIGN_MAX = 640f;

    public AppCompatHolder(AppCompatActivity context, float widthDesign) {
        this(context);
        WIDTH_DESIGN_MAX = widthDesign;
    }

    public AppCompatHolder(AppCompatActivity context) {
        this.context = context;
        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        SCREEN_WIDTH = metrics.widthPixels;
        SCREEN_HEIGHT = metrics.heightPixels;
        init();
    }

    protected abstract void init();


    public static int fix(int designSize) {
        return (int) (((float) designSize / WIDTH_DESIGN_MAX) * SCREEN_WIDTH);
    }

    public static void fixSizeLinear(View layout, int width, int height) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) layout.getLayoutParams();

        if (width > -10) {
            params.width = width;
        }

        if (height > -10) {
            params.height = height;
        }

        layout.setLayoutParams(params);
        layout.requestLayout();
    }

    public static void fixSizeRelative(View layout, int width, int height) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layout.getLayoutParams();

        if (width > -10) {
            params.width = width;
        }

        if (height > -10) {
            params.height = height;
        }

        layout.setLayoutParams(params);
        layout.requestLayout();
    }

    protected TextView findTextView(int id) {
        return (TextView) context.findViewById(id);
    }

    protected ImageView findImageView(int id) {
        return (ImageView) context.findViewById(id);
    }

    protected CheckBox findCheckBox(int id) {
        return (CheckBox) context.findViewById(id);
    }

    protected RadioButton findRadioButton(int id) {
        return (RadioButton) context.findViewById(id);
    }

    protected RadioGroup findRadioGroup(int id) {
        return (RadioGroup) context.findViewById(id);
    }

    protected ListView findListView(int id) {
        return (ListView) context.findViewById(id);
    }

    protected ToggleButton findToggleButton(int id) {
        return (ToggleButton) context.findViewById(id);
    }

    protected View findView(int id) {
        return context.findViewById(id);
    }

    protected LinearLayout findLinearLayout(int id) {
        return (LinearLayout) context.findViewById(id);
    }

    protected RelativeLayout findRelativeLayout(int id) {
        return (RelativeLayout) context.findViewById(id);
    }

    protected FrameLayout findFrameLayout(int id) {
        return (FrameLayout) context.findViewById(id);
    }
}
