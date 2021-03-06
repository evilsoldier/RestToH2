package com.rest.model.barcode;

public class KohlsBarcodeResponse {

    private String barcode;

    private int pin;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "KohlsBarcodeResponse{" +
                "barcode='" + barcode + '\'' +
                ", pin=" + pin +
                '}';
    }
}
