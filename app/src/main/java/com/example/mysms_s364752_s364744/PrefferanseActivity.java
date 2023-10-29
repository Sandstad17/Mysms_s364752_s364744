package com.example.mysms_s364752_s364744;

import android.content.Intent;
import android.os.Bundle;
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
                // denne må lages
                // stopPeriodicService(notifikasjoner);
            }
        });
    }
}
