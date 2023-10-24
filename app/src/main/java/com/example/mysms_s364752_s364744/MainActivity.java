package com.example.mysms_s364752_s364744;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    }

}