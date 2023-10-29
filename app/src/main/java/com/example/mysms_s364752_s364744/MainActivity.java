package com.example.mysms_s364752_s364744;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AvtaleAppDataKilde dataKilde;
    private ArrayAdapter<Avtale> avtaleArrayAdapter;
    private List<Avtale> avtaler;

    private static final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;
    private EditText telefon;
    private EditText melding;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BroadcastReceiver myBroadcastReceiver = new MinBroadcastReceiver();
        IntentFilter filter = new IntentFilter("com.example.service.MITTSIGNAL");
        filter.addAction("com.example.service.MITTSIGNAL");
        this.registerReceiver(myBroadcastReceiver, filter);

        //Sjekker status på om tillatelser er gitt hvis ikke kommer det dialog med spørsmål
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new
                            String[]{android.Manifest.permission.SEND_SMS},
                    SEND_SMS_PERMISSION_REQUEST_CODE);
        }

        Button kontakter = findViewById(R.id.kontakter);
        Intent kontaktliste = new Intent(this, KontakterActivity.class);
        kontakter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(kontaktliste);
            }
        });


        Button prefferanser = findViewById(R.id.prefferanser);
        Intent prefferanse = new Intent(this, PrefferanseActivity.class);
        prefferanser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(prefferanse);
            }
        });

        Button nyAvtale = findViewById(R.id.avtale);
        Intent nyavtale = new Intent(this, NyavtaleActivity.class);
        nyAvtale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(nyavtale);
            }
        });


        dataKilde = new AvtaleAppDataKilde(this);
        try {
            dataKilde.open();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ListView avtalelista = findViewById(R.id.avtaleliste);

        avtaler = dataKilde.finnAlleAvtaler();
        avtaleArrayAdapter = new AvtaleAdapter(this, avtaler);
        avtalelista.setAdapter(avtaleArrayAdapter);
    }

    @Override
    protected void onResume() {
        try {
            dataKilde.open();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataKilde.close();
        super.onPause();
    }

    //popup boks sjekker om tillatese er gitt og sier da ifra om at du kan sende sms
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode ==SEND_SMS_PERMISSION_REQUEST_CODE) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText( this, "SMS tillatelse gitt.",
                    Toast.LENGTH_SHORT).show(); // Permission granted, you can now send SMS
        }
        else {
            Toast.makeText( this, "SMS tillatelse ikke gitt. Du kan ikke sende SMS.", Toast.LENGTH_SHORT
            ).show();
            }
        }
    }
    //Ved et eventuelt klikk på send broadcast/eller aktivering
    public void sendBroadcast(View v){
        Intent intent = new Intent();
        intent.setAction("com.example.service.MITTSIGNAL");
        sendBroadcast(intent);
    }

    public void settPeriodisk(View v) {
        Intent intent = new Intent(this,SettPeriodiskService.class);
        this.startService(intent);
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
