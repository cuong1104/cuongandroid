package com.cuong.lib_nvc_android.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Created by vcuon on 7/20/2015.
 * Open Source: This source has been wrote by CuongNguyen
 * Contact: vcuong11s@gmail.com or unme.rf@gmail.com
 */
public final class DataUtils {
    /**
     * Get Int from String, catch all Exception
     * <p>
     * <i>Warring: if have exception, it will return 0</i>
     * </p>
     *
     * @param num String input
     * @return int number
     */
    public static int GetInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Get Long from String, catch all Exception
     * <p>
     * <i>Warring: if have exception, it will return 0</i>
     * </p>
     *
     * @param num String input
     * @return long number
     */
    public static long GetLong(String num) {
        try {
            return Long.parseLong(num);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Get Float from String, catch all Exception
     * <p>
     * <i>Warring: if have exception, it will return 0</i>
     * </p>
     *
     * @param num String input
     * @return float
     */
    public static float GetFloat(String num) {
        try {
            return Float.parseFloat(num);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Check if a String is null
     * <p>
     * <i>Warring: it will check if string contain 'null', only use to check in api result</i>
     * </p>
     *
     * @param str input
     * @return if input is null, return true
     */
    public static boolean isNull(String str) {
        if (str != null) {
            if (!str.trim().equals("") && !str.trim().equals("null")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if file is exits
     *
     * @param filePath
     * @return
     */
    public static boolean isFileExists(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Round to certain number of decimals
     *
     * @param d            float input
     * @param decimalPlace how many decimal place
     * @return String of float had rounded
     */
    public static String Round(float d, int decimalPlace) {
        String fs = d + "";
        int index = fs.indexOf(".");
        if (isNull(fs) || fs.split("\\.").length > 2) {
            return "0";
        } else {
            if (index < 0) {
                String ds = d + "";
                ds = ds.replaceAll("\\.0", "");
                return ds;
            } else if (index == 0) {
                fs = "0" + fs;
                return Round(GetFloat(fs), decimalPlace);
            } else {
                String result = fs.substring(0, index + decimalPlace + 1);
                result.replaceAll("\\.0", "");
                return result;
            }
        }
    }

    /**
     * Encode String to Base64 String, not wrap with line break
     *
     * @param input
     * @return
     */
    public static String stringToBase64(final String input) {
        return Base64.encodeToString(input.getBytes(), Base64.NO_WRAP);
    }

    /**
     * Decode Base64 to String
     *
     * @param input
     * @return
     */
    public static String base64ToString(final String input) {
        // Receiving side
        byte[] data = Base64.decode(input, Base64.DEFAULT);
        try {
            String text = new String(data, "UTF-8");
            return text;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Convert byte array to hex string
     *
     * @param bytes input
     * @return Hex String
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sbuf = new StringBuilder();
        for (int idx = 0; idx < bytes.length; idx++) {
            int intVal = bytes[idx] & 0xff;
            if (intVal < 0x10) sbuf.append("0");
            sbuf.append(Integer.toHexString(intVal).toUpperCase());
        }
        return sbuf.toString();
    }

    /**
     * Get utf8 byte array.
     *
     * @param str input
     * @return array of NULL if error was found
     */
    public static byte[] getUTF8Bytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Convert inches to Pixel
     *
     * @param context Context
     * @param inch    Value of Inches
     * @return Value of Pixel
     */
    public static float inchesToPixel(Context context, float inch) {
        final DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return inch * TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_IN, 1, dm);
    }

    /**
     * Convert Bitmap to byte array
     *
     * @param bitmap Bitmap
     * @return Byte Array
     */
    public static byte[] bitmapToBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    /**
     * Convert Byte Array to Bitmap
     *
     * @param image Byte Array
     * @return Bitmap
     */
    public static Bitmap bytesToBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
