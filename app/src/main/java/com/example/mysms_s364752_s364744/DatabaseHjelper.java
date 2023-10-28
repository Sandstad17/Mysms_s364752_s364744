package com.example.mysms_s364752_s364744;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHjelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAVN = "avtaleApp.db";
    private static final int DATABASE_VERSION = 2;




    //Tabell for kontakt
    public static final String TABELL_KONTAKTER = "kontakter";
    public static final String KOLONNE_KONTAKT_ID = "kontaktId";
    public static final String KOLONNE_FORNAVN = "fornavn";
    public static final String KOLONNE_ETTERNAVN = "etternavn";
    public static final String KOLONNE_TELEFON_NUMMER = "telefonnummer";


    //CREATE table for kontakter
    private static final String CREATE_TABLE_CONTACTS = "CREATE TABLE " +
            TABELL_KONTAKTER +
            "(" + KOLONNE_KONTAKT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KOLONNE_FORNAVN + " TEXT NOT NULL, " +
            KOLONNE_ETTERNAVN + " TEXT NOT NULL, " +
            KOLONNE_TELEFON_NUMMER + " TEXT NOT NULL)";



    //Tabell for avtale
    public static final String TABELL_AVTALER = "avtaler";
    public static final String KOLONNE_AVTALE_ID = "avtaleId";
    public static final String KOLONNE_AVTALE_NAVN = "navnAvtale";
    public static final String KOLONNE_TELEFON_NUMMER_AVTALE = "telefonnummer";
    public static final String KOLONNE_STED = "sted";
    public static final String KOLONNE_DATO = "dato";
    public static final String KOLONNE_TID = "tid";


    //CREATE table for avtaler
    private static final String CREATE_TABLE_AVTALER = "CREATE TABLE " +
            TABELL_AVTALER +
            "(" + KOLONNE_AVTALE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KOLONNE_AVTALE_NAVN + " TEXT NOT NULL, " +
            KOLONNE_TELEFON_NUMMER_AVTALE + " TEXT NOT NULL, " +
            KOLONNE_STED + " TEXT NOT NULL, " +
            KOLONNE_DATO + " TEXT NOT NULL, " +
            KOLONNE_TID + " TEXT NOT NULL)";

    public DatabaseHjelper(Context context) {
        super(context, DATABASE_NAVN, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACTS);
        db.execSQL(CREATE_TABLE_AVTALER);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            // Perform your database schema upgrade here
            // You can use a switch statement to handle different versions
            switch (oldVersion) {
                case 1:
                    // Upgrade from version 1 to 2
                    db.execSQL("ALTER TABLE " + TABELL_AVTALER + " ADD COLUMN NEW_COLUMN_NAME TEXT");
                    break;
                // Add more cases for each version upgrade
            }
        }
    }
}