package com.example.mysms_s364752_s364744;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Avtale {
    private long avtaleId;
    private String navnAvtale;
    private String telefonnummer;
    private String sted;
    private String dato;
    private String tid;

    //Konstruktør med alle parametere


    public Avtale(long avtaleId, String navnAvtale, String telefonnummer, String sted, String dato, String tid) {
        this.avtaleId = avtaleId;
        this.navnAvtale = navnAvtale;
        this.telefonnummer = telefonnummer;
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    //Konstruktør uten Id
    public Avtale(String navnAvtale, String telefonnummer, String sted, String dato, String tid) {
        this.navnAvtale = navnAvtale;
        this.telefonnummer = telefonnummer;
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    //Tom konstruktør
    public Avtale() {

    }

    public long getAvtaleId() {
        return avtaleId;
    }

    public void setAvtaleId(long kontaktId) {
        this.avtaleId = kontaktId;
    }

    public String getNavnAvtale() {
        return navnAvtale;
    }

    public void setNavnAvtale(String navnAvtale) {
        this.navnAvtale = navnAvtale;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }


}
