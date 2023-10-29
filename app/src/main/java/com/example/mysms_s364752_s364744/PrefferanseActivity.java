package com.example.mysms_s364752_s364744;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

//Preferanse til å sette standarmelding, tidspunkt og skru av og på service
public class PrefferanseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prefferanser_activity);

        //Kode for å sjekke om service er av eller på
        Switch notifikasjon = findViewById(R.id.notifikasjon);
        notifikasjon.setOnCheckedChangeListener((compoundButton, b) -> {
            //Service er på
            if (b) {
                Intent intent = new Intent();
                intent.setAction("com.example.service.SettPeriodisk");
                sendBroadcast(intent);

                //Sette verdier som tidspunkt og standardmelding til preferences.
                //Og sende dette globalt som kan brukes i minService klassen.

            } else {
                stoppPeriodisk(notifikasjon);
            }
        });
    }

    //Stoppe periodisk
    public void stoppPeriodisk(View v) {
        Intent i = new Intent(this, MinService.class);
        PendingIntent pintent = PendingIntent.getService(this, 0, i, PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        if (alarm != null) {
            alarm.cancel(pintent);
        }
    }
}
