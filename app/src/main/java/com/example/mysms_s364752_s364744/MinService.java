package com.example.mysms_s364752_s364744;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MinService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Minservice", "Service laget");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "I MinService",
                Toast.LENGTH_SHORT).show(); Log.d("Minservice","I min service");
        return flags;
    }
    @Override
    public void onDestroy() {
        super.onDestroy(); Log.d("Minservice", "Service 5ernet");
    }
}

