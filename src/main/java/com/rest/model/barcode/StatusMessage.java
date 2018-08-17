package com.rest.model.barcode;

public class StatusMessage {

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusMessage{" +
                "status=" + status +
                '}';
    }
}
