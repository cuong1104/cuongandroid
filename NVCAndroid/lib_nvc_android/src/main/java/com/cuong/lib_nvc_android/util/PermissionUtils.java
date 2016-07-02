package com.cuong.lib_nvc_android.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by Clover on 5/10/2016.
 * Open Source: This source has been wrote by CuongNguyen
 * Contact: vcuong11s@gmail.com or unme.rf@gmail.com
 */
public final class PermissionUtils {

    /**
     * Request single permission
     * <p>
     * <i>Warring, you need to add permission to Manifest first</i>
     * </p>
     *
     * @param activity           current activity
     * @param manifestPermission permission
     * @param requestCode        request code
     */
    public static void requestPermission(Activity activity, String manifestPermission, int requestCode) {
        ActivityCompat.requestPermissions(activity,
                new String[]{manifestPermission},
                requestCode);
    }

    /**
     * Check if permission is granted
     *
     * @param activity           current activity
     * @param manifestPermission permission
     * @return true if permission is granted
     */
    private static boolean isGranted(Activity activity, String manifestPermission) {
        return ContextCompat.checkSelfPermission(activity,
                manifestPermission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Request permissions (list of permission)
     * <p>
     * <i>Warring, you need to add permission to Manifest first</i>
     * </p>
     *
     * @param activity    current activity
     * @param permissions all permission need request
     * @param requestCode request code
     */
    public static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
        if (permissions == null || permissions.length <= 0) {
            return;
        }

        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }

    /**
     * Check on request permission result, it will check all permission again, if have any permission did not granted, take again
     *
     * @param activity    current activity
     * @param permissions permissions
     * @param requestCode request code
     */
    public static void onRequestPermissionsResult(Activity activity, @NonNull String[] permissions, int requestCode) {
        for (String permission : permissions) {
            if (!isGranted(activity, permission)) {
                requestPermissions(activity, permissions, requestCode);
                return;
            }
        }
    }
}
