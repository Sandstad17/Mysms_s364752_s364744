package com.example.mysms_s364752_s364744;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MinBroadcastReceiver extends BroadcastReceiver {
        public MinBroadcastReceiver(){}
        @Override public void onReceive(Context context, Intent intent) {
            Toast.makeText(context.getApplicationContext(), "I BroadcastReceiver",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(context, MinService.class); context.startService(i);
        }
    }

