package com.example.mysms_s364752_s364744;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import java.lang.Override;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;
import java.util.List;

public class KontakterActivity extends AppCompatActivity {

    private AvtaleAppDataKilde dataKilde;
    private ArrayAdapter<Kontakt> kontaktArrayAdapter;
    private List<Kontakt> kontakter;

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

        dataKilde = new AvtaleAppDataKilde(this);
        try {
            dataKilde.open();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /*
        ListView kontaktlista = findViewById(R.id.kontaktliste);

        kontakter = dataKilde.finnAlleKontakter();
        kontaktArrayAdapter = new ArrayAdapter<Kontakt>(this, android.R.layout.simple_list_item_1,kontakter);
        kontaktlista.setAdapter(kontaktArrayAdapter);
         */

        ListView kontaktlista = findViewById(R.id.kontaktliste);

        kontakter = dataKilde.finnAlleKontakter();

        kontaktArrayAdapter = new ArrayAdapter<Kontakt>(this, R.layout.kontakt_liste, kontakter) {
            @NonNull
            @Override
            public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.kontakt_liste, parent, false);
                }

                // Set the text for both the name and phone number
                Kontakt kontakt = getItem(position);
                if (kontakt != null) {
                    TextView kontaktFornavn = convertView.findViewById(R.id.fornavnKontaktListe);
                    TextView kontaktEtternavn = convertView.findViewById(R.id.etternavnKontaktListe);
                    TextView kontaktTelefon = convertView.findViewById(R.id.telefonnummerKontaktListe);
                    kontaktFornavn.setText(kontakt.getFornavn());
                    kontaktEtternavn.setText(kontakt.getEtternavn());
                    kontaktTelefon.setText(kontakt.getTelefonnummer());
                }

                return convertView;
            }
        };

        kontaktlista.setAdapter(kontaktArrayAdapter);
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
}
