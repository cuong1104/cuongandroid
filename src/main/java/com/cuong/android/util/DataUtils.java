package com.cuong.android.util;

import java.io.File;

/**
 * Created by vcuon on 7/20/2015.
 * Open Source: This source has been wrote by CuongNguyen
 * Contact: vcuong11s@gmail.com or unme.rf@gmail.com
 */
public class DataUtils {
    public static int GetInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            return 0;
        }
    }

    public static long GetLong(String num) {
        try {
            return Long.parseLong(num);
        } catch (Exception e) {
            return 0;
        }
    }

    public static float GetFloat(String num) {
        try {
            return Float.parseFloat(num);
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean isNull(String str) {
        if (str != null) {
            if (!str.trim().equals("") && !str.trim().equals("null")) {
                return false;
            }
        }
        return true;
    }

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
     * @param d
     * @param decimalPlace
     * @return
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
}
