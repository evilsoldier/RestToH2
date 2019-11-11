package com.rest.model.oms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Georgi Trendafilov
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoreInfo {

    @JsonProperty(value = "ErrorRelatedMoreInfo")
    private String errorRelatedMoreInfo;

    public String getErrorRelatedMoreInfo() {
        return errorRelatedMoreInfo;
    }

    public void setErrorRelatedMoreInfo(String errorRelatedMoreInfo) {
        this.errorRelatedMoreInfo = errorRelatedMoreInfo;
    }
}
