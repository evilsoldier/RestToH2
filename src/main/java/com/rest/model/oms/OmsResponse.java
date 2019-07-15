package com.rest.model.oms;

import java.util.List;

/**
 * @author Georgi Trendafilov
 */
public class OmsResponse {

    private List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
