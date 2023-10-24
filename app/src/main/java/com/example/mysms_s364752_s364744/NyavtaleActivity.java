package com.example.mysms_s364752_s364744;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class NyavtaleActivity extends AppCompatActivity {

    //DATABASE KODE
    private AvtaleAppDataKilde dataKilde;


    //Liste og edittext av Avtale
    private ArrayAdapter<Avtale> avtaleArrayAdapter;
    private List<Avtale> avtaler;

    private EditText avtaleNavnEditText;
    private EditText stedEditText;
    private EditText datoEditText;
    private EditText tidEditText;
    private EditText nummerEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nyavtale_activity);

        //Til å åpne SQLite
        dataKilde = new AvtaleAppDataKilde(this);
        try {
            dataKilde.open();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Avtale navn, sted, dato, tid og nummer
        avtaleNavnEditText = findViewById(R.id.editTextAvtaleNavn);
        stedEditText = findViewById(R.id.editTextSted);
        datoEditText = findViewById(R.id.editTextDato);
        tidEditText = findViewById(R.id.editTextTid);
        nummerEditText = findViewById(R.id.editTextTelefonnummer);


        Button leggtilButton = findViewById(R.id.leggTilAvtale);
        leggtilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avtaleNavn = avtaleNavnEditText.getText().toString();
                String sted = stedEditText.getText().toString();
                LocalDate dato = LocalDate.parse(datoEditText.getText().toString());
                String tid = tidEditText.getText().toString();
                int nummer = Integer.parseInt(nummerEditText.getText().toString());
                if (!avtaleNavn.isEmpty() && !sted.isEmpty() && !tid.isEmpty()) {
                    Avtale avtale = dataKilde.leggInnAvtale(avtaleNavn, nummer, sted, dato, LocalTime.parse(tid));
                    avtaleArrayAdapter.add(avtale);
                    avtaleNavnEditText.setText("");
                    stedEditText.setText("");
                    datoEditText.setText("");
                    tidEditText.setText("");
                    nummerEditText.setText("");
                }
            }
        });


    }


}
