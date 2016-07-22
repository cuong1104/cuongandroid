package com.cuong.cdroid.util;

/**
 * Created by Clover on 5/10/2016.
 * Open Source: This source has been wrote by CuongNguyen
 * Contact: vcuong11s@gmail.com or unme.rf@gmail.com
 */
public final class Log {

    public static void e(String tag, String msg) {
        if (DataUtils.isNull(tag)) tag = "NullTag";
        if (DataUtils.isNull(msg)) msg = "NullMessage";
        int maxLogSize = 1000;
        for (int i = 0; i <= msg.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > msg.length() ? msg.length() : end;
            android.util.Log.e(tag, msg.substring(start, end));
        }
    }

    public static void w(String tag, String msg) {
        if (DataUtils.isNull(tag)) tag = "NullTag";
        if (DataUtils.isNull(msg)) msg = "NullMessage";
        int maxLogSize = 1000;
        for (int i = 0; i <= msg.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > msg.length() ? msg.length() : end;
            android.util.Log.w(tag, msg.substring(start, end));
        }
    }

    public static void i(String tag, String msg) {
        if (DataUtils.isNull(tag)) tag = "NullTag";
        if (DataUtils.isNull(msg)) msg = "NullMessage";
        int maxLogSize = 1000;
        for (int i = 0; i <= msg.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > msg.length() ? msg.length() : end;
            android.util.Log.i(tag, msg.substring(start, end));
        }
    }

    public static void d(String tag, String msg) {
        if (DataUtils.isNull(tag)) tag = "NullTag";
        if (DataUtils.isNull(msg)) msg = "NullMessage";
        int maxLogSize = 1000;
        for (int i = 0; i <= msg.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > msg.length() ? msg.length() : end;
            android.util.Log.d(tag, msg.substring(start, end));
        }
    }

    public static void v(String tag, String msg) {
        if (DataUtils.isNull(tag)) tag = "NullTag";
        if (DataUtils.isNull(msg)) msg = "NullMessage";
        int maxLogSize = 1000;
        for (int i = 0; i <= msg.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > msg.length() ? msg.length() : end;
            android.util.Log.v(tag, msg.substring(start, end));
        }
    }
}
