package com.example.mysms_s364752_s364744;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class KontakterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontakter_activity);

        Button nykont = findViewById(R.id.nykontakt);
        Intent nyKontakt = new Intent(this, NykontaktActivity.class);
        nykont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(nyKontakt);
            }
        });
    }
}
