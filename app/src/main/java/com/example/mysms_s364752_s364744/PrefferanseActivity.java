package com.example.mysms_s364752_s364744;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class PrefferanseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prefferanser_activity);

        Switch notifikasjon = findViewById(R.id.notifikasjon);
        notifikasjon.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                Intent intent = new Intent();
                intent.setAction("com.example.service.MYSIGNAL");
                sendBroadcast(intent);
            } else {
                stoppPeriodisk(notifikasjon);
            }
        });
    }
    public void stoppPeriodisk(View v) {
        Intent i = new Intent(this, MinService.class);
        PendingIntent pintent = PendingIntent.getService(this, 0, i, PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        if (alarm != null) {
            alarm.cancel(pintent);
        }
    }
}
