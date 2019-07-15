package com.rest.model.oms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Georgi Trendafilov
 */
public class Error {

    @JsonProperty(value = "ErrorDescription")
    private String errorDescription;

    @JsonProperty(value = "ErrorUniqueExceptionId")
    private String errorUniqueExceptionId;

    @JsonProperty(value = "ErrorCode")
    private String errorCode;

    @JsonProperty(value = "httpcode")
    private int httpcode;

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorUniqueExceptionId() {
        return errorUniqueExceptionId;
    }

    public void setErrorUniqueExceptionId(String errorUniqueExceptionId) {
        this.errorUniqueExceptionId = errorUniqueExceptionId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public int getHttpcode() {
        return httpcode;
    }

    public void setHttpcode(int httpcode) {
        this.httpcode = httpcode;
    }
}
