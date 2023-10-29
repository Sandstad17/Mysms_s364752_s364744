package com.example.mysms_s364752_s364744;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.Calendar;


//Sette periodisk melding basert på definert tid på døgnet
public class SettPeriodiskService extends Service {
    @Nullable
    @Override public IBinder onBind(Intent intent) {
        return null;
    }

    //Hver 24 time i dette tilfellet
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        java.util.Calendar cal = Calendar.getInstance(); Intent i = new Intent(this, MinService.class);
        PendingIntent pintent = PendingIntent.getService(this, 0, i, PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE); alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 24* 60 * 60 * 1000, pintent);
    return super.onStartCommand(intent, flags, startId); }
}
