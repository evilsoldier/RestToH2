package com.rest.model.velocity;

import java.io.Serializable;

public class Efc implements Serializable {

    private static final long serialVersionUID = 1L;

    private String efc;

    private String velocity;

    public Efc() {
        super();
    }

    public Efc(String efc, String velocity) {
        super();
        this.efc = efc;
        this.velocity = velocity;
    }

    public String getEfc() {
        return efc;
    }

    public void setEfc(String efc) {
        this.efc = efc;
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }
}
