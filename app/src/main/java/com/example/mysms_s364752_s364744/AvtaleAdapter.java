package com.example.mysms_s364752_s364744;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AvtaleAdapter extends ArrayAdapter<Avtale> {
    private final LayoutInflater inflater;

    public AvtaleAdapter(Context context, List<Avtale> avtale) {
        super(context, R.layout.avtale_liste, avtale);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.avtale_liste, parent, false);
        }

        Avtale avtale = getItem(position);
        if (avtale != null) {
            TextView avtaleTextView = view.findViewById(R.id.avtaleNavnAvtaleListe);
            TextView telefonnummerTextView = view.findViewById(R.id.telefonnummerAvtaleListe);
            TextView stedTextView = view.findViewById(R.id.stedAvtaleListe);
            TextView datoTextView = view.findViewById(R.id.datoAvtaleListe);
            TextView tidTextView = view.findViewById(R.id.tidAvtaleListe);

            avtaleTextView.setText(avtale.getNavnAvtale());
            telefonnummerTextView.setText(avtale.getTelefonnummer());
            stedTextView.setText(avtale.getSted());
            datoTextView.setText(avtale.getDato());
            tidTextView.setText(avtale.getTid());
        }

        return view;
    }
}
