package com.rest.model.barcode;

public class KohlsBarcode {

    private String mail;
    private String barcode;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "KohlsBarcode{" +
                "mail='" + mail + '\'' +
                ", barcode='" + barcode + '\'' +
                '}';
    }
}
