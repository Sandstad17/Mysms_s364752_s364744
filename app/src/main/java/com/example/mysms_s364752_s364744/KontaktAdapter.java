package com.example.mysms_s364752_s364744;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class KontaktAdapter extends ArrayAdapter<Kontakt> {
    private final LayoutInflater inflater;

    public KontaktAdapter(Context context, List<Kontakt> kontakter) {
        super(context, R.layout.kontakt_liste, kontakter);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.kontakt_liste, parent, false);
        }

        Kontakt kontakt = getItem(position);
        if (kontakt != null) {
            TextView fornavnTextView = view.findViewById(R.id.fornavnKontaktListe);
            TextView etternavnTextView = view.findViewById(R.id.etternavnKontaktListe);
            TextView telefonnummerTextView = view.findViewById(R.id.telefonnummerKontaktListe);

            fornavnTextView.setText(kontakt.getFornavn());
            etternavnTextView.setText(kontakt.getEtternavn());
            telefonnummerTextView.setText(kontakt.getTelefonnummer());
        }

        return view;
    }
}