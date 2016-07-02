package com.cuong.nvcandroid;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cuong.lib_nvc_android.calendar.DateUtils;
import com.cuong.lib_nvc_android.util.DeviceUtils;
import com.cuong.lib_nvc_android.util.PermissionUtils;
import com.cuong.lib_nvc_android.util.ToastUtils;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtils.show(this, "Good");
        ToastUtils.show(this, "Good");
        ToastUtils.show(this, "Good");
        ToastUtils.show(this, "Very Good");
        ToastUtils.show(this, "Very Good");
        ToastUtils.show(this, "This is feature branch");
        PermissionUtils.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        tvHello = (TextView) findViewById(R.id.tvHello);
        if (!DeviceUtils.isGPSEnable(this)) {
            DeviceUtils.turnGPSOn(this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            PermissionUtils.onRequestPermissionsResult(MainActivity.this, permissions, requestCode);
        }
    }
}
