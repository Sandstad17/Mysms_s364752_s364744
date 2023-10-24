package com.example.mysms_s364752_s364744;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;
import java.util.List;

public class NykontaktActivity extends AppCompatActivity {
    //DATABASE KODE
    private AvtaleAppDataKilde dataKilde;


    //Liste av og edittext Kontakt
    private ArrayAdapter<Kontakt> kontaktArrayAdapter;
    private List<Kontakt> kontakter;
    private EditText fornavnEditText;
    private EditText etternavnEditText;
    private EditText telefonnummerEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nykontakt_activity);

        //Til å åpne SQLite
        dataKilde = new AvtaleAppDataKilde(this);
        try {
            dataKilde.open();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Fornavn, etternavn og telefonnummer
        fornavnEditText = findViewById(R.id.editTextText);
        etternavnEditText = findViewById(R.id.editTextText2);
        telefonnummerEditText = findViewById(R.id.editTextPhone);


        Button leggtilButton = findViewById(R.id.leggTilKontakt);
        leggtilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fornavn = fornavnEditText.getText().toString();
                String etternavn = etternavnEditText.getText().toString();
                String telefonnummer = telefonnummerEditText.getText().toString();
                if (!fornavn.isEmpty() && !etternavn.isEmpty() && !telefonnummer.isEmpty()) {
                    Kontakt kontakt = dataKilde.leggInnKontakt(fornavn, etternavn, Integer.parseInt(telefonnummer));
                    kontaktArrayAdapter.add(kontakt);
                    fornavnEditText.setText("");
                    etternavnEditText.setText("");
                    telefonnummerEditText.setText("");
                }
            }
        });

    }
}