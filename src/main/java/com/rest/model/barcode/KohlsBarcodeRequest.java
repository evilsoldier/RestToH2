package com.rest.model.barcode;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"eventId", "kcAmount"})
public class KohlsBarcodeRequest {


    private String eventId;
    private Double kcAmount;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Double getKcAmount() {
        return kcAmount;
    }

    public void setKcAmount(Double kcAmount) {
        this.kcAmount = kcAmount;
    }

    @Override
    public String toString() {
        return "KohlsBarcodeRequest{" +
                "eventId='" + eventId + '\'' +
                ", kcAmount=" + kcAmount +
                '}';
    }
}
