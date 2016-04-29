package com.cuong.nvcandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cuong.lib_nvc_android.util.DeviceUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DeviceUtils.showMessage(this, "Good");
    }
}
