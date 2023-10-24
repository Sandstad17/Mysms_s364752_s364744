package com.example.mysms_s364752_s364744;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Avtale {
    private long avtaleId;
    private String navnAvtale;
    private int telefonnummer;
    private String sted;
    private LocalDate dato;
    private LocalTime tid;

    //Konstruktør med alle parametere


    public Avtale(long avtaleId, String navnAvtale, int telefonnummer, String sted, LocalDate dato, LocalTime tid) {
        this.avtaleId = avtaleId;
        this.navnAvtale = navnAvtale;
        this.telefonnummer = telefonnummer;
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    //Konstruktør uten Id
    public Avtale(String navnAvtale, int telefonnummer, String sted, LocalDate dato, LocalTime tid) {
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

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }


}
