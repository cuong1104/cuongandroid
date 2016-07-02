package com.cuong.lib_nvc_android.util;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Clover on 5/10/2016.
 * Open Source: This source has been wrote by CuongNguyen
 * Contact: vcuong11s@gmail.com or unme.rf@gmail.com
 */
public final class ToastUtils {
    public static Toast toast;
    public static boolean IsDisableMessage = false;

    public static void disable() {
        IsDisableMessage = true;
    }

    public static void enable() {
        IsDisableMessage = false;
    }

    /**
     * Show a Toast message (LENGTH_SHORT), sure that it will show without delay
     *
     * @param context Context
     * @param message Message
     */
    public static void show(final Activity context, final String message) {
        if (IsDisableMessage) {
            return;
        }
        try {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (toast != null) {
                        toast.cancel();
                    }
                    toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Show a Toast message (LENGTH_SHORT), sure that it will show without delay
     *
     * @param context Context
     * @param message Message
     */
    public static void show(final Context context, final String message) {
        Activity activity = (Activity) context;
        show(activity, message);
    }

    /**
     * Show a Toast message (LENGTH_SHORT), sure that it will show without delay
     *
     * @param context  Context
     * @param resource String ResourceId
     */
    public static void show(final Context context, int resource) {
        Activity activity = (Activity) context;
        show(activity, context.getResources().getString(resource));
    }

    /**
     * Show a Toast message (LENGTH_LONG), sure that it will show without delay
     *
     * @param context Activity
     * @param message Message
     */
    public static void showLong(final Activity context, final String message) {
        if (IsDisableMessage) {
            return;
        }
        try {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (toast != null) {
                        toast.cancel();
                    }
                    toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
                    toast.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Show a Toast message (LENGTH_LONG), sure that it will show without delay
     *
     * @param context Context
     * @param message Message
     */
    public static void showLong(final Context context, final String message) {
        Activity activity = (Activity) context;
        showLong(activity, message);
    }

    /**
     * Show a Toast message (LENGTH_LONG), sure that it will show without delay
     *
     * @param context  Context
     * @param resource String ResourceId
     */
    public static void showLong(final Context context, int resource) {
        Activity activity = (Activity) context;
        showLong(activity, context.getResources().getString(resource));
    }

    /**
     * Show Toast with Gravity, LENGTH_SORT
     *
     * @param context Context
     * @param message Message
     * @param gravity Gravity
     */
    public static void show(final Activity context, final String message, final int gravity) {
        if (IsDisableMessage) {
            return;
        }
        try {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (toast != null) {
                        toast.cancel();
                    }
                    toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    if (v != null) v.setGravity(gravity);
                    toast.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Show Toast with Gravity, LENGTH_SORT
     *
     * @param context Context
     * @param message Message
     * @param gravity Gravity
     */
    public static void show(final Context context, final String message, final int gravity) {
        Activity activity = (Activity) context;
        show(activity, message, gravity);
    }

    /**
     * Show Toast with Gravity, LENGTH_SORT
     *
     * @param context  Context
     * @param resource String ResourceId
     * @param gravity  Gravity
     */
    public static void show(final Context context, int resource, final int gravity) {
        Activity activity = (Activity) context;
        show(activity, context.getResources().getString(resource), gravity);
    }

    /**
     * Show Toast with Gravity, LENGTH_LONG
     *
     * @param context Context
     * @param message Message
     * @param gravity Gravity
     */
    public static void showLong(final Activity context, final String message, final int gravity) {
        if (IsDisableMessage) {
            return;
        }
        try {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (toast != null) {
                        toast.cancel();
                    }
                    toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    if (v != null) v.setGravity(gravity);
                    toast.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Show Toast with Gravity, LENGTH_LONG
     *
     * @param context Context
     * @param message Message
     * @param gravity Gravity
     */
    public static void showLong(final Context context, final String message, final int gravity) {
        Activity activity = (Activity) context;
        showLong(activity, message, gravity);
    }

    /**
     * Show Toast with Gravity, LENGTH_LONG
     *
     * @param context  Context
     * @param resource String ResourceId
     * @param gravity  Gravity
     */
    public static void showLong(final Context context, int resource, final int gravity) {
        Activity activity = (Activity) context;
        showLong(activity, context.getResources().getString(resource), gravity);
    }
}
