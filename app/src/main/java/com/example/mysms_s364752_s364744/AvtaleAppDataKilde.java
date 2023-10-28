package com.example.mysms_s364752_s364744;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;


public class AvtaleAppDataKilde {
    private SQLiteDatabase database;
    private DatabaseHjelper dbHelper;

    public AvtaleAppDataKilde(Context context) {
        dbHelper = new DatabaseHjelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();

    }

    //Kan hende vi må ta en titt på parameterene, er kanskje kun et parameter som skal inn
    public Kontakt leggInnKontakt(String fornavn, String etternavn, String telefonnummer) {
        ContentValues values = new ContentValues();

        values.put(DatabaseHjelper.KOLONNE_FORNAVN, fornavn);
        values.put(DatabaseHjelper.KOLONNE_ETTERNAVN, etternavn);
        values.put(DatabaseHjelper.KOLONNE_TELEFON_NUMMER, telefonnummer);

        long insertId = database.insert(DatabaseHjelper.TABELL_KONTAKTER, null,
                values);
        Cursor cursor = database.query(DatabaseHjelper.TABELL_KONTAKTER, null,
                DatabaseHjelper.KOLONNE_KONTAKT_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Kontakt nyKontakt = cursorTilKontakt(cursor);
        cursor.close();
        return nyKontakt;
    }

    //Kan hende vi må ta en titt på parameterene, er kanskje kun et parameter som skal inn
    public Avtale leggInnAvtale(String navnAvtale, String telefonnummer, String sted, String dato, String tid) {
        ContentValues values = new ContentValues();

        values.put(DatabaseHjelper.KOLONNE_AVTALE_NAVN, navnAvtale);
        values.put(DatabaseHjelper.KOLONNE_TELEFON_NUMMER_AVTALE, telefonnummer);
        values.put(DatabaseHjelper.KOLONNE_STED, sted);
        values.put(DatabaseHjelper.KOLONNE_DATO, dato);
        values.put(DatabaseHjelper.KOLONNE_TID, tid);

        long insertId = database.insert(DatabaseHjelper.TABELL_AVTALER, null,
                values);
        Cursor cursor = database.query(DatabaseHjelper.TABELL_AVTALER, null,
                DatabaseHjelper.KOLONNE_AVTALE_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Avtale nyAvtale = cursorTilAvtale(cursor);
        cursor.close();
        return nyAvtale;
    }

    //Cursor til kontakt
    private Kontakt cursorTilKontakt(Cursor cursor) {
        Kontakt kontakt = new Kontakt(); //Vurdere og lage tom konstruktør?
        kontakt.setKontaktId(cursor.getLong(cursor.getColumnIndexOrThrow(
                DatabaseHjelper.KOLONNE_KONTAKT_ID)));
        kontakt.setFornavn(cursor.getString(cursor.getColumnIndexOrThrow(
                DatabaseHjelper.KOLONNE_FORNAVN)));
        kontakt.setEtternavn(cursor.getString(cursor.getColumnIndexOrThrow(
                DatabaseHjelper.KOLONNE_ETTERNAVN)));
        kontakt.setTelefonnummer(cursor.getString(cursor.getColumnIndexOrThrow(
                DatabaseHjelper.KOLONNE_TELEFON_NUMMER)));
        return kontakt;
    }


    //Cursor til Avtale
    private Avtale cursorTilAvtale(Cursor cursor) {
        Avtale avtale = new Avtale(); //Vurdere og lage tom konstruktør?
        avtale.setAvtaleId(cursor.getLong(cursor.getColumnIndexOrThrow(
                DatabaseHjelper.KOLONNE_AVTALE_ID)));
        avtale.setTelefonnummer(cursor.getString(cursor.getColumnIndexOrThrow(
                DatabaseHjelper.KOLONNE_AVTALE_NAVN)));
        avtale.setSted(cursor.getString(cursor.getColumnIndexOrThrow(
                DatabaseHjelper.KOLONNE_TELEFON_NUMMER_AVTALE)));
        avtale.setSted(cursor.getString(cursor.getColumnIndexOrThrow(
                DatabaseHjelper.KOLONNE_STED)));
        avtale.setDato(cursor.getString(cursor.getColumnIndexOrThrow(
                DatabaseHjelper.KOLONNE_DATO)));
        avtale.setTid(cursor.getString(cursor.getColumnIndexOrThrow(
                DatabaseHjelper.KOLONNE_TID)));
        return avtale;
    }


    //Metode for å finne alle objekter av Kontakt
    public List<Kontakt> finnAlleKontakter() {
        List<Kontakt> kontakter = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHjelper.TABELL_KONTAKTER, null,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Kontakt kontakt = cursorTilKontakt(cursor);
            kontakter.add(kontakt);
            cursor.moveToNext();
        }
        cursor.close();
        return kontakter;
    }


    //Metode for å finne alle objekter av Avtaler
    public List<Avtale> finnAlleAvtaler() {
        List<Avtale> avtaler = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHjelper.TABELL_AVTALER, null,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Avtale avtale = cursorTilAvtale(cursor);
            avtaler.add(avtale);
            cursor.moveToNext();
        }
        cursor.close();
        return avtaler;
    }


    //Slette Kontakt fra Database
    public void slettKontakt(long kontaktId) {
        database.delete(DatabaseHjelper.TABELL_KONTAKTER,
                DatabaseHjelper.KOLONNE_KONTAKT_ID + " =? ", new
                        String[]{Long.toString(kontaktId)});
    }


    //Slette Avtale fra Database
    public void slettAvtale(long avtaleId) {
        database.delete(DatabaseHjelper.TABELL_AVTALER,
                DatabaseHjelper.KOLONNE_AVTALE_ID + " =? ", new
                        String[]{Long.toString(avtaleId)});
    }

}
