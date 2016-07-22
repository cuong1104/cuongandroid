package com.cuong.cdroid.calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

import com.cuong.cdroid.view.Window;


/**
 * Created by unmer_000 on 27/06/2015.
 * Open Source: This source has been wrote by CuongNguyen
 * Contact: vcuong11s@gmail.com or unme.rf@gmail.com
 */
public class AlarmReceiver extends BroadcastReceiver {
    public static Window dialogAlarm;
    public static MediaPlayer mediaAlarm;
    public static boolean enableSound;

    /**
     * Create an alarm with a dialog and media
     * @param dialog Dialog will show when alarm
     * @param media Sound will be play when alarm
     */
    public static void initAlarm(Window dialog, MediaPlayer media){
        initAlarm(dialog);
        mediaAlarm = media;
    }

    /**
     * Create an alarm with a dialog
     * @param dialog Dialog will show when alarm
     */
    public static void initAlarm(Window dialog){
        dialogAlarm = dialog;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Show a dialog of alarm
        if (dialogAlarm != null){
            dialogAlarm.show();
        } else {
            Log.e("UnmeAlarm", "Please init a Window for UnmeAlarm");
        }

        // Play a media for alarm
        if (mediaAlarm != null && enableSound){
            mediaAlarm.start();
        } else {
            Log.e("UnmeAlarm", "Please init a MediaPlayer for UnmeAlarm");
        }
    }

    public static void stopAlarm(){
        // Dismiss a dialog of alarm
        if (dialogAlarm != null){
            dialogAlarm.dismiss();
        } else {
            Log.e("UnmeAlarm", "Please init a Window for UnmeAlarm");
        }

        // Stop a media
        if (mediaAlarm != null && enableSound){
            if (mediaAlarm.isPlaying()) {
                mediaAlarm.stop();
            }
            mediaAlarm.release();
        } else {
            Log.e("UnmeAlarm", "Please init a MediaPlayer for UnmeAlarm");
        }
    }
}
