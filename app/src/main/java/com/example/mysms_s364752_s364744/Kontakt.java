package com.example.mysms_s364752_s364744;

public class Kontakt {

    private long kontaktId;
    private String fornavn;
    private String etternavn;
    private String telefonnummer;

    //Konstruktør med alle parameter
    public Kontakt(long kontaktId, String fornavn, String etternavn, String telefonnummer) {
        this.kontaktId = kontaktId;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonnummer = telefonnummer;
    }

    //Konstruktør uten Id
    public Kontakt(String fornavn, String etternavn, String telefonnummer) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonnummer = telefonnummer;
    }

    //Tom konstruktør
    public Kontakt() {

    }

    public long getKontaktId() {
        return kontaktId;
    }

    public void setKontaktId(long kontaktId) {
        this.kontaktId = kontaktId;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
}