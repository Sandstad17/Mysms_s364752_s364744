package com.example.mysms_s364752_s364744;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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


        ListView kontaktlista = findViewById(R.id.kontaktliste);

        kontakter = dataKilde.finnAlleKontakter();
        kontaktArrayAdapter = new KontaktAdapter(this, kontakter);
        kontaktlista.setAdapter(kontaktArrayAdapter);

        //Slette bruker
        Button slettKontakt = findViewById(R.id.slett);
        EditText telefonnummerSlettEditText = findViewById(R.id.telefonnummerSlett); // Retrieve the EditText
        slettKontakt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telefonnummerSlett = telefonnummerSlettEditText.getText().toString(); // Get the text from the EditText
                dataKilde.slettKontakt(telefonnummerSlett); // Pass the phone number to the deletion method
                // Optionally clear the EditText after deletion if needed:
                telefonnummerSlettEditText.setText("");
                // Notify the adapter to refresh the list view
                kontaktArrayAdapter.notifyDataSetChanged();
            }
        });
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
